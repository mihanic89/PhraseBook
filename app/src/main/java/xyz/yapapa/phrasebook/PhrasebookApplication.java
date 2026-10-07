package xyz.yapapa.phrasebook;

import android.app.Application;

import androidx.emoji2.bundled.BundledEmojiCompatConfig;
import androidx.emoji2.text.EmojiCompat;

public class PhrasebookApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // Шрифт с эмодзи (флаги) идёт в комплекте, без загрузки из интернета.
        EmojiCompat.init(new BundledEmojiCompatConfig(this));
    }
}
