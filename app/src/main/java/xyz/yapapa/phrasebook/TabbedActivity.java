package xyz.yapapa.phrasebook;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


import java.util.ArrayList;
import java.util.Locale;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class TabbedActivity extends AppCompatActivity implements TTSListener {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentStatePagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private static final String STATE_POSITION_INDEX = "state_position_index";
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private int screenWidth,screenHeight;
    private TextToSpeech ttsTranslate, ttsDefault;
    private String languageTranslate,languageDefault;
    private int sharedIndex;
    private DataModel data;
    private SharedPreferences prefs;
    private TabLayout tabLayout;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        MobileAds.initialize(this, "ca-app-pub-2888343178529026~4340757150");


        setContentView(R.layout.activity_tabbed);
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
         screenWidth = size.x;
         screenHeight= size.y;

        GlideApp.with(this)
                // .asDrawable()
                // .load(mStorageRef.child(mDataSet.get(position).getImage()))
                .load(R.mipmap.background)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .priority(Priority.LOW)
                //.load(internetUrl)
                //.skipMemoryCache(true)
                .override((int)screenWidth/3, (int) screenHeight/3)
                .fitCenter()
                // .thumbnail()
                //.error(R.mipmap.ic_launcher)
                .placeholder(new ColorDrawable(getResources().getColor(R.color.background)))
                //.placeholder(R.mipmap.placeholder)
                .transition(withCrossFade(700))
                .into((ImageView) findViewById(R.id.imageViewBackground2));


        prefs = this.getSharedPreferences("language",Context.MODE_PRIVATE);
        languageTranslate = prefs.getString("languageTranslate", "en");

        languageDefault  = prefs.getString("languageDefault", "ru");
        sharedIndex = prefs.getInt(STATE_POSITION_INDEX,0);

        data = new DataModel(languageDefault, languageTranslate);

       // Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = findViewById(R.id.tabs);

        createTabs();



        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


            mViewPager.setCurrentItem(sharedIndex);


        try {
            new TtsInitDefaut().execute();
        }
        catch (Exception e){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "error default", Toast.LENGTH_SHORT);
            toast.show();
        };

        try {
            new TtsInitTranslate().execute();
        }
        catch (Exception e){
            Toast toast = Toast.makeText(getApplicationContext(),
                    "error translate", Toast.LENGTH_SHORT);
            toast.show();
        };
        /*
        ttsTranslate = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = ttsTranslate.setLanguage(new Locale(languageTranslate, ""));


                } else {
                    // Toast.makeText(this, "Not Supported in your Device", Toast.LENGTH_SHORT).show();
                }
            }
        });

        ttsDefault = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status==TextToSpeech.SUCCESS) {
                    int result = ttsDefault.setLanguage(new Locale(languageDefault, ""));
                }
                else
                {

                }
            }
        });
        */


        mAdView = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    private void createTabs() {

        View view1 = getLayoutInflater().inflate(R.layout.customtab, null);
        view1.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab01);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view1));



        View view2 = getLayoutInflater().inflate(R.layout.customtab, null);
        view2.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab02);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view2));


        View view3 = getLayoutInflater().inflate(R.layout.customtab, null);
        view3.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab03);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view3));


        View view4 = getLayoutInflater().inflate(R.layout.customtab, null);
        view4.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab04);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view4));

        View view5 = getLayoutInflater().inflate(R.layout.customtab, null);
        view5.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab05);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view5));

        View view6 = getLayoutInflater().inflate(R.layout.customtab, null);
        view6.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab06);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view6));

        View view7 = getLayoutInflater().inflate(R.layout.customtab, null);
        view7.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab07);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view7));

        View view8 = getLayoutInflater().inflate(R.layout.customtab, null);
        view8.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab08);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view8));

        View view9 = getLayoutInflater().inflate(R.layout.customtab, null);
        view9.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab09);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view9));

        View view10 = getLayoutInflater().inflate(R.layout.customtab, null);
        view10.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab10);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view10));

        View view11 = getLayoutInflater().inflate(R.layout.customtab, null);
        view11.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab11);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view11));

        View view12 = getLayoutInflater().inflate(R.layout.customtab, null);
        view12.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab12);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view12));

        View view13 = getLayoutInflater().inflate(R.layout.customtab, null);
        view13.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab13);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view13));

        View view14 = getLayoutInflater().inflate(R.layout.customtab, null);
        view14.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab14);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view14));

        View view15 = getLayoutInflater().inflate(R.layout.customtab, null);
        view15.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab15);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view15));

        View view16 = getLayoutInflater().inflate(R.layout.customtab, null);
        view16.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab16);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view16));

        View view17 = getLayoutInflater().inflate(R.layout.customtab, null);
        view17.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab17);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view17));

        View view18 = getLayoutInflater().inflate(R.layout.customtab, null);
        view18.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab18);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view18));

        View view19 = getLayoutInflater().inflate(R.layout.customtab, null);
        view19.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab19);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view19));

        View view20 = getLayoutInflater().inflate(R.layout.customtab, null);
        view20.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab20);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view20));

        View view21 = getLayoutInflater().inflate(R.layout.customtab, null);
        view21.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab21);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view21));

        View view22 = getLayoutInflater().inflate(R.layout.customtab, null);
        view22.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab22);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view22));

        View view23 = getLayoutInflater().inflate(R.layout.customtab, null);
        view23.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab23);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view23));

        View view24 = getLayoutInflater().inflate(R.layout.customtab, null);
        view24.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab24);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view24));

        View view25 = getLayoutInflater().inflate(R.layout.customtab, null);
        view25.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab25);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view25));

        View view26 = getLayoutInflater().inflate(R.layout.customtab, null);
        view26.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab26);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view26));

        View view27 = getLayoutInflater().inflate(R.layout.customtab, null);
        view27.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab27);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view27));

        View view28 = getLayoutInflater().inflate(R.layout.customtab, null);
        view28.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab28);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view28));

        View view29 = getLayoutInflater().inflate(R.layout.customtab, null);
        view29.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab29);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view29));

        View view30 = getLayoutInflater().inflate(R.layout.customtab, null);
        view30.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab30);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view30));

        View view31 = getLayoutInflater().inflate(R.layout.customtab, null);
        view31.findViewById(R.id.icon).setBackgroundResource(R.drawable.tab31);
        tabLayout.addTab(tabLayout.newTab().setCustomView(view31));



        //tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab01)));
        // tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tab01));
        //tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab02)));
        //tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab03)));
        //tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab04)));
        //tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab05)));
       /* tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab06)));
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
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab28)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab29)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab30)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab31)));
        */
    }


    public class TtsInitDefaut extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            ttsDefault = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status==TextToSpeech.SUCCESS) {
                        int result = ttsDefault.setLanguage(new Locale(languageDefault, ""));
                    }
                    else
                    {

                    }
                }
            });
            return null;
        }
    }

    public class TtsInitTranslate extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            ttsTranslate = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status==TextToSpeech.SUCCESS) {
                        int result = ttsTranslate.setLanguage(new Locale(languageTranslate, ""));
                    }
                    else
                    {

                    }
                }
            });
            return null;
        }
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
        try {
            if (Build.VERSION.SDK_INT<21){

                ttsTranslate.speak(text, TextToSpeech.QUEUE_FLUSH,null);
            }
            else {
                ttsTranslate.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
            }
        }
        catch (Exception e){

        }
        //ttsDefault.speak("получилось", TextToSpeech.QUEUE_FLUSH, null,"id1");
        /*Toast toast = Toast.makeText(getApplicationContext(),
                "press", Toast.LENGTH_SHORT);
        toast.show();
        */
    }

    @Override
    public void speakDefault(String text) {

        //ttsTranslate.speak(text, TextToSpeech.QUEUE_FLUSH, null,"id1");
        try {
            if (Build.VERSION.SDK_INT<21){
                ttsDefault.speak(text, TextToSpeech.QUEUE_FLUSH,null);
            }
            else {
                ttsDefault.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");
            }
        }
        catch (Exception e){

        }

        /*Toast toast = Toast.makeText(getApplicationContext(),
                "press", Toast.LENGTH_SHORT);
        toast.show();
        */
    }


    @Override
    public void onPause() {
        if (mAdView != null) {
            mAdView.pause();
        }
        super.onPause();
    }

    /** Called when returning to the activity */
    @Override
    public void onResume() {
        super.onResume();
        if (mAdView != null) {
            mAdView.resume();
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
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(STATE_POSITION_INDEX, mViewPager.getCurrentItem());
        editor.apply();

        if (mAdView != null) {
            mAdView.destroy();
        }

        super.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

            outState.putInt(STATE_POSITION_INDEX, mViewPager.getCurrentItem());

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
        public static WordholderFragment newInstance(ArrayList array, int screenWidth) {
            WordholderFragment fragment = new WordholderFragment();

            Bundle args = new Bundle();
            args.putSerializable("key", array);
            args.putInt("width", screenWidth);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            final View rootView = inflater.inflate(R.layout.fragment_tabbed, container, false);
           // TextView textView = (TextView) rootView.findViewById(R.id.section_label);
           // textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

            int spanCount = 2;

            int screenSize = getResources().getConfiguration().screenLayout &
                    Configuration.SCREENLAYOUT_SIZE_MASK;

            if (screenSize>=Configuration.SCREENLAYOUT_SIZE_LARGE) spanCount=3;



            mRecyclerView = rootView.findViewById(R.id.recyclerView);

            gaggeredGridLayoutManager = new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(gaggeredGridLayoutManager);

           // GlideApp.get(rootView.getContext()).setMemoryCategory(MemoryCategory.LOW);
            wordAdapter = new WordAdapter(
                    (ArrayList<Phrase>)getArguments().getSerializable("key"),
                    (int) getArguments().getInt("width")/(spanCount+2),
                    rootView.getContext(), GlideApp.with(rootView.getContext()));

            mRecyclerView.setAdapter(wordAdapter);
            mRecyclerView.setItemViewCacheSize(0);
            mRecyclerView.getRecycledViewPool().setMaxRecycledViews(0,spanCount*4);



            /*
            mRecyclerView.setRecyclerListener(new RecyclerView.RecyclerListener() {
                @Override
                public void onViewRecycled(RecyclerView.ViewHolder holder) {
                    WordAdapter.ViewHolder photoViewHolder = (WordAdapter.ViewHolder) holder;
                    GlideApp.with(rootView.getContext()).clear(photoViewHolder.imageView);
                }
            });

            mRecyclerView.getRecycledViewPool().setMaxRecycledViews(0,spanCount*3);
            mRecyclerView.setItemViewCacheSize(0);
            */
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

            int spanCount = 3;

            int screenSize = getResources().getConfiguration().screenLayout &
                    Configuration.SCREENLAYOUT_SIZE_MASK;

            if (screenSize>=Configuration.SCREENLAYOUT_SIZE_LARGE) spanCount=5;

            mRecyclerView = rootView.findViewById(R.id.recyclerView);

            gaggeredGridLayoutManager = new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL);
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

            int spanCount = 2;

            int screenSize = getResources().getConfiguration().screenLayout &
                    Configuration.SCREENLAYOUT_SIZE_MASK;

            if (screenSize>=Configuration.SCREENLAYOUT_SIZE_LARGE) spanCount=3;

            mRecyclerView = rootView.findViewById(R.id.recyclerView);

            gaggeredGridLayoutManager = new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(gaggeredGridLayoutManager);

            colorAdapter = new ColorAdapter((ArrayList<Phrase>)getArguments().getSerializable("key"));

            mRecyclerView.setAdapter(colorAdapter);

            return rootView;
        }
    }


    public static class FlagholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */


        RecyclerView mRecyclerView;
        StaggeredGridLayoutManager gaggeredGridLayoutManager;
        FlagAdapter flagAdapter;
        public FlagholderFragment() {

        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static FlagholderFragment newInstance(ArrayList array, int screenWidth) {
            FlagholderFragment fragment = new FlagholderFragment();
            Bundle args = new Bundle();
            args.putSerializable("key", array);
            args.putInt("width", screenWidth);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tabbed, container, false);
            // TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            // textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

            int spanCount = 2;

            int screenSize = getResources().getConfiguration().screenLayout &
                    Configuration.SCREENLAYOUT_SIZE_MASK;

            if (screenSize>=Configuration.SCREENLAYOUT_SIZE_LARGE) spanCount=3;

            mRecyclerView = rootView.findViewById(R.id.recyclerView);

            gaggeredGridLayoutManager = new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL);
            mRecyclerView.setLayoutManager(gaggeredGridLayoutManager);

            flagAdapter = new FlagAdapter((ArrayList<Phrase>)getArguments().getSerializable("key"),(int) getArguments().getInt("width")/(spanCount+1));

            mRecyclerView.setAdapter(flagAdapter);

            mRecyclerView.setRecyclerListener(new RecyclerView.RecyclerListener() {
                @Override
                public void onViewRecycled(RecyclerView.ViewHolder holder) {
                    FlagAdapter.ViewHolder photoViewHolder = (FlagAdapter.ViewHolder) holder;
                    GlideApp.with(FlagholderFragment.this).clear(photoViewHolder.getFlagView());
                }
            });
            mRecyclerView.getRecycledViewPool().setMaxRecycledViews(0,spanCount*5);
            mRecyclerView.setItemViewCacheSize(0);

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
                    return WordholderFragment.newInstance(data.getForms(),screenWidth);

                case 4:
                    return WordholderFragment.newInstance(data.getTime(),screenWidth);

                case 5:
                    return WordholderFragment.newInstance(data.getFamily(),screenWidth);

                case 6:
                    return WordholderFragment.newInstance(data.getClothes(),screenWidth);

                case 7:
                    return WordholderFragment.newInstance(data.getFood(),screenWidth);

                case 8:
                    return WordholderFragment.newInstance(data.getVegetables(),screenWidth);

                case 9:
                    return WordholderFragment.newInstance(data.getFruits(),screenWidth);

                case 10:
                    return WordholderFragment.newInstance(data.getBerries(),screenWidth);

                case 11:
                    return WordholderFragment.newInstance(data.getFlowers(),screenWidth);

                case 12:
                    return WordholderFragment.newInstance(data.getBody(),screenWidth);

                case 13:
                    return WordholderFragment.newInstance(data.getEmotions(),screenWidth);

                case 14:
                    return WordholderFragment.newInstance(data.getAnimals(),screenWidth);

                case 15:
                    return WordholderFragment.newInstance(data.getHouse(),screenWidth);

                case 16:
                    return WordholderFragment.newInstance(data.getObjects(),screenWidth);

                case 17:
                    return WordholderFragment.newInstance(data.getToys(),screenWidth);

                case 18:
                    return WordholderFragment.newInstance(data.getMusicinst(),screenWidth);

                case 19:
                    return WordholderFragment.newInstance(data.getSport(),screenWidth);

                case 20:
                    return WordholderFragment.newInstance(data.getTransport(),screenWidth);

                case 21:
                    return WordholderFragment.newInstance(data.getCity(),screenWidth);

                case 22:
                    return WordholderFragment.newInstance(data.getNature(),screenWidth);

                case 23:
                    return WordholderFragment.newInstance(data.getArt(),screenWidth);

                case 24:
                    return WordholderFragment.newInstance(data.getSchool(),screenWidth);

                case 25:
                    return WordholderFragment.newInstance(data.getProf(),screenWidth);

                case 26:
                    return WordholderFragment.newInstance(data.getVerbs(),screenWidth);

                case 27:
                    return WordholderFragment.newInstance(data.getAdjectives(),screenWidth);

                case 28:
                    return WordholderFragment.newInstance(data.getPhrases(),screenWidth);

                case 29:
                    return WordholderFragment.newInstance(data.getPretext(),screenWidth);

                case 30:
                    return FlagholderFragment.newInstance(data.getGeo(),screenWidth);


                default:
                    return WordholderFragment.newInstance(data.getFamily(),screenWidth);



            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 31;
        }
    }
}
