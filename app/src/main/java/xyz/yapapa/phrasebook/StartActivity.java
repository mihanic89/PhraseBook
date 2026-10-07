package xyz.yapapa.phrasebook;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Priority;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * Стартовый экран: выбор изучаемого языка, переход к карточкам, справка и политика конфиденциальности.
 * Родной язык берётся из языка телефона, если он поддерживается, иначе английский.
 */
public class StartActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String PRIVACY_POLICY_URL = "https://apps.mayak.net.ru/private-policy-phrasebook";

    /** Файл настроек, который раньше создавал PreferenceManager.getDefaultSharedPreferences. */
    private static final String APP_PREFS_SUFFIX = "_preferences";
    private static final String KEY_FIRST_START = "firstStart";

    private static final String LANGUAGE_PREFS = "language";
    private static final String KEY_TRANSLATE = "languageTranslate";
    private static final String KEY_DEFAULT = "languageDefault";

    private Spinner languageSpinner;
    /** Коды языков в том же порядке, что и строки в спиннере. */
    private List<String> locales;
    private AdView adView;
    private View adPrivacyLink;
    private boolean adLoaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupAdsDebug();
        setContentView(R.layout.activity_start);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.start_root), (v, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return insets;
        });

        loadBackground();
        setupLanguageSpinner();

        adView = findViewById(R.id.adView);
        adPrivacyLink = findViewById(R.id.textViewAdPrivacy);
        adPrivacyLink.setOnClickListener(v -> AdConsent.showPrivacyOptions(this, this::onConsentGathered));

        findViewById(R.id.textViewPolicy).setOnClickListener(v ->
                startSafely(new Intent(Intent.ACTION_VIEW, Uri.parse(PRIVACY_POLICY_URL))));

        // согласие, полученное в прошлый раз, действует сразу — не ждём ответа сервера
        loadAdIfAllowed();
        AdConsent.gather(this, this::onConsentGathered);
    }

    /** Форма согласия закрыта или не нужна: реклама, пункт настроек и справка при первом запуске. */
    private void onConsentGathered() {
        if (isFinishing() || isDestroyed()) return;
        loadAdIfAllowed();
        adPrivacyLink.setVisibility(AdConsent.isPrivacyOptionsRequired(this) ? View.VISIBLE : View.GONE);
        showIntroOnFirstStart();
    }

    private void loadAdIfAllowed() {
        if (adLoaded || !AdConsent.canRequestAds(this)) return;
        adLoaded = true;
        AdConsent.startMobileAds(this);
        adView.loadAd(new AdRequest.Builder().build());
    }

    /** Открывает внешний экран; если на устройстве нет подходящего приложения, ничего не делает. */
    private void startSafely(Intent intent) {
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException ignored) {
            // нет браузера или экрана настроек озвучки (бывает у некоторых производителей)
        }
    }

    private void setupAdsDebug() {
        if (BuildConfig.DEBUG) {
            // тестовые устройства разработчика: реклама в отладочных сборках без риска для аккаунта
            MobileAds.setRequestConfiguration(new RequestConfiguration.Builder()
                    .setTestDeviceIds(Arrays.asList(
                            "A4203BC89A24BEEC45D1111F16D2F0A3", // Nexus 5X
                            "4174C23AC2A2DAFD78A7C0F0DFB39F3E")) // Samsung A50
                    .build());
        }
    }

    /** При самом первом запуске показываем справку. */
    private void showIntroOnFirstStart() {
        SharedPreferences appPrefs = getSharedPreferences(getPackageName() + APP_PREFS_SUFFIX, MODE_PRIVATE);
        if (appPrefs.getBoolean(KEY_FIRST_START, true)) {
            appPrefs.edit().putBoolean(KEY_FIRST_START, false).apply();
            startActivity(new Intent(this, IntroActivity.class));
        }
    }

    private void loadBackground() {
        int width = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels;
        GlideApp.with(this)
                .load(R.mipmap.background)
                .priority(Priority.LOW)
                .override(width / 2, height / 2)
                .fitCenter()
                .placeholder(R.color.background)
                .transition(withCrossFade(1000))
                .into((ImageView) findViewById(R.id.imageViewBackground));
    }

    private void setupLanguageSpinner() {
        languageSpinner = findViewById(R.id.languageSelect);
        languageSpinner.setOnItemSelectedListener(this);

        List<String> names = makeLanguageList(Locale.getDefault().getLanguage());
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.simple_spinner_custom_item, names);
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_custom_item);
        languageSpinner.setAdapter(adapter);

        String saved = getSharedPreferences(LANGUAGE_PREFS, Context.MODE_PRIVATE).getString(KEY_TRANSLATE, "en");
        int index = locales.indexOf(saved);
        languageSpinner.setSelection(Math.max(index, 0));
    }

    /**
     * Языки для спиннера, без родного. Заодно запоминает родной язык: язык телефона,
     * если он есть в списке, иначе английский.
     */
    private List<String> makeLanguageList(String phoneLanguage) {
        // код языка, флаг, название; порядок — как в списке выбора
        final String[][] supported = {
                {"en", "🇬🇧", getString(R.string.enLanguage)},
                {"ru", "🇷🇺", getString(R.string.ruLanguage)},
                {"zh", "🇨🇳", getString(R.string.zhLanguage)},
                {"fr", "🇫🇷", getString(R.string.frLanguage)},
                {"de", "🇩🇪", getString(R.string.deLanguage)},
                {"it", "🇮🇹", getString(R.string.itLanguage)},
                {"es", "🇪🇸", getString(R.string.spLanguage)},
                {"pt", "🇵🇹", getString(R.string.ptLanguage)},
                {"fi", "🇫🇮", getString(R.string.fiLanguage)},
                {"be", "🇧🇾", getString(R.string.beLanguage)},
                {"uk", "🇺🇦", getString(R.string.ukLanguage)},
        };

        String originalLanguage = "en";
        for (String[] item : supported) {
            if (item[0].equals(phoneLanguage)) originalLanguage = phoneLanguage;
        }
        getSharedPreferences(LANGUAGE_PREFS, Context.MODE_PRIVATE).edit()
                .putString(KEY_DEFAULT, originalLanguage).apply();

        List<String> names = new ArrayList<>();
        locales = new ArrayList<>();
        for (String[] item : supported) {
            if (!item[0].equals(originalLanguage)) {
                names.add(item[1] + " " + item[2]);
                locales.add(item[0]);
            }
        }
        return names;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        getSharedPreferences(LANGUAGE_PREFS, Context.MODE_PRIVATE).edit()
                .putString(KEY_TRANSLATE, locales.get(position)).apply();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    /** onClick из activity_start.xml */
    public void help(View v) {
        startActivity(new Intent(this, IntroActivity.class));
    }

    /** onClick из activity_start.xml */
    public void settings(View v) {
        Intent intent = new Intent("com.android.settings.TTS_SETTINGS");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startSafely(intent);
    }

    /** onClick из activity_start.xml */
    public void share(View v) {
        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.tryIt) + getString(R.string.link));
        startActivity(Intent.createChooser(sharingIntent, getString(R.string.shareVia)));
    }

    /** onClick из activity_start.xml */
    public void startLearn(View v) {
        startActivity(new Intent(this, TabbedActivity.class));
    }

    @Override
    protected void onPause() {
        adView.pause();
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        adView.resume();
    }

    @Override
    protected void onDestroy() {
        adView.destroy();
        super.onDestroy();
    }
}
