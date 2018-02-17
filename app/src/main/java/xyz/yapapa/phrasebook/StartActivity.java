package xyz.yapapa.phrasebook;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StartActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner languageSpinner;
    private List<String> languages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        SharedPreferences sharedPref = this.getSharedPreferences("language",Context.MODE_PRIVATE);



        languageSpinner = findViewById(R.id.languageSelect);
        languageSpinner.setOnItemSelectedListener(this);



        //создаем список доступных к переводу языков кроме языка приложения
        languages = makeLanguageList(Locale.getDefault().getLanguage());
        //адаптер для спиннера
        ArrayAdapter<String> languageAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                languages);

        languageAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpinner.setAdapter(languageAdapter);

        String languageTranslate = sharedPref.getString("languageTranslate", "en");

        setSpinner (languageTranslate);
    }

    /*создание списка языков на основе языка телефона, язык телефона исключается
    язык по умолчанию английский
    */
    private List<String> makeLanguageList(String language) {
         List<String> languages = new ArrayList<>();
         if (!language.equals("ru")) languages.add(getResources().getString(R.string.ruLanguage));
            else setDefaultLocale("ru");
         if (!language.equals("fr")) languages.add(getResources().getString(R.string.frLanguage));
            else setDefaultLocale("fr");
         if (!language.equals("de")) languages.add(getResources().getString(R.string.deLanguage));
             else setDefaultLocale("de");
        if (!language.equals("it")) languages.add(getResources().getString(R.string.itLanguage));
            else setDefaultLocale("it");
        if (!language.equals("es")) languages.add(getResources().getString(R.string.spLanguage));
            else setDefaultLocale("es");
        if (!language.equals("en") && (languages.size()!=5)) languages.add(0,getResources().getString(R.string.enLanguage));
            else setDefaultLocale("en");

         /*
        Toast toast = Toast.makeText(getApplicationContext(),
                language, Toast.LENGTH_SHORT);
        toast.show();
        */
         return languages;

    }



    /*
    проверка какой язык выбран и взвращение по этому языку индекса в массиве языков
     */
    private void setSpinner(String languageTranslate) {

        int i =-1;
        if (languageTranslate.equals("en")) i=languages.indexOf(getResources().getString(R.string.enLanguage));

        if (languageTranslate.equals("ru")) i=languages.indexOf(getResources().getString(R.string.ruLanguage));
        if (languageTranslate.equals("fr")) i=languages.indexOf(getResources().getString(R.string.frLanguage));
        if (languageTranslate.equals("de")) i=languages.indexOf(getResources().getString(R.string.deLanguage));
        if (languageTranslate.equals("it")) i=languages.indexOf(getResources().getString(R.string.itLanguage));
        if (languageTranslate.equals("es")) i=languages.indexOf(getResources().getString(R.string.spLanguage));

        if (i>0) languageSpinner.setSelection(i);
        else languageSpinner.setSelection(0);


    }

    public void startHelp (View v){

    }

    public void startLearn (View v){
        Intent intent = new Intent(this, TabbedActivity.class);
        newActivityStart(intent);
    }

    public void startTraining (View v){


    }

    private void newActivityStart(Intent intent){

        startActivity(intent);
    }


    /*
    По выбранному языку записывает в шаред преференс язык для перевода
     */

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Locale current = getResources().getConfiguration().locale;

        String locale = "en";

        if (languages.get(position).equals(getResources().getString(R.string.enLanguage))) locale="en";
        if (languages.get(position).equals(getResources().getString(R.string.ruLanguage))) locale="ru";
        if (languages.get(position).equals(getResources().getString(R.string.frLanguage))) locale="fr";
        if (languages.get(position).equals(getResources().getString(R.string.deLanguage))) locale="de";
        if (languages.get(position).equals(getResources().getString(R.string.itLanguage))) locale="it";
        if (languages.get(position).equals(getResources().getString(R.string.spLanguage))) locale="es";
        setTranslateLocale(locale);


    }

    private void setDefaultLocale(String language){

        SharedPreferences sharedPref = this.getSharedPreferences("language",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("languageDefault", language);
        editor.apply();
    }


    private void setTranslateLocale(String language) {
        SharedPreferences sharedPref = this.getSharedPreferences("language",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("languageTranslate", language);
        editor.apply();
        /*
        Toast toast = Toast.makeText(getApplicationContext(),
                language, Toast.LENGTH_SHORT);
        toast.show();
        */
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
