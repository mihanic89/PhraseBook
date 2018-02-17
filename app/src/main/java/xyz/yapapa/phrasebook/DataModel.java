package xyz.yapapa.phrasebook;

import java.util.ArrayList;

/**
 * Created by Misha on 18.01.2018.
 */

class DataModel {


    private ArrayList<Phrase> people;
    private ArrayList<Phrase> clothes;
    private ArrayList<Phrase> food;
    private ArrayList<String> alphabet;
    private ArrayList<String> numbers;

    public ArrayList<Phrase> getColors() {
        return colors;
    }

    public ArrayList<Phrase> getPeople() {
        return people;
    }

    public ArrayList<Phrase> getClothes() {
        return clothes;
    }

    public ArrayList<Phrase> getFood() {
        return food;
    }

    private ArrayList<Phrase> colors;

    public ArrayList<String> getAlphabet(String locale) {
        alphabet = new ArrayList<>();
        alphabet.add("A");
        alphabet.add("B");
        alphabet.add("C");
        alphabet.add("D");
        alphabet.add("E");
        alphabet.add("F");
        alphabet.add("G");
        return alphabet;
    }

    public  ArrayList<String> getNumbers(){
        numbers = new ArrayList<>();
        numbers.add("1");
        numbers.add("1");
        numbers.add("1");
        numbers.add("1");
        numbers.add("1");
        numbers.add("1");
        numbers.add("1");
        numbers.add("1");
        numbers.add("1");
        numbers.add("1");
        numbers.add("1");
        numbers.add("1");

        return numbers;
        }



    public DataModel(String defaultLanguage, String translateLanguage) {
        initData (defaultLanguage, translateLanguage);
    }

    private void initData(String defaultLanguage, String translateLanguage) {
        people = new ArrayList<>();
        people.add(new Phrase(R.string.mother, R.drawable.ic_launcher_background, defaultLanguage, translateLanguage));
        people.add(new Phrase(R.string.mother, R.drawable.ic_launcher_background, defaultLanguage, translateLanguage));
        people.add(new Phrase(R.string.mother, R.drawable.ic_launcher_background, defaultLanguage, translateLanguage));
        people.add(new Phrase(R.string.mother, R.drawable.ic_launcher_background, defaultLanguage, translateLanguage));
        people.add(new Phrase(R.string.mother, R.drawable.ic_launcher_background, defaultLanguage, translateLanguage));
        people.add(new Phrase(R.string.mother, R.drawable.ic_launcher_background, defaultLanguage, translateLanguage));
        people.add(new Phrase(R.string.mother, R.drawable.ic_launcher_background, defaultLanguage, translateLanguage));

        clothes = new ArrayList<>();
        clothes.add(new Phrase(R.string.square, R.drawable.ic_launcher_background,defaultLanguage,translateLanguage));
        clothes.add(new Phrase(R.string.square, R.drawable.ic_launcher_background,defaultLanguage,translateLanguage));
        clothes.add(new Phrase(R.string.square, R.drawable.ic_launcher_background,defaultLanguage,translateLanguage));
        clothes.add(new Phrase(R.string.square, R.drawable.ic_launcher_background,defaultLanguage,translateLanguage));
        clothes.add(new Phrase(R.string.square, R.drawable.ic_launcher_background,defaultLanguage,translateLanguage));
        clothes.add(new Phrase(R.string.square, R.drawable.ic_launcher_background,defaultLanguage,translateLanguage));
        clothes.add(new Phrase(R.string.square, R.drawable.ic_launcher_background,defaultLanguage,translateLanguage));
        clothes.add(new Phrase(R.string.square, R.drawable.ic_launcher_background,defaultLanguage,translateLanguage));
        clothes.add(new Phrase(R.string.square, R.drawable.ic_launcher_background,defaultLanguage,translateLanguage));

        food = new ArrayList<>();
        food.add(new Phrase(R.string.food, R.drawable.ic_launcher_background,defaultLanguage,translateLanguage));
        food.add(new Phrase(R.string.food, R.drawable.ic_launcher_background,defaultLanguage,translateLanguage));
        food.add(new Phrase(R.string.food, R.drawable.ic_launcher_background,defaultLanguage,translateLanguage));
        food.add(new Phrase(R.string.food, R.drawable.ic_launcher_background,defaultLanguage,translateLanguage));
        food.add(new Phrase(R.string.food, R.drawable.ic_launcher_background,defaultLanguage,translateLanguage));
        food.add(new Phrase(R.string.food, R.drawable.ic_launcher_background,defaultLanguage,translateLanguage));
        food.add(new Phrase(R.string.food, R.drawable.ic_launcher_background,defaultLanguage,translateLanguage));
        food.add(new Phrase(R.string.food, R.drawable.ic_launcher_background,defaultLanguage,translateLanguage));
        food.add(new Phrase(R.string.food, R.drawable.ic_launcher_background,defaultLanguage,translateLanguage));
        food.add(new Phrase(R.string.food, R.drawable.ic_launcher_background,defaultLanguage,translateLanguage));
        food.add(new Phrase(R.string.food, R.drawable.ic_launcher_background,defaultLanguage,translateLanguage));
        food.add(new Phrase(R.string.food, R.drawable.ic_launcher_background,defaultLanguage,translateLanguage));


        colors = new ArrayList<>();
        colors.add(new Phrase(R.string.colorWhite, R.color.colorAccent,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colorWhite, R.color.colorText,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colorWhite, R.color.colorPrimary,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colorWhite, R.color.colorPrimary,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colorWhite, R.color.colorAccent,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colorWhite, R.color.colorText,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colorWhite, R.color.colorPrimary,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colorWhite, R.color.colorPrimary,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colorWhite, R.color.colorText,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colorWhite, R.color.colorAccent,defaultLanguage, translateLanguage));







    }
}
