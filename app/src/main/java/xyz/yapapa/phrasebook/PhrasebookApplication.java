package xyz.yapapa.phrasebook;

import android.app.Application;
import android.support.annotation.Nullable;
import android.support.text.emoji.EmojiCompat;
import android.support.text.emoji.FontRequestEmojiCompatConfig;
import android.support.text.emoji.bundled.BundledEmojiCompatConfig;
import android.support.v4.provider.FontRequest;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Misha on 17.03.2018.
 */

public class PhrasebookApplication extends Application {

    private static final String TAG = "PhrasebookApplication";

    /** Change this to {@code false} when you want to use the downloadable Emoji font. */
    private static final boolean USE_BUNDLED_EMOJI = true;

    @Override
    public void onCreate() {
        super.onCreate();

        final EmojiCompat.Config config;
        if (USE_BUNDLED_EMOJI) {
            // Use the bundled font for EmojiCompat
            config = new BundledEmojiCompatConfig(getApplicationContext());
        } else {
            // Use a downloadable font for EmojiCompat
            final FontRequest fontRequest = new FontRequest(
                    "com.google.android.gms.fonts",
                    "com.google.android.gms",
                    "Noto Color Emoji Compat",
                    R.array.com_google_android_gms_fonts_certs);
            config = new FontRequestEmojiCompatConfig(getApplicationContext(), fontRequest)
                    .setReplaceAll(true)
                    .registerInitCallback(new EmojiCompat.InitCallback() {
                        @Override
                        public void onInitialized() {

                           // Log.i(TAG, "EmojiCompat initialized");
                            /*
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "ok", Toast.LENGTH_SHORT);
                            toast.show();
                            */
                        }

                        @Override
                        public void onFailed(@Nullable Throwable throwable) {
                            //Log.e(TAG, "EmojiCompat initialization failed", throwable);
                            /*
                            Toast toast = Toast.makeText(getApplicationContext(),
                                    "error", Toast.LENGTH_SHORT);
                            toast.show();
                            */
                        }
                    });
        }
        EmojiCompat.init(config);
    }

}
