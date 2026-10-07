package xyz.yapapa.phrasebook;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.github.appintro.AppIntro2;
import com.github.appintro.AppIntroFragment;
import com.github.appintro.AppIntroPageTransformerType;

/**
 * Created by Misha on 13.03.2018.
 */

public class IntroActivity extends AppIntro2 {

    private static final int[] TITLES = {
            R.string.help1, R.string.help2, R.string.help3, R.string.help4,
            R.string.help5, R.string.help6, R.string.help7, R.string.help8};
    private static final int[] TEXTS = {
            R.string.help1text, R.string.help2text, R.string.help3text, R.string.help4text,
            R.string.help5text, R.string.help6text, R.string.help7text, R.string.help8text};
    private static final int[] IMAGES = {
            R.mipmap.intro1, R.mipmap.intro2, R.mipmap.intro3, R.mipmap.intro4,
            R.mipmap.intro5, R.mipmap.intro6, R.mipmap.intro7, R.mipmap.intro8};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for (int i = 0; i < TITLES.length; i++) {
            addSlide(AppIntroFragment.createInstance(
                    getString(TITLES[i]),
                    getString(TEXTS[i]),
                    IMAGES[i],
                    R.color.intro_background));
        }

        setSkipButtonEnabled(true);
        setButtonsEnabled(true);

        setTransformer(AppIntroPageTransformerType.Depth.INSTANCE);
    }

    @Override
    protected void onDonePressed(@Nullable Fragment currentFragment) {
        super.onDonePressed(currentFragment);
        finish();
    }

    @Override
    protected void onSkipPressed(@Nullable Fragment currentFragment) {
        super.onSkipPressed(currentFragment);
        finish();
    }
}
