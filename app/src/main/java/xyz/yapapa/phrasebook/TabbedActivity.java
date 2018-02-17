package xyz.yapapa.phrasebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Locale;

public class TabbedActivity extends AppCompatActivity implements TTSListener,TextToSpeech.OnInitListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentStatePagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    private TextToSpeech ttsTranslate, ttsDefault;
    private String languageTranslate,languageDefault;
    private DataModel data;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed);




        SharedPreferences prefs = this.getSharedPreferences("language",Context.MODE_PRIVATE);
        languageTranslate = prefs.getString("languageTranslate", "en");
        languageDefault  = prefs.getString("languageDefault", "ru");


        data = new DataModel(languageDefault, languageTranslate);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);

        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab01)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab02)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab03)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab04)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab05)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab06)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab07)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab08)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab09)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab10)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab11)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab12)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab13)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab14)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab15)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab16)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab17)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab18)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab19)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab20)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab21)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab22)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab23)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab24)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab25)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab26)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab27)));

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


        ttsTranslate = new TextToSpeech(this, this);
        ttsDefault = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                int result = ttsDefault.setLanguage(new Locale(languageDefault, ""));
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_tabbed, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void speakTranslate(String text) {

        ttsTranslate.speak(text, TextToSpeech.QUEUE_FLUSH, null,"id1");
        //ttsDefault.speak("получилось", TextToSpeech.QUEUE_FLUSH, null,"id1");
        /*Toast toast = Toast.makeText(getApplicationContext(),
                "press", Toast.LENGTH_SHORT);
        toast.show();
        */
    }

    @Override
    public void speakDefault(String text) {

        //ttsTranslate.speak(text, TextToSpeech.QUEUE_FLUSH, null,"id1");
        ttsDefault.speak(text, TextToSpeech.QUEUE_FLUSH, null,"id1");
        /*Toast toast = Toast.makeText(getApplicationContext(),
                "press", Toast.LENGTH_SHORT);
        toast.show();
        */
    }

    @Override
    public void onInit( int status) {


                if (status == TextToSpeech.SUCCESS) {
                    int result = ttsTranslate.setLanguage(new Locale(languageTranslate, ""));


                } else {
                   // Toast.makeText(this, "Not Supported in your Device", Toast.LENGTH_SHORT).show();
                }

    }

    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (ttsTranslate != null) {
            ttsTranslate.stop();
            ttsTranslate.shutdown();
        }

        if (ttsDefault != null) {
            ttsDefault.stop();
            ttsDefault.shutdown();
        }
        super.onDestroy();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class WordholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */


        RecyclerView mRecyclerView;
        StaggeredGridLayoutManager gaggeredGridLayoutManager;
        WordAdapter wordAdapter;
        public WordholderFragment() {

        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static WordholderFragment newInstance(ArrayList array) {
            WordholderFragment fragment = new WordholderFragment();
            Bundle args = new Bundle();
            args.putSerializable("key", array);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tabbed, container, false);
           // TextView textView = (TextView) rootView.findViewById(R.id.section_label);
           // textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

            mRecyclerView = rootView.findViewById(R.id.recyclerView);

            gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(gaggeredGridLayoutManager);

            wordAdapter = new WordAdapter((ArrayList<Phrase>)getArguments().getSerializable("key"));

            mRecyclerView.setAdapter(wordAdapter);

            return rootView;
        }
    }

    public static class CharholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */


        RecyclerView mRecyclerView;
        StaggeredGridLayoutManager gaggeredGridLayoutManager;
        CharAdapter charAdapter;
        public CharholderFragment() {

        }


        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static TabbedActivity.CharholderFragment newInstance(ArrayList array) {
            TabbedActivity.CharholderFragment fragment = new TabbedActivity.CharholderFragment();
            Bundle args = new Bundle();
            args.putSerializable("key", array);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tabbed, container, false);
            // TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            // textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

            mRecyclerView = rootView.findViewById(R.id.recyclerView);

            gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(gaggeredGridLayoutManager);

            charAdapter = new CharAdapter((ArrayList<String>)getArguments().getSerializable("key"));

            mRecyclerView.setAdapter(charAdapter);

            return rootView;
        }
    }

    public static class ColorholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */


        RecyclerView mRecyclerView;
        StaggeredGridLayoutManager gaggeredGridLayoutManager;
        ColorAdapter colorAdapter;
        public ColorholderFragment() {

        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static ColorholderFragment newInstance(ArrayList array) {
            ColorholderFragment fragment = new ColorholderFragment();
            Bundle args = new Bundle();
            args.putSerializable("key", array);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tabbed, container, false);
            // TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            // textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

            mRecyclerView = rootView.findViewById(R.id.recyclerView);

            gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(gaggeredGridLayoutManager);

            colorAdapter = new ColorAdapter((ArrayList<Phrase>)getArguments().getSerializable("key"));

            mRecyclerView.setAdapter(colorAdapter);

            return rootView;
        }
    }


    /**
     * A {@link FragmentStatePagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a WordholderFragment (defined as a static inner class below).
            switch (position) {
                case 0:
                    return CharholderFragment.newInstance(data.getAlphabet(languageTranslate));
                case 1:
                    return CharholderFragment.newInstance(data.getNumbers());
                case 2:
                    return ColorholderFragment.newInstance(data.getColors());

                case 3:
                    return WordholderFragment.newInstance(data.getPeople());

                case 4:
                    return WordholderFragment.newInstance(data.getClothes());

                case 5:
                    return WordholderFragment.newInstance(data.getFood());

                default:
                    return CharholderFragment.newInstance(data.getAlphabet("ru"));



            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 27;
        }
    }
}
