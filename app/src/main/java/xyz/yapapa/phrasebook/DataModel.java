package xyz.yapapa.phrasebook;

import java.util.ArrayList;

/**
 * Created by Misha on 18.01.2018.
 */

class DataModel {

    private ArrayList<Phrase>
            colors;
    private ArrayList<Phrase> forms;
    private ArrayList<Phrase> time;
    private ArrayList<Phrase> family;
    private ArrayList<Phrase> clothes;
    private ArrayList<Phrase> food;
    private ArrayList<Phrase> vegetables;
    private ArrayList<Phrase> fruits;
    private ArrayList<Phrase> berries;
    private ArrayList<Phrase> flowers;
    private ArrayList<Phrase> body;
    private ArrayList<Phrase> emotions;
    private ArrayList<Phrase> animals;
    private ArrayList<Phrase> house;
    private ArrayList<Phrase> objects;
    private ArrayList<Phrase> toys;
    private ArrayList<Phrase> musicinst;
    private ArrayList<Phrase> sport;
    private ArrayList<Phrase> transport;
    private ArrayList<Phrase> city;
    private ArrayList<Phrase> nature;
    private ArrayList<Phrase> art;
    private ArrayList<Phrase> school;
    private ArrayList<Phrase> prof;
    private ArrayList<Phrase> verbs;
    private ArrayList<Phrase> adjectives;
    private ArrayList<Phrase> phrases;
    private ArrayList<Phrase> pretext;
    private ArrayList<Phrase> geo;

    public ArrayList<Phrase> getColors() {
        return colors;
    }

    public ArrayList<Phrase> getForms() {
        return forms;
    }

    public ArrayList<Phrase> getTime() {
        return time;
    }

    public ArrayList<Phrase> getFamily() {
        return family;
    }


    public ArrayList<Phrase> getClothes() {
        return clothes;
    }

    public ArrayList<Phrase> getFood() {
        return food;
    }

    public ArrayList<Phrase> getVegetables() {
        return vegetables;
    }

    public ArrayList<Phrase> getFruits() {
        return fruits;
    }

    public ArrayList<Phrase> getFlowers() {
        return flowers;
    }

    public ArrayList<Phrase> getBerries() {
        return berries;
    }

    public ArrayList<Phrase> getBody() {
        return body;
    }

    public ArrayList<Phrase> getEmotions() {
        return emotions;
    }

    public ArrayList<Phrase> getAnimals() {
        return animals;
    }

    public ArrayList<Phrase> getHouse() {
        return house;
    }

    public ArrayList<Phrase> getObjects() {
        return objects;
    }

    public ArrayList<Phrase> getToys() {
        return toys;
    }

    public ArrayList<Phrase> getMusicinst() {
        return musicinst;
    }

    public ArrayList<Phrase> getSport() {
        return sport;
    }

    public ArrayList<Phrase> getTransport() {
        return transport;
    }

    public ArrayList<Phrase> getCity() {
        return city;
    }

    public ArrayList<Phrase> getNature() {
        return nature;
    }

    public ArrayList<Phrase> getArt() {
        return art;
    }

    public ArrayList<Phrase> getSchool() {
        return school;
    }

    public ArrayList<Phrase> getProf() {
        return prof;
    }

    public ArrayList<Phrase> getVerbs() {
        return verbs;
    }

    public ArrayList<Phrase> getAdjectives() {
        return adjectives;
    }

    public ArrayList<Phrase> getPhrases() {
        return phrases;
    }

    public ArrayList<Phrase> getPretext() {
        return pretext;
    }

    public ArrayList<Phrase> getGeo() {
        return geo;
    }








    public ArrayList<String> getAlphabet(String locale) {


        if (locale.equals("de")){
            ArrayList<String> alphabetDe = new ArrayList<>();
            alphabetDe.add("A");
            alphabetDe.add("Ä");
            alphabetDe.add("B");
            alphabetDe.add("C");
            alphabetDe.add("D");
            alphabetDe.add("E");
            alphabetDe.add("F");
            alphabetDe.add("G");
            alphabetDe.add("H");
            alphabetDe.add("I");
            alphabetDe.add("J");
            alphabetDe.add("K");
            alphabetDe.add("L");
            alphabetDe.add("M");
            alphabetDe.add("N");
            alphabetDe.add("O");
            alphabetDe.add("Ö");
            alphabetDe.add("P");
            alphabetDe.add("Q");
            alphabetDe.add("R");
            alphabetDe.add("S");
            alphabetDe.add("ẞ");
            alphabetDe.add("T");
            alphabetDe.add("U");
            alphabetDe.add("Ü");
            alphabetDe.add("V");
            alphabetDe.add("W");
            alphabetDe.add("X");
            alphabetDe.add("Y");
            alphabetDe.add("Z");

            return alphabetDe;
        }

        else if (locale.equals("it")) {


            ArrayList<String> alphabetIt = new ArrayList<>();
            alphabetIt.add("A");
            alphabetIt.add("B");
            alphabetIt.add("C");
            alphabetIt.add("D");
            alphabetIt.add("E");
            alphabetIt.add("F");
            alphabetIt.add("G");
            alphabetIt.add("H");
            alphabetIt.add("I");
            alphabetIt.add("L");
            alphabetIt.add("M");
            alphabetIt.add("N");
            alphabetIt.add("O");
            alphabetIt.add("P");
            alphabetIt.add("Q");
            alphabetIt.add("R");
            alphabetIt.add("S");
            alphabetIt.add("T");
            alphabetIt.add("U");
            alphabetIt.add("V");
            alphabetIt.add("Z");

            return alphabetIt;
        }

        else if (locale.equals("es")) {
            ArrayList<String> alphabetEs = new ArrayList<>();
            alphabetEs.add("A");
            alphabetEs.add("B");
            alphabetEs.add("C");
            alphabetEs.add("D");
            alphabetEs.add("E");
            alphabetEs.add("F");
            alphabetEs.add("G");
            alphabetEs.add("H");
            alphabetEs.add("I");
            alphabetEs.add("J");
            alphabetEs.add("K");
            alphabetEs.add("L");
            alphabetEs.add("M");
            alphabetEs.add("N");
            alphabetEs.add("Ñ");
            alphabetEs.add("O");
            alphabetEs.add("P");
            alphabetEs.add("Q");
            alphabetEs.add("R");
            alphabetEs.add("S");
            alphabetEs.add("T");
            alphabetEs.add("U");
            alphabetEs.add("V");
            alphabetEs.add("W");
            alphabetEs.add("X");
            alphabetEs.add("Y");
            alphabetEs.add("Z");

            return alphabetEs;
        }

        else if (locale.equals("ru")) {

            ArrayList<String> alphabetRu = new ArrayList<>();
            alphabetRu.add("А");
            alphabetRu.add("Б");
            alphabetRu.add("В");
            alphabetRu.add("Г");
            alphabetRu.add("Д");
            alphabetRu.add("Е");
            alphabetRu.add("Ё");
            alphabetRu.add("Ж");
            alphabetRu.add("З");
            alphabetRu.add("И");
            alphabetRu.add("Й");
            alphabetRu.add("К");
            alphabetRu.add("Л");
            alphabetRu.add("М");
            alphabetRu.add("Н");
            alphabetRu.add("О");
            alphabetRu.add("П");
            alphabetRu.add("Р");
            alphabetRu.add("С");
            alphabetRu.add("Т");
            alphabetRu.add("У");
            alphabetRu.add("Ф");
            alphabetRu.add("Х");
            alphabetRu.add("Ц");
            alphabetRu.add("Ч");
            alphabetRu.add("Ш");
            alphabetRu.add("Щ");
            alphabetRu.add("Ъ");
            alphabetRu.add("Ы");
            alphabetRu.add("Ь");
            alphabetRu.add("Э");
            alphabetRu.add("Ю");
            alphabetRu.add("Я");

            return alphabetRu;
        }

        else if (locale.equals("be")) {
            ArrayList<String> alphabetBe = new ArrayList<>();
            alphabetBe.add("А");
            alphabetBe.add("Б");
            alphabetBe.add("В");
            alphabetBe.add("Г");
            alphabetBe.add("Д");
            alphabetBe.add("Е");
            alphabetBe.add("Ё");
            alphabetBe.add("Ж");
            alphabetBe.add("З");
            alphabetBe.add("I");
            alphabetBe.add("Й");
            alphabetBe.add("К");
            alphabetBe.add("Л");
            alphabetBe.add("М");
            alphabetBe.add("Н");
            alphabetBe.add("О");
            alphabetBe.add("П");
            alphabetBe.add("Р");
            alphabetBe.add("С");
            alphabetBe.add("Т");
            alphabetBe.add("У");
            alphabetBe.add("Ў");
            alphabetBe.add("Ф");
            alphabetBe.add("Х");
            alphabetBe.add("Ц");
            alphabetBe.add("Ч");
            alphabetBe.add("Ш");
            alphabetBe.add("Ы");
            alphabetBe.add("Ь");
            alphabetBe.add("Э");
            alphabetBe.add("Ю");
            alphabetBe.add("Я");

            return alphabetBe;
        }

        else if (locale.equals("uk")) {

            ArrayList<String> alphabetUk = new ArrayList<>();
            alphabetUk.add("А");
            alphabetUk.add("Б");
            alphabetUk.add("В");
            alphabetUk.add("Г");
            alphabetUk.add("Ґ");
            alphabetUk.add("Д");
            alphabetUk.add("Е");
            alphabetUk.add("Є");
            alphabetUk.add("Ж");
            alphabetUk.add("З");
            alphabetUk.add("И");
            alphabetUk.add("І");
            alphabetUk.add("Ї");
            alphabetUk.add("Й");
            alphabetUk.add("К");
            alphabetUk.add("Л");
            alphabetUk.add("М");
            alphabetUk.add("Н");
            alphabetUk.add("О");
            alphabetUk.add("П");
            alphabetUk.add("Р");
            alphabetUk.add("С");
            alphabetUk.add("Т");
            alphabetUk.add("У");
            alphabetUk.add("Ф");
            alphabetUk.add("Х");
            alphabetUk.add("Ц");
            alphabetUk.add("Ч");
            alphabetUk.add("Ш");
            alphabetUk.add("Щ");
            alphabetUk.add("Э");
            alphabetUk.add("Ю");
            alphabetUk.add("Я");

            return alphabetUk;
        }

        else if (locale.equals("zh")) {


            ArrayList<String> alphabetZh = new ArrayList<>();
            alphabetZh.add("A");
            alphabetZh.add("B");
            alphabetZh.add("C");
            alphabetZh.add("D");
            alphabetZh.add("E");
            alphabetZh.add("F");
            alphabetZh.add("G");
            alphabetZh.add("H");
            alphabetZh.add("i");
            alphabetZh.add("J");
            alphabetZh.add("K");
            alphabetZh.add("L");
            alphabetZh.add("M");
            alphabetZh.add("N");
            alphabetZh.add("O");
            alphabetZh.add("P");
            alphabetZh.add("Q");
            alphabetZh.add("R");
            alphabetZh.add("S");
            alphabetZh.add("T");
            alphabetZh.add("u");
            alphabetZh.add("ü");
            alphabetZh.add("W");
            alphabetZh.add("X");
            alphabetZh.add("X");
            alphabetZh.add("Y");
            alphabetZh.add("Z");

            return alphabetZh;
        }



        else {
            ArrayList<String> alphabetEn = new ArrayList<>();
            alphabetEn.add("A");
            alphabetEn.add("B");
            alphabetEn.add("C");
            alphabetEn.add("D");
            alphabetEn.add("E");
            alphabetEn.add("F");
            alphabetEn.add("G");
            alphabetEn.add("H");
            alphabetEn.add("I");
            alphabetEn.add("J");
            alphabetEn.add("K");
            alphabetEn.add("L");
            alphabetEn.add("M");
            alphabetEn.add("N");
            alphabetEn.add("O");
            alphabetEn.add("P");
            alphabetEn.add("Q");
            alphabetEn.add("R");
            alphabetEn.add("S");
            alphabetEn.add("T");
            alphabetEn.add("U");
            alphabetEn.add("V");
            alphabetEn.add("W");
            alphabetEn.add("X");
            alphabetEn.add("Y");
            alphabetEn.add("Z");

            return alphabetEn;
        }
    }

    public  ArrayList<String> getNumbers(){
        ArrayList<String> numbers = new ArrayList<>();
        for (Integer i =0; i<=1000;i++){
            numbers.add(Integer.toString(i));
        }
        numbers.add("1000000");
        return numbers;
        }



    public DataModel(String defaultLanguage, String translateLanguage) {
        initData (defaultLanguage, translateLanguage);
    }

    private void initData(String defaultLanguage, String translateLanguage) {

        colors = new ArrayList<>();
        colors.add(new Phrase(R.string.colors01, android.R.color.white, defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colors02, android.R.color.holo_red_light,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colors03, android.R.color.holo_orange_dark,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colors04, R.color.yellow,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colors05, android.R.color.holo_green_light,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colors06, android.R.color.holo_green_dark,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colors07, android.R.color.holo_blue_light,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colors08, R.color.pink,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colors09, android.R.color.holo_blue_dark,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colors10, R.color.lillac,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colors11, android.R.color.holo_purple,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colors12, R.color.indigo,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colors13, R.color.grey,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colors14, R.color.brown,defaultLanguage, translateLanguage));
        colors.add(new Phrase(R.string.colors15, android.R.color.black,defaultLanguage, translateLanguage));

        forms = new ArrayList<>();
        forms.add(new Phrase(R.string.forms01, "forms01.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms02, "forms02.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms03, "forms03.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms04, "forms04.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms05, "forms05.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms06, "forms06.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms07, "forms07.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms08, "forms08.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms09, "forms09.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms10, "forms10.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms11, "forms11.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms12, "forms12.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms13, "forms13.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms14, "forms14.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms15, "forms15.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms16, "forms16.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms17, "forms17.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms18, "forms18.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms19, "forms19.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms20, "forms20.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms21, "forms21.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms22, "forms22.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms23, "forms23.png", defaultLanguage, translateLanguage));
        forms.add(new Phrase(R.string.forms24, "forms24.png", defaultLanguage, translateLanguage));

        time = new ArrayList<>();
        time.add(new Phrase(R.string.time01, "time01.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time02, "time02.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time03, "time03.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time04, "time04.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time05, "time05.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time06, "time06.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time07, "time07.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time08, "time08.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time09, "time09.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time10, "time10.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time11, "time11.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time12, "time12.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time13, "time13.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time14, "time14.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time15, "time15.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time16, "time16.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time17, "time16.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time18, "time18.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time19, "time19.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time20, "time20.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time21, "time21.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time22, "time22.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time23, "time23.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time24, "time24.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time25, "time25.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time26, "time26.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time27, "time27.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time28, "time28.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time29, "time29.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time30, "time30.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time31, "time31.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time32, "time32.png", defaultLanguage, translateLanguage));
        time.add(new Phrase(R.string.time33, "time33.png", defaultLanguage, translateLanguage));


        family = new ArrayList<>();
        family.add(new Phrase(R.string.family01, "family01.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family02, "family02.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family03, "family03.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family04, "family04.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family05, "family05.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family06, "family06.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family07, "family07.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family08, "family08.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family09, "family09.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family10, "family10.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family11, "family11.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family12, "family12.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family13, "family13.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family14, "family14.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family15, "family15.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family16, "family16.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family17, "family17.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family18, "family18.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family19, "family19.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family20, "family20.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family21, "family21.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family22, "family22.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family23, "family23.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family24, "family24.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family25, "family25.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family26, "family26.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family27, "family27.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family28, "family28.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family29, "family29.png", defaultLanguage, translateLanguage));
        family.add(new Phrase(R.string.family30, "family30.png", defaultLanguage, translateLanguage));

        clothes = new ArrayList<>();
        clothes.add(new Phrase(R.string.clothes01, "clothes01.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes02, "clothes02.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes03, "clothes03.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes04, "clothes04.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes05, "clothes05.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes06, "clothes06.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes07, "clothes07.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes08, "clothes08.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes09, "clothes09.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes10, "clothes10.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes11, "clothes11.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes12, "clothes12.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes13, "clothes13.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes14, "clothes14.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes15, "clothes15.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes16, "clothes16.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes17, "clothes17.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes18, "clothes18.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes19, "clothes19.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes20, "clothes20.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes21, "clothes21.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes22, "clothes22.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes23, "clothes23.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes24, "clothes24.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes25, "clothes25.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes26, "clothes26.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes27, "clothes27.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes28, "clothes28.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes29, "clothes29.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes30, "clothes30.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes31, "clothes31.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes32, "clothes32.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes33, "clothes33.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes34, "clothes34.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes35, "clothes35.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes36, "clothes36.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes37, "clothes37.png", defaultLanguage, translateLanguage));
        clothes.add(new Phrase(R.string.clothes38, "clothes38.png", defaultLanguage, translateLanguage));

        food = new ArrayList<>();
        food.add(new Phrase(R.string.food01, "food01.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food02, "food02.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food03, "food03.gif", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food04, "food04.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food05, "food05.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food06, "food06.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food07, "food07.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food08, "food08.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food09, "food09.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food10, "food10.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food11, "food11.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food12, "food12.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food13, "food13.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food14, "food14.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food15, "food15.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food16, "food16.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food17, "food17.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food18, "food18.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food19, "food19.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food20, "food20.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food21, "food21.gif", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food22, "food22.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food23, "food23.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food24, "food24.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food25, "food25.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food26, "food26.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food27, "food27.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food28, "food28.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food29, "food29.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food30, "food30.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food31, "food31.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food32, "food32.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food33, "food33.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food34, "food34.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food35, "food35.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food36, "food36.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food37, "food37.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food38, "food38.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food39, "food39.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food40, "food40.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food41, "food41.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food42, "food42.png", defaultLanguage, translateLanguage));
        food.add(new Phrase(R.string.food43, "food43.png", defaultLanguage, translateLanguage));


        vegetables = new ArrayList<>();
        vegetables.add(new Phrase(R.string.vegetables01, "vegetables01.png", defaultLanguage, translateLanguage));
        vegetables.add(new Phrase(R.string.vegetables02, "vegetables02.png", defaultLanguage, translateLanguage));
        vegetables.add(new Phrase(R.string.vegetables03, "vegetables03.png", defaultLanguage, translateLanguage));
        vegetables.add(new Phrase(R.string.vegetables04, "vegetables04.png", defaultLanguage, translateLanguage));
        vegetables.add(new Phrase(R.string.vegetables05, "vegetables05.png", defaultLanguage, translateLanguage));
        vegetables.add(new Phrase(R.string.vegetables06, "vegetables06.png", defaultLanguage, translateLanguage));
        vegetables.add(new Phrase(R.string.vegetables07, "vegetables07.png", defaultLanguage, translateLanguage));
        vegetables.add(new Phrase(R.string.vegetables08, "vegetables08.png", defaultLanguage, translateLanguage));
        vegetables.add(new Phrase(R.string.vegetables09, "vegetables09.png", defaultLanguage, translateLanguage));
        vegetables.add(new Phrase(R.string.vegetables10, "vegetables10.png", defaultLanguage, translateLanguage));
        vegetables.add(new Phrase(R.string.vegetables11, "vegetables11.png", defaultLanguage, translateLanguage));
        vegetables.add(new Phrase(R.string.vegetables12, "vegetables12.png", defaultLanguage, translateLanguage));
        vegetables.add(new Phrase(R.string.vegetables13, "vegetables13.png", defaultLanguage, translateLanguage));
        vegetables.add(new Phrase(R.string.vegetables14, "vegetables14.png", defaultLanguage, translateLanguage));
        vegetables.add(new Phrase(R.string.vegetables15, "vegetables15.png", defaultLanguage, translateLanguage));
        vegetables.add(new Phrase(R.string.vegetables16, "vegetables16.png", defaultLanguage, translateLanguage));

        fruits = new ArrayList<>();
        fruits.add(new Phrase(R.string.fruits01, "fruits01.png", defaultLanguage, translateLanguage));
        fruits.add(new Phrase(R.string.fruits02, "fruits02.png", defaultLanguage, translateLanguage));
        fruits.add(new Phrase(R.string.fruits03, "fruits03.png", defaultLanguage, translateLanguage));
        fruits.add(new Phrase(R.string.fruits04, "fruits04.png", defaultLanguage, translateLanguage));
        fruits.add(new Phrase(R.string.fruits05, "fruits05.png", defaultLanguage, translateLanguage));
        fruits.add(new Phrase(R.string.fruits06, "fruits06.png", defaultLanguage, translateLanguage));
        fruits.add(new Phrase(R.string.fruits07, "fruits07.png", defaultLanguage, translateLanguage));
        fruits.add(new Phrase(R.string.fruits08, "fruits08.png", defaultLanguage, translateLanguage));
        fruits.add(new Phrase(R.string.fruits09, "fruits09.png", defaultLanguage, translateLanguage));
        fruits.add(new Phrase(R.string.fruits10, "fruits10.png", defaultLanguage, translateLanguage));
        fruits.add(new Phrase(R.string.fruits11, "fruits11.png", defaultLanguage, translateLanguage));
        fruits.add(new Phrase(R.string.fruits12, "fruits12.png", defaultLanguage, translateLanguage));
        fruits.add(new Phrase(R.string.fruits13, "fruits13.png", defaultLanguage, translateLanguage));
        fruits.add(new Phrase(R.string.fruits14, "fruits14.png", defaultLanguage, translateLanguage));
        fruits.add(new Phrase(R.string.fruits15, "fruits15.png", defaultLanguage, translateLanguage));
        fruits.add(new Phrase(R.string.fruits16, "fruits16.png", defaultLanguage, translateLanguage));
        fruits.add(new Phrase(R.string.fruits17, "fruits17.png", defaultLanguage, translateLanguage));
        fruits.add(new Phrase(R.string.fruits18, "fruits18.png", defaultLanguage, translateLanguage));
        fruits.add(new Phrase(R.string.fruits19, "fruits19.png", defaultLanguage, translateLanguage));
        fruits.add(new Phrase(R.string.fruits20, "fruits20.png", defaultLanguage, translateLanguage));
        fruits.add(new Phrase(R.string.fruits21, "fruits21.png", defaultLanguage, translateLanguage));
        fruits.add(new Phrase(R.string.fruits22, "fruits22.png", defaultLanguage, translateLanguage));

        berries = new ArrayList<>();
        berries.add(new Phrase(R.string.berries01, "berries01.png", defaultLanguage, translateLanguage));
        berries.add(new Phrase(R.string.berries02, "berries02.gif", defaultLanguage, translateLanguage));
        berries.add(new Phrase(R.string.berries03, "berries03.png", defaultLanguage, translateLanguage));
        berries.add(new Phrase(R.string.berries04, "berries04.png", defaultLanguage, translateLanguage));
        berries.add(new Phrase(R.string.berries05, "berries05.png", defaultLanguage, translateLanguage));
        berries.add(new Phrase(R.string.berries06, "berries06.png", defaultLanguage, translateLanguage));
        berries.add(new Phrase(R.string.berries07, "berries07.png", defaultLanguage, translateLanguage));
        berries.add(new Phrase(R.string.berries08, "berries08.png", defaultLanguage, translateLanguage));
        berries.add(new Phrase(R.string.berries09, "berries09.png", defaultLanguage, translateLanguage));
        berries.add(new Phrase(R.string.berries10, "berries10.png", defaultLanguage, translateLanguage));
        berries.add(new Phrase(R.string.berries11, "berries11.png", defaultLanguage, translateLanguage));
        berries.add(new Phrase(R.string.berries12, "berries12.png", defaultLanguage, translateLanguage));
        berries.add(new Phrase(R.string.berries13, "berries13.png", defaultLanguage, translateLanguage));
        berries.add(new Phrase(R.string.berries14, "berries14.png", defaultLanguage, translateLanguage));
        berries.add(new Phrase(R.string.berries15, "berries15.png", defaultLanguage, translateLanguage));
        berries.add(new Phrase(R.string.berries16, "berries16.png", defaultLanguage, translateLanguage));

        flowers = new ArrayList<>();
        flowers.add(new Phrase(R.string.flowers01, "flowers01.png", defaultLanguage, translateLanguage));
        flowers.add(new Phrase(R.string.flowers02, "flowers02.png", defaultLanguage, translateLanguage));
        flowers.add(new Phrase(R.string.flowers03, "flowers03.png", defaultLanguage, translateLanguage));
        flowers.add(new Phrase(R.string.flowers04, "flowers04.png", defaultLanguage, translateLanguage));
        flowers.add(new Phrase(R.string.flowers05, "flowers05.png", defaultLanguage, translateLanguage));
        flowers.add(new Phrase(R.string.flowers06, "flowers06.png", defaultLanguage, translateLanguage));
        flowers.add(new Phrase(R.string.flowers07, "flowers07.png", defaultLanguage, translateLanguage));
        flowers.add(new Phrase(R.string.flowers08, "flowers08.gif", defaultLanguage, translateLanguage));
        flowers.add(new Phrase(R.string.flowers09, "flowers09.png", defaultLanguage, translateLanguage));
        flowers.add(new Phrase(R.string.flowers10, "flowers10.png", defaultLanguage, translateLanguage));
        flowers.add(new Phrase(R.string.flowers11, "flowers11.png", defaultLanguage, translateLanguage));
        flowers.add(new Phrase(R.string.flowers12, "flowers12.png", defaultLanguage, translateLanguage));
        flowers.add(new Phrase(R.string.flowers13, "flowers13.png", defaultLanguage, translateLanguage));
        flowers.add(new Phrase(R.string.flowers14, "flowers14.png", defaultLanguage, translateLanguage));
        flowers.add(new Phrase(R.string.flowers15, "flowers15.png", defaultLanguage, translateLanguage));

        body = new ArrayList<>();
        body.add(new Phrase(R.string.body01, "body01.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body02, "body02.gif", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body03, "body03.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body04, "body04.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body05, "body05.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body06, "body06.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body07, "body07.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body08, "body08.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body09, "body09.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body10, "body10.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body11, "body11.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body12, "body12.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body13, "body13.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body14, "body14.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body15, "body15.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body16, "body16.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body17, "body17.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body18, "body18.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body19, "body19.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body20, "body20.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body21, "body21.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body22, "body22.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body23, "body23.png", defaultLanguage, translateLanguage));
        body.add(new Phrase(R.string.body24, "body24.gif", defaultLanguage, translateLanguage));

        emotions = new ArrayList<>();
        emotions.add(new Phrase(R.string.emotions01, "emotions01.gif", defaultLanguage, translateLanguage));
        emotions.add(new Phrase(R.string.emotions02, "emotions02.gif", defaultLanguage, translateLanguage));
        emotions.add(new Phrase(R.string.emotions03, "emotions03.gif", defaultLanguage, translateLanguage));
        emotions.add(new Phrase(R.string.emotions04, "emotions04.gif", defaultLanguage, translateLanguage));
        emotions.add(new Phrase(R.string.emotions05, "emotions05.gif", defaultLanguage, translateLanguage));
        emotions.add(new Phrase(R.string.emotions06, "emotions06.gif", defaultLanguage, translateLanguage));
        emotions.add(new Phrase(R.string.emotions07, "emotions07.gif", defaultLanguage, translateLanguage));
        emotions.add(new Phrase(R.string.emotions08, "emotions08.gif", defaultLanguage, translateLanguage));
        emotions.add(new Phrase(R.string.emotions09, "emotions09.gif", defaultLanguage, translateLanguage));
        emotions.add(new Phrase(R.string.emotions10, "emotions10.gif", defaultLanguage, translateLanguage));
        emotions.add(new Phrase(R.string.emotions11, "emotions11.gif", defaultLanguage, translateLanguage));
        emotions.add(new Phrase(R.string.emotions12, "emotions12.gif", defaultLanguage, translateLanguage));
        emotions.add(new Phrase(R.string.emotions13, "emotions13.gif", defaultLanguage, translateLanguage));
        emotions.add(new Phrase(R.string.emotions14, "emotions14.gif", defaultLanguage, translateLanguage));
        emotions.add(new Phrase(R.string.emotions15, "emotions15.gif", defaultLanguage, translateLanguage));
        emotions.add(new Phrase(R.string.emotions16, "emotions16.gif", defaultLanguage, translateLanguage));
        emotions.add(new Phrase(R.string.emotions17, "emotions17.gif", defaultLanguage, translateLanguage));

        animals = new ArrayList<>();
        animals.add(new Phrase(R.string.animals01, "animals01.gif", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals02, "animals02.gif", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals03, "animals03.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals04, "animals04.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals05, "animals05.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals06, "animals06.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals07, "animals07.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals08, "animals08.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals09, "animals09.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals10, "animals10.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals11, "animals11.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals12, "animals12.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals13, "animals13.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals14, "animals14.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals15, "animals15.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals16, "animals16.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals17, "animals17.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals18, "animals18.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals19, "animals19.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals20, "animals20.gif", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals21, "animals21.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals22, "animals22.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals23, "animals23.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals24, "animals24.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals25, "animals25.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals26, "animals26.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals27, "animals27.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals28, "animals28.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals29, "animals29.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals30, "animals30.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals31, "animals31.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals32, "animals32.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals33, "animals33.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals34, "animals34.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals35, "animals35.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals36, "animals36.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals37, "animals37.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals38, "animals38.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals39, "animals39.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals40, "animals40.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals41, "animals41.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals42, "animals42.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals43, "animals43.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals44, "animals44.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals45, "animals45.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals46, "animals46.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals47, "animals47.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals48, "animals48.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals49, "animals49.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals50, "animals50.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals51, "animals51.gif", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals52, "animals52.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals53, "animals53.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals54, "animals54.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals55, "animals55.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals56, "animals56.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals57, "animals57.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals58, "animals58.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals59, "animals59.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals60, "animals60.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals61, "animals61.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals62, "animals62.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals63, "animals63.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals64, "animals64.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals65, "animals65.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals66, "animals66.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals67, "animals67.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals68, "animals68.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals69, "animals69.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals70, "animals70.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals71, "animals71.png", defaultLanguage, translateLanguage));
        animals.add(new Phrase(R.string.animals72, "animals72.png", defaultLanguage, translateLanguage));

        house = new ArrayList<>();
        house.add(new Phrase(R.string.house01, "house01.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house02, "house02.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house03, "house03.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house04, "house04.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house05, "house05.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house06, "house06.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house07, "house07.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house08, "house08.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house09, "house09.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house10, "house10.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house11, "house11.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house12, "house12.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house13, "house13.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house14, "house14.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house15, "house15.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house16, "house16.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house17, "house17.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house18, "house18.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house19, "house19.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house20, "house20.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house21, "house21.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house22, "house22.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house23, "house23.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house24, "house24.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house25, "house25.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house26, "house26.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house27, "house27.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house28, "house28.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house29, "house29.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house30, "house30.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house31, "house31.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house32, "house32.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house33, "house33.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house34, "house34.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house35, "house35.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house36, "house36.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house37, "house37.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house38, "house38.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house39, "house39.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house40, "house40.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house41, "house41.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house42, "house42.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house43, "house43.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house44, "house44.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house45, "house45.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house46, "house46.png", defaultLanguage, translateLanguage));
        house.add(new Phrase(R.string.house47, "house47.png", defaultLanguage, translateLanguage));

        objects = new ArrayList<>();
        objects.add(new Phrase(R.string.objects01, "objects01.png", defaultLanguage, translateLanguage));
        objects.add(new Phrase(R.string.objects02, "objects02.png", defaultLanguage, translateLanguage));
        objects.add(new Phrase(R.string.objects03, "objects03.png", defaultLanguage, translateLanguage));
        objects.add(new Phrase(R.string.objects04, "objects04.png", defaultLanguage, translateLanguage));
        objects.add(new Phrase(R.string.objects05, "objects05.png", defaultLanguage, translateLanguage));
        objects.add(new Phrase(R.string.objects06, "objects06.png", defaultLanguage, translateLanguage));
        objects.add(new Phrase(R.string.objects07, "objects07.png", defaultLanguage, translateLanguage));
        objects.add(new Phrase(R.string.objects08, "objects08.png", defaultLanguage, translateLanguage));
        objects.add(new Phrase(R.string.objects09, "objects09.png", defaultLanguage, translateLanguage));
        objects.add(new Phrase(R.string.objects10, "objects10.png", defaultLanguage, translateLanguage));
        objects.add(new Phrase(R.string.objects11, "objects11.png", defaultLanguage, translateLanguage));
        objects.add(new Phrase(R.string.objects12, "objects12.png", defaultLanguage, translateLanguage));
        objects.add(new Phrase(R.string.objects13, "objects13.png", defaultLanguage, translateLanguage));
        objects.add(new Phrase(R.string.objects14, "objects14.png", defaultLanguage, translateLanguage));
        objects.add(new Phrase(R.string.objects15, "objects15.png", defaultLanguage, translateLanguage));
        objects.add(new Phrase(R.string.objects16, "objects16.png", defaultLanguage, translateLanguage));
        objects.add(new Phrase(R.string.objects17, "objects17.png", defaultLanguage, translateLanguage));
        objects.add(new Phrase(R.string.objects18, "objects18.png", defaultLanguage, translateLanguage));

        toys = new ArrayList<>();
        toys.add(new Phrase(R.string.toys01, "toys01.png", defaultLanguage, translateLanguage));
        toys.add(new Phrase(R.string.toys02, "toys02.png", defaultLanguage, translateLanguage));
        toys.add(new Phrase(R.string.toys03, "toys03.png", defaultLanguage, translateLanguage));
        toys.add(new Phrase(R.string.toys04, "toys04.png", defaultLanguage, translateLanguage));
        toys.add(new Phrase(R.string.toys05, "toys05.png", defaultLanguage, translateLanguage));
        toys.add(new Phrase(R.string.toys06, "toys06.png", defaultLanguage, translateLanguage));
        toys.add(new Phrase(R.string.toys07, "toys07.png", defaultLanguage, translateLanguage));
        toys.add(new Phrase(R.string.toys08, "toys08.png", defaultLanguage, translateLanguage));
        toys.add(new Phrase(R.string.toys09, "toys09.png", defaultLanguage, translateLanguage));
        toys.add(new Phrase(R.string.toys10, "toys10.png", defaultLanguage, translateLanguage));
        toys.add(new Phrase(R.string.toys11, "toys11.png", defaultLanguage, translateLanguage));
        toys.add(new Phrase(R.string.toys12, "toys12.png", defaultLanguage, translateLanguage));
        toys.add(new Phrase(R.string.toys13, "toys13.png", defaultLanguage, translateLanguage));
        toys.add(new Phrase(R.string.toys14, "toys14.png", defaultLanguage, translateLanguage));
        toys.add(new Phrase(R.string.toys15, "toys15.png", defaultLanguage, translateLanguage));
        toys.add(new Phrase(R.string.toys16, "toys16.png", defaultLanguage, translateLanguage));
        toys.add(new Phrase(R.string.toys17, "toys17.png", defaultLanguage, translateLanguage));

        musicinst = new ArrayList<>();
        musicinst.add(new Phrase(R.string.musicinst01, "musicinst01.png", defaultLanguage, translateLanguage));
        musicinst.add(new Phrase(R.string.musicinst02, "musicinst02.png", defaultLanguage, translateLanguage));
        musicinst.add(new Phrase(R.string.musicinst03, "musicinst03.png", defaultLanguage, translateLanguage));
        musicinst.add(new Phrase(R.string.musicinst04, "musicinst04.png", defaultLanguage, translateLanguage));
        musicinst.add(new Phrase(R.string.musicinst05, "musicinst05.png", defaultLanguage, translateLanguage));
        musicinst.add(new Phrase(R.string.musicinst06, "musicinst06.png", defaultLanguage, translateLanguage));
        musicinst.add(new Phrase(R.string.musicinst07, "musicinst07.png", defaultLanguage, translateLanguage));
        musicinst.add(new Phrase(R.string.musicinst08, "musicinst08.png", defaultLanguage, translateLanguage));
        musicinst.add(new Phrase(R.string.musicinst09, "musicinst09.png", defaultLanguage, translateLanguage));
        musicinst.add(new Phrase(R.string.musicinst10, "musicinst10.png", defaultLanguage, translateLanguage));
        musicinst.add(new Phrase(R.string.musicinst11, "musicinst11.png", defaultLanguage, translateLanguage));
        musicinst.add(new Phrase(R.string.musicinst12, "musicinst12.png", defaultLanguage, translateLanguage));
        musicinst.add(new Phrase(R.string.musicinst13, "musicinst13.png", defaultLanguage, translateLanguage));
        musicinst.add(new Phrase(R.string.musicinst14, "musicinst14.png", defaultLanguage, translateLanguage));
        musicinst.add(new Phrase(R.string.musicinst15, "musicinst15.png", defaultLanguage, translateLanguage));
        musicinst.add(new Phrase(R.string.musicinst16, "musicinst16.png", defaultLanguage, translateLanguage));
        musicinst.add(new Phrase(R.string.musicinst17, "musicinst17.png", defaultLanguage, translateLanguage));

        transport = new ArrayList<>();
        transport.add(new Phrase(R.string.transport01, "transport01.png", defaultLanguage, translateLanguage));
        transport.add(new Phrase(R.string.transport02, "transport02.png", defaultLanguage, translateLanguage));
        transport.add(new Phrase(R.string.transport03, "transport03.png", defaultLanguage, translateLanguage));
        transport.add(new Phrase(R.string.transport04, "transport04.png", defaultLanguage, translateLanguage));
        transport.add(new Phrase(R.string.transport05, "transport05.png", defaultLanguage, translateLanguage));
        transport.add(new Phrase(R.string.transport06, "transport06.png", defaultLanguage, translateLanguage));
        transport.add(new Phrase(R.string.transport07, "transport07.png", defaultLanguage, translateLanguage));
        transport.add(new Phrase(R.string.transport08, "transport08.png", defaultLanguage, translateLanguage));
        transport.add(new Phrase(R.string.transport09, "transport09.png", defaultLanguage, translateLanguage));
        transport.add(new Phrase(R.string.transport10, "transport10.png", defaultLanguage, translateLanguage));
        transport.add(new Phrase(R.string.transport11, "transport11.png", defaultLanguage, translateLanguage));
        transport.add(new Phrase(R.string.transport12, "transport12.png", defaultLanguage, translateLanguage));

        sport = new ArrayList<>();
        sport.add(new Phrase(R.string.sport01, "sport01.gif", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport02, "sport02.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport03, "sport03.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport04, "sport04.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport05, "sport05.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport06, "sport06.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport07, "sport07.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport08, "sport08.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport09, "sport09.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport10, "sport10.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport11, "sport11.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport12, "sport12.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport13, "sport13.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport14, "sport14.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport15, "sport15.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport16, "sport16.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport17, "sport17.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport18, "sport18.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport19, "sport19.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport20, "sport20.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport21, "sport21.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport22, "sport22.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport23, "sport23.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport24, "sport24.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport25, "sport25.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport26, "sport26.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport27, "sport27.png", defaultLanguage, translateLanguage));
        sport.add(new Phrase(R.string.sport28, "sport28.png", defaultLanguage, translateLanguage));

        city = new ArrayList<>();
        city.add(new Phrase(R.string.city01, "city01.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city02, "city02.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city03, "city03.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city04, "city04.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city05, "city05.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city06, "city06.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city07, "city07.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city08, "city08.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city09, "city09.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city10, "city10.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city11, "city11.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city12, "city12.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city13, "city13.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city14, "city14.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city15, "city15.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city16, "city16.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city17, "city17.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city18, "city18.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city19, "city19.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city20, "city20.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city21, "city21.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city22, "city22.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city23, "city23.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city24, "city24.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city25, "city25.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city26, "city26.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city27, "city27.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city28, "city28.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city29, "city29.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city30, "city30.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city31, "city31.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city32, "city32.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city33, "city33.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city34, "city34.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city35, "city35.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city36, "city36.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city37, "city37.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city38, "city38.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city39, "city39.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city40, "city40.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city41, "city41.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city42, "city42.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city43, "city43.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city44, "city44.png", defaultLanguage, translateLanguage));
        city.add(new Phrase(R.string.city45, "city45.png", defaultLanguage, translateLanguage));


        art = new ArrayList<>();
        art.add(new Phrase(R.string.art01, "art01.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art02, "art02.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art03, "art03.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art04, "art04.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art05, "art05.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art06, "art06.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art07, "art07.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art08, "art08.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art09, "art09.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art10, "art10.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art11, "art11.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art12, "art12.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art13, "art13.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art14, "art14.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art15, "art15.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art16, "art16.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art17, "art17.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art18, "art18.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art19, "art19.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art20, "art20.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art21, "art21.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art22, "art22.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art23, "art23.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art24, "art24.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art25, "art25.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art26, "art26.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art27, "art27.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art28, "art28.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art29, "art29.png", defaultLanguage, translateLanguage));
        art.add(new Phrase(R.string.art30, "art30.png", defaultLanguage, translateLanguage));

        school = new ArrayList<>();
        school.add(new Phrase(R.string.school01, "school01.png", defaultLanguage, translateLanguage));
        school.add(new Phrase(R.string.school02, "school02.png", defaultLanguage, translateLanguage));
        school.add(new Phrase(R.string.school03, "school03.png", defaultLanguage, translateLanguage));
        school.add(new Phrase(R.string.school04, "school04.png", defaultLanguage, translateLanguage));
        school.add(new Phrase(R.string.school05, "school05.png", defaultLanguage, translateLanguage));
        school.add(new Phrase(R.string.school06, "school06.png", defaultLanguage, translateLanguage));
        school.add(new Phrase(R.string.school07, "school07.png", defaultLanguage, translateLanguage));
        school.add(new Phrase(R.string.school08, "school08.png", defaultLanguage, translateLanguage));
        school.add(new Phrase(R.string.school09, "school09.png", defaultLanguage, translateLanguage));
        school.add(new Phrase(R.string.school10, "school10.png", defaultLanguage, translateLanguage));
        school.add(new Phrase(R.string.school11, "school11.png", defaultLanguage, translateLanguage));
        school.add(new Phrase(R.string.school12, "school12.png", defaultLanguage, translateLanguage));
        school.add(new Phrase(R.string.school13, "school13.png", defaultLanguage, translateLanguage));
        school.add(new Phrase(R.string.school14, "school14.png", defaultLanguage, translateLanguage));
        school.add(new Phrase(R.string.school15, "school15.png", defaultLanguage, translateLanguage));
        school.add(new Phrase(R.string.school16, "school16.png", defaultLanguage, translateLanguage));
        school.add(new Phrase(R.string.school17, "school17.png", defaultLanguage, translateLanguage));

        nature = new ArrayList<>();
        nature.add(new Phrase(R.string.nature01, "nature01.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature02, "nature02.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature03, "nature03.gif", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature04, "nature04.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature05, "nature05.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature06, "nature06.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature07, "nature07.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature08, "nature08.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature09, "nature09.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature10, "nature10.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature11, "nature11.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature12, "nature12.gif", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature13, "nature13.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature14, "nature14.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature15, "nature15.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature16, "nature16.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature17, "nature17.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature18, "nature18.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature19, "nature19.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature20, "nature20.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature21, "nature21.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature22, "nature22.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature23, "nature23.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature24, "nature24.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature25, "nature25.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature26, "nature26.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature27, "nature27.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature28, "nature28.png", defaultLanguage, translateLanguage));
        nature.add(new Phrase(R.string.nature29, "nature29.png", defaultLanguage, translateLanguage));

        prof = new ArrayList<>();
        prof.add(new Phrase(R.string.prof01, "prof01.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof02, "prof02.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof03, "prof03.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof04, "prof04.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof05, "prof05.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof06, "prof06.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof07, "prof07.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof08, "prof08.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof09, "prof09.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof10, "prof10.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof11, "prof11.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof12, "prof12.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof13, "prof13.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof14, "prof14.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof15, "prof15.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof16, "prof16.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof17, "prof17.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof18, "prof18.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof19, "prof19.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof20, "prof20.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof21, "prof22.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof22, "prof22.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof23, "prof23.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof24, "prof24.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof25, "prof25.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof26, "prof26.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof27, "prof27.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof28, "prof28.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof29, "prof29.png", defaultLanguage, translateLanguage));
        prof.add(new Phrase(R.string.prof30, "prof30.png", defaultLanguage, translateLanguage));

        verbs = new ArrayList<>();
        verbs.add(new Phrase(R.string.verbs01, "verbs01.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs02, "verbs02.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs03, "verbs03.gif", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs04, "verbs04.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs05, "verbs05.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs06, "verbs06.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs07, "verbs07.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs08, "verbs08.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs09, "verbs09.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs10, "verbs10.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs11, "verbs11.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs12, "verbs12.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs13, "verbs13.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs14, "verbs14.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs15, "verbs15.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs16, "verbs16.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs17, "verbs17.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs18, "verbs18.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs19, "verbs19.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs20, "verbs20.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs21, "verbs21.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs22, "verbs22.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs23, "verbs23.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs24, "verbs24.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs25, "verbs25.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs26, "verbs26.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs27, "verbs27.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs28, "verbs28.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs29, "verbs29.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs30, "verbs30.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs31, "verbs31.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs32, "verbs32.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs33, "verbs33.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs34, "verbs34.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs35, "verbs35.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs36, "verbs36.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs37, "verbs37.png", defaultLanguage, translateLanguage));
        verbs.add(new Phrase(R.string.verbs38, "verbs38.png", defaultLanguage, translateLanguage));


        adjectives = new ArrayList<>();
        adjectives.add(new Phrase(R.string.adjectives01, "adjectives01.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives02, "adjectives02.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives03, "adjectives03.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives04, "adjectives04.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives05, "adjectives05.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives06, "adjectives06.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives07, "adjectives07.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives08, "adjectives08.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives09, "adjectives09.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives10, "adjectives10.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives11, "adjectives11.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives12, "adjectives12.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives13, "adjectives13.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives14, "adjectives14.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives15, "adjectives15.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives16, "adjectives16.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives17, "adjectives17.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives18, "adjectives18.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives19, "adjectives19.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives20, "adjectives20.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives21, "adjectives21.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives22, "adjectives22.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives23, "adjectives23.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives24, "adjectives24.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives25, "adjectives25.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives26, "adjectives26.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives27, "adjectives27.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives28, "adjectives28.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives29, "adjectives29.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives30, "adjectives30.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives31, "adjectives31.png", defaultLanguage, translateLanguage));
        adjectives.add(new Phrase(R.string.adjectives32, "adjectives32.png", defaultLanguage, translateLanguage));

        phrases = new ArrayList<>();
        phrases.add(new Phrase(R.string.phrases01, "phrases01.gif", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases02, "phrases02.gif", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases03, "phrases03.png", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases04, "phrases04.png", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases05, "phrases05.png", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases06, "phrases06.gif", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases07, "phrases07.png", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases08, "phrases08.png", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases09, "phrases09.png", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases10, "phrases10.png", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases11, "phrases11.png", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases12, "phrases12.png", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases13, "phrases13.png", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases14, "phrases14.gif", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases15, "phrases14.gif", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases16, "phrases14.gif", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases17, "phrases17.png", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases18, "phrases18.png", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases19, "phrases19.png", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases20, "phrases20.png", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases21, "phrases21.png", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases22, "phrases22.png", defaultLanguage, translateLanguage));
        phrases.add(new Phrase(R.string.phrases23, "phrases23.png", defaultLanguage, translateLanguage));


        pretext = new ArrayList<>();
        pretext.add(new Phrase(R.string.pretext01, "pretext01.png", defaultLanguage, translateLanguage));
        pretext.add(new Phrase(R.string.pretext02, "pretext02.png", defaultLanguage, translateLanguage));
        pretext.add(new Phrase(R.string.pretext03, "pretext03.png", defaultLanguage, translateLanguage));
        pretext.add(new Phrase(R.string.pretext04, "pretext04.png", defaultLanguage, translateLanguage));
        pretext.add(new Phrase(R.string.pretext05, "pretext05.png", defaultLanguage, translateLanguage));
        pretext.add(new Phrase(R.string.pretext06, "pretext06.png", defaultLanguage, translateLanguage));
        pretext.add(new Phrase(R.string.pretext07, "pretext07.png", defaultLanguage, translateLanguage));
        pretext.add(new Phrase(R.string.pretext08, "pretext08.png", defaultLanguage, translateLanguage));
        pretext.add(new Phrase(R.string.pretext09, "pretext09.png", defaultLanguage, translateLanguage));
        pretext.add(new Phrase(R.string.pretext10, "pretext10.png", defaultLanguage, translateLanguage));
        pretext.add(new Phrase(R.string.pretext11, "pretext11.png", defaultLanguage, translateLanguage));
        pretext.add(new Phrase(R.string.pretext12, "pretext12.png", defaultLanguage, translateLanguage));
        pretext.add(new Phrase(R.string.pretext13, "pretext13.png", defaultLanguage, translateLanguage));
        pretext.add(new Phrase(R.string.pretext14, "pretext14.png", defaultLanguage, translateLanguage));
        pretext.add(new Phrase(R.string.pretext15, "pretext15.png", defaultLanguage, translateLanguage));
        pretext.add(new Phrase(R.string.pretext16, "pretext16.png", defaultLanguage, translateLanguage));
        pretext.add(new Phrase(R.string.pretext17, "pretext17.png", defaultLanguage, translateLanguage));
        pretext.add(new Phrase(R.string.pretext18, "pretext18.png", defaultLanguage, translateLanguage));
        pretext.add(new Phrase(R.string.pretext19, "pretext19.png", defaultLanguage, translateLanguage));
        pretext.add(new Phrase(R.string.pretext20, "pretext20.png", defaultLanguage, translateLanguage));

        geo = new ArrayList<>();
        geo.add(new Phrase(R.string.geo01, "🇦🇨", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo02,"🇦🇩", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo03, "🇦🇪", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo04, "🇦🇫", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo05, "🇦🇬", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo06, "🇦🇮", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo07, "🇦🇱", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo08, "🇦🇲", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo09, "🇦🇴", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo10, "🇦🇶", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo11, "🇦🇷", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo12, "🇦🇸", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo13, "🇦🇹", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo14, "🇦🇺", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo15, "🇦🇼", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo16, "🇦🇽", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo17, "🇦🇿", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo18, "🇧🇦", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo19, "🇧🇧", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo20, "🇧🇩", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo21, "🇧🇪", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo22, "🇧🇫", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo23, "🇧🇬", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo24, "🇧🇭", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo25, "🇧🇮", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo26, "🇧🇯", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo27, "🇧🇱", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo28, "🇧🇲", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo29, "🇧🇳", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo30, "🇧🇴", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo31, "🇧🇶", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo32, "🇧🇷", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo33, "🇧🇸", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo34, "🇧🇹", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo35, "🇧🇻", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo36, "🇧🇼", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo37, "🇧🇾", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo38, "🇧🇿", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo39, "🇨🇦", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo40, "🇨🇨", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo41, "🇨🇩", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo42, "🇨🇫", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo43, "🇨🇬", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo44, "🇨🇭", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo45, "🇨🇮", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo46, "🇨🇰", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo47, "🇨🇱", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo48, "🇨🇲", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo49, "🇨🇳", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo50, "🇨🇴", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo51, "🇨🇵", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo52, "🇨🇷", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo53, "🇨🇺", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo54, "🇨🇻", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo55, "🇨🇼", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo56, "🇨🇽", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo57, "🇨🇾", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo58, "🇨🇿", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo59, "🇩🇪", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo60, "🇩🇬", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo61,"🇩🇯", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo62,"🇩🇰", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo63,"🇩🇲", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo64,"🇩🇴", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo65,"🇩🇿", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo66,"🇪🇦", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo67,"🇪🇨", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo68,"🇪🇪", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo69,"🇪🇬", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo70,"🇪🇭", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo71,"🇪🇷", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo72,"🇪🇸", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo73,"🇪🇹", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo74,"🇪🇺", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo75,"🇫🇮", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo76,"🇫🇯", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo77,"🇫🇰", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo78,"🇫🇲", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo79,"🇫🇴", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo80,"🇫🇷", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo81,"🇬🇦", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo82,"🇬🇧", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo83,"🇬🇩", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo84,"🇬🇪", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo85,"🇬🇫", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo86,"🇬🇬", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo87,"🇬🇭", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo88,"🇬🇮", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo89,"🇬🇱", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo90,"🇬🇲", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo91,"🇬🇳", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo92,"🇬🇵", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo93,"🇬🇶", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo94,"🇬🇷", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo95,"🇬🇸", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo96,"🇬🇹", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo97,"🇬🇺", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo98,"🇬🇼", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo99,"🇬🇾", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo100,"🇭🇰", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo101,"🇭🇲", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo102,"🇭🇳", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo103,"🇭🇷", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo104,"🇭🇹", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo105,"🇭🇺", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo106,"🇮🇨", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo107,"🇮🇩", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo108,"🇪", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo109,"🇮🇱", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo110,"🇮🇲", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo111,"🇮🇳", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo112,"🇮🇴", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo113,"🇮🇶", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo114,"🇮🇷", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo115,"🇮🇸", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo116,"🇮🇹", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo117,"🇯🇪", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo118,"🇯🇲", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo119,"🇯🇴", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo120,"🇯🇵", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo121,"🇰🇪", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo122,"🇰🇬", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo123,"🇰🇭", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo124,"🇰🇮", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo125,"🇰🇲", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo126,"🇰🇳", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo127,"🇰🇵", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo128,"🇰🇷", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo129,"🇰🇼", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo130,"🇰🇾", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo131,"🇰🇿", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo132,"🇱🇦", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo133,"🇱🇧", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo134,"🇱🇨", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo135,"🇱🇮", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo136,"🇱🇰", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo137,"🇱🇷", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo138,"🇱🇸", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo139,"🇱🇹", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo140,"🇱🇺", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo141,"🇱🇻", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo142,"🇱🇾", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo143,"🇲🇦", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo144,"🇲🇨", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo145,"🇲🇩", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo146,"🇲🇪", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo147,"🇲🇫", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo148,"🇲🇬", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo149,"🇲🇭", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo150,"🇲🇰", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo151,"🇲🇱", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo152,"🇲🇲", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo153,"🇲🇳", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo154,"🇲🇴", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo155,"🇲🇵", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo156,"🇲🇶", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo157,"🇲🇷", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo158,"🇲🇸", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo159,"🇲🇹", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo160,"🇲🇺", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo161,"🇲🇻", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo162,"🇲🇼", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo163,"🇲🇽", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo164,"🇲🇾", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo165, "🇲🇿", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo166,"🇳🇦", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo167,"🇳🇨", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo168,"🇳🇪", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo169,"🇳🇫", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo170,"🇳🇬", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo171,"🇳🇮", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo172,"🇳🇱", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo173,"🇳🇴", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo174,"🇳🇵", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo175,"🇳🇷", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo176,"🇳🇺", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo177,"🇳🇿", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo178,"🇴🇲", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo179,"🇵🇦", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo180,"🇵🇪", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo181,"🇵🇫", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo182,"🇵🇬", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo183,"🇵🇭", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo184,"🇵🇰", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo185,"🇵🇱", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo186,"🇵🇲", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo187,"🇵🇳", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo188,"🇵🇷", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo189,"🇵🇸", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo190,"🇵🇹", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo191,"🇵🇼", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo192,"🇵🇾", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo193,"🇶🇦", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo194,"🇷🇪", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo195,"🇷🇴", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo196,"🇷🇸", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo197,"🇷🇺", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo198,"🇷🇼", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo199,"🇸🇦", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo200,"🇸🇧", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo201,"🇸🇨", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo202,"🇸🇩", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo203, "🇸🇪", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo204, "🇸🇬", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo205, "🇸🇭", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo206, "🇸🇮", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo207, "🇸🇯", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo208, "🇸🇰", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo209, "🇸🇱", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo210, "🇸🇲", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo211, "🇸🇳", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo212, "🇸🇴", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo213, "🇸🇷", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo214, "🇸🇸", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo215, "🇸🇹", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo216, "🇸🇻", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo217, "🇸🇽", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo218, "🇸🇾", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo219, "🇸🇿", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo220, "🇹🇦", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo221, "🇹🇨", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo222, "🇹🇩", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo223, "🇹🇫", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo224, "🇹🇬", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo225, "🇹🇭", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo226, "🇹🇯", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo227, "🇹🇰", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo228, "🇹🇱", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo229, "🇹🇲", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo230, "🇹🇳", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo231, "🇹🇴", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo232, "🇹🇷", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo233, "🇹🇹", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo234, "🇹🇻", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo235, "🇹🇼", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo236, "🇹🇿", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo237, "🇺🇦", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo238, "🇺🇬", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo239, "🇺🇲", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo240, "🇺🇳", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo241, "🇺🇸", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo242, "🇺🇾", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo243, "🇺🇿", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo244, "🇻🇦", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo245, "🇻🇨", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo246, "🇻🇪", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo247, "🇻🇬", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo248, "🇻🇮", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo249, "🇻🇳", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo250, "🇻🇺", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo251, "🇼🇫", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo252, "\uD83C\uDDFD\uD83C\uDDF0", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo253, "🇽🇰", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo254, "🇾🇪", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo255, "🇾🇹", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo256, "🇿🇦", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo257, "🇿🇲", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo258, "🇿🇼", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo259, "\uD83C\uDF0F", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo260, "\uD83C\uDF0D", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo261, "\uD83C\uDF0D", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo262, "\uD83C\uDF0D", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo263, "\uD83C\uDF0E", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo264, "\uD83C\uDF0F", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo265, "\uD83C\uDF0E", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo266, "\uD83C\uDF0E", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo267, "\uD83C\uDF0E", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo268, "\uD83C\uDF0A", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo269, "\uD83C\uDF0A", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo270, "\uD83C\uDF0A", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo271, "\uD83C\uDF0A", defaultLanguage, translateLanguage));
        geo.add(new Phrase(R.string.geo272, "\uD83C\uDF0A", defaultLanguage, translateLanguage));


    }
}
