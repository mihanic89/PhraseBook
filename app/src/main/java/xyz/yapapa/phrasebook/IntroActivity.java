package xyz.yapapa.phrasebook;


import android.graphics.Color;
import android.os.Bundle;


import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;

/**
 * Created by Misha on 13.03.2018.
 */

public class IntroActivity extends AppIntro2 {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        addSlide(AppIntroFragment.newInstance(getString(R.string.help1),
                getString(R.string.help1text),
                R.mipmap.intro1, Color.parseColor("#41ba7a")));

        addSlide(AppIntroFragment.newInstance(getString(R.string.help2),
                getString(R.string.help2text),
                R.mipmap.intro2, Color.parseColor("#41ba7a")));
        addSlide(AppIntroFragment.newInstance(getString(R.string.help3),
                getString(R.string.help3text),
                R.mipmap.intro3, Color.parseColor("#41ba7a")));
        addSlide(AppIntroFragment.newInstance(getString(R.string.help4),
                getString(R.string.help4text),
                R.mipmap.intro4, Color.parseColor("#41ba7a")));
        addSlide(AppIntroFragment.newInstance(getString(R.string.help5),
                getString(R.string.help5text),
                R.mipmap.intro5, Color.parseColor("#41ba7a")));
        addSlide(AppIntroFragment.newInstance(getString(R.string.help6),
                getString(R.string.help6text),
                R.mipmap.intro6, Color.parseColor("#41ba7a")));

        showSkipButton(true);
        setProgressButtonEnabled(true);

        // Edit the color of the nav bar on Lollipop+ devices
        setNavBarColor(R.color.colorPrimaryDark);//Color.parseColor("#3F51B5"));

        // Turn vibration on and set intensity
        // NOTE: you will need to ask VIBRATE permission in Manifest if you haven't already
        //setVibrate(true);
        //setVibrateIntensity(30);

        // Animations -- use only one of the below. Using both could cause errors.
        // Animations -- use only one of the below. Using both could cause errors.
        //setFadeAnimation(); // OR
        //setZoomAnimation(); // OR
        //setFlowAnimation(); // OR
        // setSlideOverAnimation(); // OR
         setDepthAnimation(); // OR
        //setCustomTransformer(yourCustomTransformer);

    }

    @Override
    public void onNextPressed() {
        super.onNextPressed();
        // Do something when users tap on Next button.
    }

    @Override
    public void onDonePressed() {
        // Do something when users tap on Done button.
        super.onDonePressed();
        finish();
    }

    @Override
    public void onSlideChanged() {
        // Do something when slide is changed
        super.onSlideChanged();
    }


    @Override
    public void onSkipPressed(){
        super.onSkipPressed();
        finish();
    }
}
