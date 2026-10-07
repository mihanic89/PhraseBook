package xyz.yapapa.phrasebook;

import android.content.Context;
import android.media.AudioAttributes;
import android.os.Handler;
import android.os.Looper;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;

import java.util.Locale;
import java.util.Set;

/**
 * Озвучка одного языка голосом телефона. Сетевые голоса не используются: они добавляют
 * задержку, поэтому если голос по умолчанию требует сети, берётся лучший офлайн-голос языка.
 */
class TtsSpeaker {

    interface Callback {
        /**
         * Озвучка языка недоступна.
         *
         * @param installable голосовые данные можно доустановить (иначе язык не поддерживается
         *                    или движок не запустился)
         */
        void onUnavailable(boolean installable);
    }

    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Callback callback;
    private final Locale locale;
    private TextToSpeech tts;
    private boolean ready = false;
    private int counter = 0;

    TtsSpeaker(Context context, String language, Callback callback) {
        this.callback = callback;
        this.locale = toLocale(language);
        tts = new TextToSpeech(context.getApplicationContext(), status -> {
            if (status == TextToSpeech.SUCCESS) {
                handler.post(this::configure);
            } else {
                handler.post(() -> {
                    if (tts != null && callback != null) callback.onUnavailable(false);
                });
            }
        });
    }

    private static Locale toLocale(String language) {
        if ("zh".equals(language)) return Locale.SIMPLIFIED_CHINESE;
        if ("en".equals(language)) return Locale.US;
        return new Locale(language);
    }

    private void configure() {
        if (tts == null) return;
        int result = tts.setLanguage(locale);
        if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
            if (callback != null) callback.onUnavailable(result == TextToSpeech.LANG_MISSING_DATA);
            return;
        }

        Voice current = tts.getVoice();
        if (current != null && current.isNetworkConnectionRequired()) {
            Voice offline = bestOfflineVoice();
            if (offline != null) tts.setVoice(offline);
        }

        tts.setSpeechRate(0.9f);
        tts.setAudioAttributes(new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_SPEECH)
                .build());
        ready = true;
    }

    /**
     * Установленный голос языка, которому не нужна сеть: сначала с той же страной
     * (zh_CN, а не zh_TW; en_US, а не en_IN), среди равных — лучший по качеству.
     */
    private Voice bestOfflineVoice() {
        Voice best = null;
        try {
            Set<Voice> voices = tts.getVoices();
            if (voices == null) return null;
            for (Voice v : voices) {
                if (v.isNetworkConnectionRequired()) continue;
                if (!v.getLocale().getLanguage().equals(locale.getLanguage())) continue;
                if (v.getFeatures() != null
                        && v.getFeatures().contains(TextToSpeech.Engine.KEY_FEATURE_NOT_INSTALLED)) continue;
                if (best == null) {
                    best = v;
                    continue;
                }
                boolean exact = sameCountry(v);
                boolean bestExact = sameCountry(best);
                if ((exact && !bestExact)
                        || (exact == bestExact && v.getQuality() > best.getQuality())) {
                    best = v;
                }
            }
        } catch (RuntimeException ignored) {
            // у движка нет списка голосов — остаётся голос по умолчанию
        }
        return best;
    }

    /** Страна голоса совпадает с нужной; если страна не задана (fi, de…), подходит любая. */
    private boolean sameCountry(Voice voice) {
        return locale.getCountry().isEmpty()
                || locale.getCountry().equalsIgnoreCase(voice.getLocale().getCountry());
    }

    void speak(String text) {
        if (!ready || tts == null || text == null) return;
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, String.valueOf(++counter));
    }

    void shutdown() {
        ready = false;
        if (tts != null) {
            tts.stop();
            tts.shutdown();
            tts = null;
        }
    }
}
