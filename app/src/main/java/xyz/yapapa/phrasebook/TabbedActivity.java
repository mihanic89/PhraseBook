package xyz.yapapa.phrasebook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Priority;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * Экран с карточками: вкладки по категориям и озвучка нажатий на родном и изучаемом языке.
 */
public class TabbedActivity extends AppCompatActivity implements TTSListener {

    private static final String PREF_POSITION = "state_position_index";

    private TtsSpeaker ttsOriginal;
    private TtsSpeaker ttsTranslation;
    private SharedPreferences prefs;
    private ViewPager2 viewPager;
    private AdView adView;
    private boolean missingVoiceReported = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);

        prefs = getSharedPreferences("language", Context.MODE_PRIVATE);
        String languageTranslate = prefs.getString("languageTranslate", "en");
        String languageDefault = prefs.getString("languageDefault", "ru");

        // как системная кнопка «Назад»: позиция вкладки сохранится в onPause
        findViewById(R.id.buttonBack).setOnClickListener(v -> getOnBackPressedDispatcher().onBackPressed());

        loadBackground();
        setupPager(languageDefault, languageTranslate, savedInstanceState == null);

        ttsOriginal = new TtsSpeaker(this, languageDefault, this::onTtsUnavailable);
        ttsTranslation = new TtsSpeaker(this, languageTranslate, this::onTtsUnavailable);

        adView = findViewById(R.id.adView2);
        // согласие собирается на стартовом экране; без него реклама не запрашивается
        if (AdConsent.canRequestAds(this)) {
            AdConsent.startMobileAds(this);
            adView.loadAd(new AdRequest.Builder().build());
        }
    }

    private void loadBackground() {
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        GlideApp.with(this)
                .load(R.mipmap.background)
                .priority(Priority.LOW)
                .override(width / 3, height / 3)
                .fitCenter()
                .placeholder(R.color.background)
                .transition(withCrossFade(1000))
                .into((ImageView) findViewById(R.id.imageViewBackground2));
    }

    private void setupPager(String languageDefault, String languageTranslate, boolean restoreFromPrefs) {
        viewPager = findViewById(R.id.container);
        viewPager.setAdapter(new CategoryPagerAdapter(this, languageDefault, languageTranslate));

        TabLayout tabLayout = findViewById(R.id.tabs);
        final Category[] categories = Category.values();
        new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
            View view = getLayoutInflater().inflate(R.layout.customtab, tabLayout, false);
            view.findViewById(R.id.icon).setBackgroundResource(categories[position].iconRes);
            tab.setCustomView(view);
            tab.setContentDescription(categories[position].titleRes);
        }).attach();

        if (restoreFromPrefs) {
            int saved = prefs.getInt(PREF_POSITION, 0);
            if (saved >= 0 && saved < categories.length) {
                viewPager.setCurrentItem(saved, false);
            }
        }
    }

    /**
     * Озвучка недоступна (один раз за экран). Экран установки голосов открываем только
     * когда данные можно доустановить: для неподдерживаемого языка (например, белорусского
     * в Google TTS) он бесполезен.
     */
    private void onTtsUnavailable(boolean installable) {
        if (missingVoiceReported || isFinishing()) return;
        missingVoiceReported = true;
        Toast.makeText(getApplicationContext(),
                installable ? R.string.tts_missing_data : R.string.tts_not_supported,
                Toast.LENGTH_LONG).show();
        if (!installable) return;
        try {
            Intent install = new Intent(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
            install.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(install);
        } catch (RuntimeException ignored) {
            // на устройстве нет экрана установки голосов
        }
    }

    @Override
    public void speakTranslate(String text) {
        ttsTranslation.speak(text);
    }

    @Override
    public void speakDefault(String text) {
        ttsOriginal.speak(text);
    }

    @Override
    protected void onPause() {
        adView.pause();
        prefs.edit().putInt(PREF_POSITION, viewPager.getCurrentItem()).apply();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adView.resume();
    }

    @Override
    protected void onDestroy() {
        ttsTranslation.shutdown();
        ttsOriginal.shutdown();
        adView.destroy();
        super.onDestroy();
    }

    /** Страницы создаются по требованию, состояние хранит сам ViewPager2. */
    private static final class CategoryPagerAdapter extends FragmentStateAdapter {
        private final String originalLanguage;
        private final String translationLanguage;

        CategoryPagerAdapter(FragmentActivity activity, String originalLanguage, String translationLanguage) {
            super(activity);
            this.originalLanguage = originalLanguage;
            this.translationLanguage = translationLanguage;
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return CategoryFragment.newInstance(Category.values()[position], originalLanguage, translationLanguage);
        }

        @Override
        public int getItemCount() {
            return Category.values().length;
        }
    }
}
