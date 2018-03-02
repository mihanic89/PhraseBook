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
    private List<String> locales;




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
                R.layout.simple_spinner_custom_item,
                languages);

        languageAdapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_custom_item);
        languageSpinner.setAdapter(languageAdapter);

        String languageTranslate = sharedPref.getString("languageTranslate", "en");

        setSpinner (languageTranslate);
    }

    /*создание списка языков на основе языка телефона, язык телефона исключается
    язык по умолчанию английский
    */
    private List<String> makeLanguageList(String language) {
         List<String> languages = new ArrayList<>();
         locales = new ArrayList<>();
         if (!language.equals("ru")) {
             languages.add("\uD83C\uDDF7\uD83C\uDDFA " + getResources().getString(R.string.ruLanguage));
             locales.add("ru");
         }
            else setDefaultLocale("ru");

        if (!language.equals("zh")) {
            languages.add("\uD83C\uDDE8\uD83C\uDDF3 "+getResources().getString(R.string.zhLanguage));
            locales.add("zh");
        }
             else setDefaultLocale("zh");

         if (!language.equals("fr")) {
             languages.add("\uD83C\uDDEB\uD83C\uDDF7 "+getResources().getString(R.string.frLanguage));
             locales.add("fr");
         }
            else setDefaultLocale("fr");

         if (!language.equals("de")) {
             languages.add("\uD83C\uDDE9\uD83C\uDDEA "+getResources().getString(R.string.deLanguage));
             locales.add("de");

         }
             else setDefaultLocale("de");

        if (!language.equals("it")) {
            languages.add("\uD83C\uDDEE\uD83C\uDDF9 "+getResources().getString(R.string.itLanguage));
            locales.add("it");
        }
            else setDefaultLocale("it");

        if (!language.equals("es")) {
            languages.add("\uD83C\uDDEA\uD83C\uDDF8 "+getResources().getString(R.string.spLanguage));
            locales.add("es");
        }
            else setDefaultLocale("es");

        if (!language.equals("pt")) {
            languages.add("\uD83C\uDDF5\uD83C\uDDF9 "+getResources().getString(R.string.ptLanguage));
            locales.add("pt");
        }
        else setDefaultLocale("pt");

        if (!language.equals("be")) {
            languages.add("\uD83C\uDDE7\uD83C\uDDFE "+getResources().getString(R.string.beLanguage));
            locales.add("be");
        }
        else setDefaultLocale("be");

        if (!language.equals("uk")) {
            languages.add("\uD83C\uDDFA\uD83C\uDDE6 "+getResources().getString(R.string.ukLanguage));
            locales.add("uk");
        }
        else setDefaultLocale("uk");

        if (!language.equals("en") && (languages.size()!=9)) {
            languages.add(0,"\uD83C\uDDEC\uD83C\uDDE7 "+getResources().getString(R.string.enLanguage));
            locales.add(0,"en");
        }
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
        if (languageTranslate.equals("en")) i=locales.indexOf(languageTranslate);

        if (languageTranslate.equals("ru")) i=locales.indexOf(languageTranslate);
        if (languageTranslate.equals("fr")) i=locales.indexOf(languageTranslate);
        if (languageTranslate.equals("de")) i=locales.indexOf(languageTranslate);
        if (languageTranslate.equals("zh")) i=locales.indexOf(languageTranslate);
        if (languageTranslate.equals("it")) i=locales.indexOf(languageTranslate);
        if (languageTranslate.equals("es")) i=locales.indexOf(languageTranslate);
        if (languageTranslate.equals("pt")) i=locales.indexOf(languageTranslate);
        if (languageTranslate.equals("be")) i=locales.indexOf(languageTranslate);
        if (languageTranslate.equals("uk"))i=locales.indexOf(languageTranslate);
        if (i>0) languageSpinner.setSelection(i);
        else languageSpinner.setSelection(0);


    }

    public void help (View v){

    }

    public void share (View v){

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
        /*
        if (languages.get(position).equals(getResources().getString(R.string.enLanguage))) locale="en";
        if (languages.get(position).equals(getResources().getString(R.string.ruLanguage))) locale="ru";
        if (languages.get(position).equals(getResources().getString(R.string.frLanguage))) locale="fr";
        if (languages.get(position).equals(getResources().getString(R.string.deLanguage))) locale="de";
        if (languages.get(position).equals(getResources().getString(R.string.itLanguage))) locale="it";
        if (languages.get(position).equals(getResources().getString(R.string.spLanguage))) locale="es";
        if (languages.get(position).equals(getResources().getString(R.string.ptLanguage))) locale="pt";
        if (languages.get(position).equals(getResources().getString(R.string.beLanguage))) locale="be";
        if (languages.get(position).equals(getResources().getString(R.string.ukLanguage))) locale="uk";
        if (languages.get(position).equals(getResources().getString(R.string.zhLanguage))) locale="zh";
        */
        setTranslateLocale(locales.get(position));


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
