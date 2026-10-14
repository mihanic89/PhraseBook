package xyz.yapapa.phrasebook;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.SystemBarStyle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/**
 * Справка: восемь слайдов с подсказками, кнопки «Пропустить» и «Далее» / «Готово».
 */
public class IntroActivity extends AppCompatActivity {

    private static final int[] TITLES = {
            R.string.help1, R.string.help2, R.string.help3, R.string.help4,
            R.string.help5, R.string.help6, R.string.help7, R.string.help8};
    private static final int[] TEXTS = {
            R.string.help1text, R.string.help2text, R.string.help3text, R.string.help4text,
            R.string.help5text, R.string.help6text, R.string.help7text, R.string.help8text};
    private static final int[] IMAGES = {
            R.drawable.intro1, R.drawable.intro2, R.drawable.intro3, R.drawable.intro4,
            R.drawable.intro5, R.drawable.intro6, R.drawable.intro7, R.drawable.intro8};

    private ViewPager2 pager;
    private Button nextButton;
    private LinearLayout dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // фон зелёный: светлые значки в строке состояния и навигации
        EdgeToEdge.enable(this,
                SystemBarStyle.dark(Color.TRANSPARENT), SystemBarStyle.dark(Color.TRANSPARENT));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.intro_root), (v, insets) -> {
            Insets bars = insets.getInsets(
                    WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout());
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom);
            return WindowInsetsCompat.CONSUMED;
        });

        pager = findViewById(R.id.introPager);
        pager.setAdapter(new SlideAdapter());
        nextButton = findViewById(R.id.introNext);
        dots = findViewById(R.id.introDots);
        createDots();

        findViewById(R.id.introSkip).setOnClickListener(v -> finish());
        nextButton.setOnClickListener(v -> {
            int next = pager.getCurrentItem() + 1;
            if (next < TITLES.length) {
                pager.setCurrentItem(next);
            } else {
                finish();
            }
        });
        pager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                updateControls(position);
            }
        });
        updateControls(pager.getCurrentItem());
    }

    private void createDots() {
        int size = getResources().getDimensionPixelSize(R.dimen.intro_dot_size);
        int margin = size / 2;
        for (int i = 0; i < TITLES.length; i++) {
            View dot = new View(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(size, size);
            params.setMargins(margin, 0, margin, 0);
            dot.setLayoutParams(params);
            dot.setBackgroundResource(R.drawable.intro_dot);
            dots.addView(dot);
        }
    }

    private void updateControls(int position) {
        for (int i = 0; i < dots.getChildCount(); i++) {
            dots.getChildAt(i).setAlpha(i == position ? 1f : 0.4f);
        }
        boolean last = position == TITLES.length - 1;
        nextButton.setText(last ? R.string.intro_done : R.string.intro_next);
    }

    private static final class SlideAdapter extends RecyclerView.Adapter<SlideAdapter.Holder> {

        static final class Holder extends RecyclerView.ViewHolder {
            final TextView title;
            final ImageView image;
            final TextView text;

            Holder(View view) {
                super(view);
                title = view.findViewById(R.id.slideTitle);
                image = view.findViewById(R.id.slideImage);
                text = view.findViewById(R.id.slideText);
                ViewCompat.setAccessibilityHeading(title, true);
            }
        }

        @NonNull
        @Override
        public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new Holder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.intro_slide, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull Holder holder, int position) {
            holder.title.setText(TITLES[position]);
            holder.text.setText(TEXTS[position]);
            holder.image.setImageResource(IMAGES[position]);
        }

        @Override
        public int getItemCount() {
            return TITLES.length;
        }
    }
}
