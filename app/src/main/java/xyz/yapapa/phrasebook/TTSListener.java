package xyz.yapapa.phrasebook;

/**
 * Created by Misha on 19.01.2018.
 */

interface TTSListener {
    void speakTranslate(String text);
    void speakDefault(String text);
}
