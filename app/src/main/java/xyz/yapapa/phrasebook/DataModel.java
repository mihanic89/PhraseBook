package xyz.yapapa.phrasebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

/**
 * Содержимое карточек. Категории строятся при первом обращении и кэшируются,
 * алфавиты и числа — буквы и цифры для вкладок «Алфавит» и «Числа».
 */
final class DataModel {

    private static final Map<Category, List<Phrase>> CACHE = new EnumMap<>(Category.class);

    private DataModel() {
    }

    /** Карточки категории с картинками, флагами или цветами (не алфавит и не числа). */
    static synchronized List<Phrase> phrases(Category category) {
        List<Phrase> list = CACHE.get(category);
        if (list == null) {
            list = Collections.unmodifiableList(build(category));
            CACHE.put(category, list);
        }
        return list;
    }

    /** Буквы алфавита языка; для неподдерживаемого языка — латиница. */
    static List<String> alphabet(String language) {
        String letters;
        switch (language) {
            case "de":
                letters = "A Ä B C D E F G H I J K L M N O Ö P Q R S ẞ T U Ü V W X Y Z";
                break;
            case "it":
                letters = "A B C D E F G H I L M N O P Q R S T U V Z";
                break;
            case "fi":
                letters = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z Å Ä Ö";
                break;
            case "es":
                letters = "A B C D E F G H I J K L M N Ñ O P Q R S T U V W X Y Z";
                break;
            case "ru":
                letters = "А Б В Г Д Е Ё Ж З И Й К Л М Н О П Р С Т У Ф Х Ц Ч Ш Щ Ъ Ы Ь Э Ю Я";
                break;
            case "be":
                letters = "А Б В Г Д Е Ё Ж З І Й К Л М Н О П Р С Т У Ў Ф Х Ц Ч Ш Ы Ь Э Ю Я";
                break;
            case "uk":
                letters = "А Б В Г Ґ Д Е Є Ж З И І Ї Й К Л М Н О П Р С Т У Ф Х Ц Ч Ш Щ Ь Ю Я";
                break;
            default:
                letters = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z";
                break;
        }
        return Collections.unmodifiableList(Arrays.asList(letters.split(" ")));
    }

    static List<String> numbers() {
        ArrayList<String> numbers = new ArrayList<>();
        for (int i = 0; i <= 1000; i++) {
            numbers.add(Integer.toString(i));
        }
        numbers.add("1000000");
        return Collections.unmodifiableList(numbers);
    }

    private static List<Phrase> build(Category category) {
        switch (category) {
            case COLORS: return buildColors();
            case FORMS: return buildForms();
            case TIME: return buildTime();
            case FAMILY: return buildFamily();
            case CLOTHES: return buildClothes();
            case FOOD: return buildFood();
            case VEGETABLES: return buildVegetables();
            case FRUITS: return buildFruits();
            case BERRIES: return buildBerries();
            case FLOWERS: return buildFlowers();
            case BODY: return buildBody();
            case EMOTIONS: return buildEmotions();
            case ANIMALS: return buildAnimals();
            case HOUSE: return buildHouse();
            case OBJECTS: return buildObjects();
            case TOYS: return buildToys();
            case MUSICINST: return buildMusicinst();
            case SPORT: return buildSport();
            case TRANSPORT: return buildTransport();
            case CITY: return buildCity();
            case NATURE: return buildNature();
            case ART: return buildArt();
            case SCHOOL: return buildSchool();
            case PROF: return buildProf();
            case VERBS: return buildVerbs();
            case ADJECTIVES: return buildAdjectives();
            case PHRASES: return buildPhrases();
            case PRETEXT: return buildPretext();
            case GEO: return buildGeo();
            default:
                throw new IllegalArgumentException("Нет карточек для " + category);
        }
    }

    private static List<Phrase> buildColors() {
        ArrayList<Phrase> colors = new ArrayList<>();
        colors.add(Phrase.color(R.string.colors01, android.R.color.white));
        colors.add(Phrase.color(R.string.colors02, android.R.color.holo_red_light));
        colors.add(Phrase.color(R.string.colors03, android.R.color.holo_orange_dark));
        colors.add(Phrase.color(R.string.colors04, R.color.yellow));
        colors.add(Phrase.color(R.string.colors05, android.R.color.holo_green_light));
        colors.add(Phrase.color(R.string.colors06, android.R.color.holo_green_dark));
        colors.add(Phrase.color(R.string.colors07, android.R.color.holo_blue_light));
        colors.add(Phrase.color(R.string.colors08, R.color.pink));
        colors.add(Phrase.color(R.string.colors09, android.R.color.holo_blue_dark));
        colors.add(Phrase.color(R.string.colors10, R.color.lillac));
        colors.add(Phrase.color(R.string.colors11, android.R.color.holo_purple));
        colors.add(Phrase.color(R.string.colors12, R.color.indigo));
        colors.add(Phrase.color(R.string.colors13, R.color.grey));
        colors.add(Phrase.color(R.string.colors14, R.color.brown));
        colors.add(Phrase.color(R.string.colors15, android.R.color.black));
        return colors;
    }

    private static List<Phrase> buildForms() {
        ArrayList<Phrase> forms = new ArrayList<>();
        forms.add(Phrase.image(R.string.forms01, "forms01.png"));
        forms.add(Phrase.image(R.string.forms02, "forms02.png"));
        forms.add(Phrase.image(R.string.forms03, "forms03.png"));
        forms.add(Phrase.image(R.string.forms04, "forms04.png"));
        forms.add(Phrase.image(R.string.forms05, "forms05.png"));
        forms.add(Phrase.image(R.string.forms06, "forms06.png"));
        forms.add(Phrase.image(R.string.forms07, "forms07.png"));
        forms.add(Phrase.image(R.string.forms08, "forms08.png"));
        forms.add(Phrase.image(R.string.forms09, "forms09.png"));
        forms.add(Phrase.image(R.string.forms10, "forms10.png"));
        forms.add(Phrase.image(R.string.forms11, "forms11.png"));
        forms.add(Phrase.image(R.string.forms12, "forms12.png"));
        forms.add(Phrase.image(R.string.forms13, "forms13.png"));
        forms.add(Phrase.image(R.string.forms14, "forms14.png"));
        forms.add(Phrase.image(R.string.forms15, "forms15.png"));
        forms.add(Phrase.image(R.string.forms16, "forms16.png"));
        forms.add(Phrase.image(R.string.forms17, "forms17.png"));
        forms.add(Phrase.image(R.string.forms18, "forms18.png"));
        forms.add(Phrase.image(R.string.forms19, "forms19.png"));
        forms.add(Phrase.image(R.string.forms20, "forms20.png"));
        forms.add(Phrase.image(R.string.forms21, "forms21.png"));
        forms.add(Phrase.image(R.string.forms22, "forms22.png"));
        forms.add(Phrase.image(R.string.forms23, "forms23.png"));
        forms.add(Phrase.image(R.string.forms24, "forms24.png"));
        return forms;
    }

    private static List<Phrase> buildTime() {
        ArrayList<Phrase> time = new ArrayList<>();
        time.add(Phrase.image(R.string.time01, "time01.png"));
        time.add(Phrase.image(R.string.time02, "time02.png"));
        time.add(Phrase.image(R.string.time03, "time03.png"));
        time.add(Phrase.image(R.string.time04, "time04.png"));
        time.add(Phrase.image(R.string.time05, "time05.png"));
        time.add(Phrase.image(R.string.time06, "time06.png"));
        time.add(Phrase.image(R.string.time07, "time07.png"));
        time.add(Phrase.image(R.string.time08, "time08.png"));
        time.add(Phrase.image(R.string.time09, "time09.png"));
        time.add(Phrase.image(R.string.time10, "time10.png"));
        time.add(Phrase.image(R.string.time11, "time11.png"));
        time.add(Phrase.image(R.string.time12, "time12.png"));
        time.add(Phrase.image(R.string.time13, "time13.png"));
        time.add(Phrase.image(R.string.time14, "time14.png"));
        time.add(Phrase.image(R.string.time15, "time15.png"));
        time.add(Phrase.image(R.string.time16, "time16.png"));
        time.add(Phrase.image(R.string.time17, "time16.png"));
        time.add(Phrase.image(R.string.time18, "time18.png"));
        time.add(Phrase.image(R.string.time19, "time19.png"));
        time.add(Phrase.image(R.string.time20, "time20.png"));
        time.add(Phrase.image(R.string.time21, "time21.png"));
        time.add(Phrase.image(R.string.time22, "time22.png"));
        time.add(Phrase.image(R.string.time23, "time23.png"));
        time.add(Phrase.image(R.string.time24, "time24.png"));
        time.add(Phrase.image(R.string.time25, "time25.png"));
        time.add(Phrase.image(R.string.time26, "time26.png"));
        time.add(Phrase.image(R.string.time27, "time27.png"));
        time.add(Phrase.image(R.string.time28, "time28.png"));
        time.add(Phrase.image(R.string.time29, "time29.png"));
        time.add(Phrase.image(R.string.time30, "time30.png"));
        time.add(Phrase.image(R.string.time31, "time31.png"));
        time.add(Phrase.image(R.string.time32, "time32.png"));
        time.add(Phrase.image(R.string.time33, "time33.png"));
        return time;
    }

    private static List<Phrase> buildFamily() {
        ArrayList<Phrase> family = new ArrayList<>();
        family.add(Phrase.image(R.string.family01, "family01.png"));
        family.add(Phrase.image(R.string.family02, "family02.png"));
        family.add(Phrase.image(R.string.family03, "family03.png"));
        family.add(Phrase.image(R.string.family04, "family04.png"));
        family.add(Phrase.image(R.string.family05, "family05.png"));
        family.add(Phrase.image(R.string.family06, "family06.png"));
        family.add(Phrase.image(R.string.family07, "family07.png"));
        family.add(Phrase.image(R.string.family08, "family08.png"));
        family.add(Phrase.image(R.string.family09, "family09.png"));
        family.add(Phrase.image(R.string.family10, "family10.png"));
        family.add(Phrase.image(R.string.family11, "family11.png"));
        family.add(Phrase.image(R.string.family12, "family12.png"));
        family.add(Phrase.image(R.string.family13, "family13.png"));
        family.add(Phrase.image(R.string.family14, "family14.png"));
        family.add(Phrase.image(R.string.family15, "family15.png"));
        family.add(Phrase.image(R.string.family16, "family16.png"));
        family.add(Phrase.image(R.string.family17, "family17.png"));
        family.add(Phrase.image(R.string.family18, "family18.png"));
        family.add(Phrase.image(R.string.family19, "family19.png"));
        family.add(Phrase.image(R.string.family20, "family20.png"));
        family.add(Phrase.image(R.string.family21, "family21.png"));
        family.add(Phrase.image(R.string.family22, "family22.png"));
        family.add(Phrase.image(R.string.family23, "family23.png"));
        family.add(Phrase.image(R.string.family24, "family24.png"));
        family.add(Phrase.image(R.string.family25, "family25.png"));
        family.add(Phrase.image(R.string.family26, "family26.png"));
        family.add(Phrase.image(R.string.family27, "family27.png"));
        family.add(Phrase.image(R.string.family28, "family28.png"));
        family.add(Phrase.image(R.string.family29, "family29.png"));
        family.add(Phrase.image(R.string.family30, "family30.png"));
        return family;
    }

    private static List<Phrase> buildClothes() {
        ArrayList<Phrase> clothes = new ArrayList<>();
        clothes.add(Phrase.image(R.string.clothes01, "clothes01.png"));
        clothes.add(Phrase.image(R.string.clothes02, "clothes02.png"));
        clothes.add(Phrase.image(R.string.clothes03, "clothes03.png"));
        clothes.add(Phrase.image(R.string.clothes04, "clothes04.png"));
        clothes.add(Phrase.image(R.string.clothes05, "clothes05.png"));
        clothes.add(Phrase.image(R.string.clothes06, "clothes06.png"));
        clothes.add(Phrase.image(R.string.clothes07, "clothes07.png"));
        clothes.add(Phrase.image(R.string.clothes08, "clothes08.png"));
        clothes.add(Phrase.image(R.string.clothes09, "clothes09.png"));
        clothes.add(Phrase.image(R.string.clothes10, "clothes10.png"));
        clothes.add(Phrase.image(R.string.clothes11, "clothes11.png"));
        clothes.add(Phrase.image(R.string.clothes12, "clothes12.png"));
        clothes.add(Phrase.image(R.string.clothes13, "clothes13.png"));
        clothes.add(Phrase.image(R.string.clothes14, "clothes14.png"));
        clothes.add(Phrase.image(R.string.clothes15, "clothes15.png"));
        clothes.add(Phrase.image(R.string.clothes16, "clothes16.png"));
        clothes.add(Phrase.image(R.string.clothes17, "clothes17.png"));
        clothes.add(Phrase.image(R.string.clothes18, "clothes18.png"));
        clothes.add(Phrase.image(R.string.clothes19, "clothes19.png"));
        clothes.add(Phrase.image(R.string.clothes20, "clothes20.png"));
        clothes.add(Phrase.image(R.string.clothes21, "clothes21.png"));
        clothes.add(Phrase.image(R.string.clothes22, "clothes22.png"));
        clothes.add(Phrase.image(R.string.clothes23, "clothes23.png"));
        clothes.add(Phrase.image(R.string.clothes24, "clothes24.png"));
        clothes.add(Phrase.image(R.string.clothes25, "clothes25.png"));
        clothes.add(Phrase.image(R.string.clothes26, "clothes26.png"));
        clothes.add(Phrase.image(R.string.clothes27, "clothes27.png"));
        clothes.add(Phrase.image(R.string.clothes28, "clothes28.png"));
        clothes.add(Phrase.image(R.string.clothes29, "clothes29.png"));
        clothes.add(Phrase.image(R.string.clothes30, "clothes30.png"));
        clothes.add(Phrase.image(R.string.clothes31, "clothes31.png"));
        clothes.add(Phrase.image(R.string.clothes32, "clothes32.png"));
        clothes.add(Phrase.image(R.string.clothes33, "clothes33.png"));
        clothes.add(Phrase.image(R.string.clothes34, "clothes34.png"));
        clothes.add(Phrase.image(R.string.clothes35, "clothes35.png"));
        clothes.add(Phrase.image(R.string.clothes36, "clothes36.png"));
        clothes.add(Phrase.image(R.string.clothes37, "clothes37.png"));
        clothes.add(Phrase.image(R.string.clothes38, "clothes38.png"));
        return clothes;
    }

    private static List<Phrase> buildFood() {
        ArrayList<Phrase> food = new ArrayList<>();
        food.add(Phrase.image(R.string.food01, "food01.png"));
        food.add(Phrase.image(R.string.food02, "food02.png"));
        food.add(Phrase.image(R.string.food03, "food03.gif"));
        food.add(Phrase.image(R.string.food04, "food04.png"));
        food.add(Phrase.image(R.string.food05, "food05.png"));
        food.add(Phrase.image(R.string.food06, "food06.png"));
        food.add(Phrase.image(R.string.food07, "food07.png"));
        food.add(Phrase.image(R.string.food08, "food08.png"));
        food.add(Phrase.image(R.string.food09, "food09.png"));
        food.add(Phrase.image(R.string.food10, "food10.png"));
        food.add(Phrase.image(R.string.food11, "food11.png"));
        food.add(Phrase.image(R.string.food12, "food12.png"));
        food.add(Phrase.image(R.string.food13, "food13.png"));
        food.add(Phrase.image(R.string.food14, "food14.png"));
        food.add(Phrase.image(R.string.food15, "food15.png"));
        food.add(Phrase.image(R.string.food16, "food16.png"));
        food.add(Phrase.image(R.string.food17, "food17.png"));
        food.add(Phrase.image(R.string.food18, "food18.png"));
        food.add(Phrase.image(R.string.food19, "food19.png"));
        food.add(Phrase.image(R.string.food20, "food20.png"));
        food.add(Phrase.image(R.string.food21, "food21.gif"));
        food.add(Phrase.image(R.string.food22, "food22.png"));
        food.add(Phrase.image(R.string.food23, "food23.png"));
        food.add(Phrase.image(R.string.food24, "food24.png"));
        food.add(Phrase.image(R.string.food25, "food25.png"));
        food.add(Phrase.image(R.string.food26, "food26.png"));
        food.add(Phrase.image(R.string.food27, "food27.png"));
        food.add(Phrase.image(R.string.food28, "food28.png"));
        food.add(Phrase.image(R.string.food29, "food29.png"));
        food.add(Phrase.image(R.string.food30, "food30.png"));
        food.add(Phrase.image(R.string.food31, "food31.png"));
        food.add(Phrase.image(R.string.food32, "food32.png"));
        food.add(Phrase.image(R.string.food33, "food33.png"));
        food.add(Phrase.image(R.string.food34, "food34.png"));
        food.add(Phrase.image(R.string.food35, "food35.png"));
        food.add(Phrase.image(R.string.food36, "food36.png"));
        food.add(Phrase.image(R.string.food37, "food37.png"));
        food.add(Phrase.image(R.string.food38, "food38.png"));
        food.add(Phrase.image(R.string.food39, "food39.png"));
        food.add(Phrase.image(R.string.food40, "food40.png"));
        food.add(Phrase.image(R.string.food41, "food41.png"));
        food.add(Phrase.image(R.string.food42, "food42.png"));
        food.add(Phrase.image(R.string.food43, "food43.png"));
        return food;
    }

    private static List<Phrase> buildVegetables() {
        ArrayList<Phrase> vegetables = new ArrayList<>();
        vegetables.add(Phrase.image(R.string.vegetables01, "vegetables01.png"));
        vegetables.add(Phrase.image(R.string.vegetables02, "vegetables02.png"));
        vegetables.add(Phrase.image(R.string.vegetables03, "vegetables03.png"));
        vegetables.add(Phrase.image(R.string.vegetables04, "vegetables04.png"));
        vegetables.add(Phrase.image(R.string.vegetables05, "vegetables05.png"));
        vegetables.add(Phrase.image(R.string.vegetables06, "vegetables06.png"));
        vegetables.add(Phrase.image(R.string.vegetables07, "vegetables07.png"));
        vegetables.add(Phrase.image(R.string.vegetables08, "vegetables08.png"));
        vegetables.add(Phrase.image(R.string.vegetables09, "vegetables09.png"));
        vegetables.add(Phrase.image(R.string.vegetables10, "vegetables10.png"));
        vegetables.add(Phrase.image(R.string.vegetables11, "vegetables11.png"));
        vegetables.add(Phrase.image(R.string.vegetables12, "vegetables12.png"));
        vegetables.add(Phrase.image(R.string.vegetables13, "vegetables13.png"));
        vegetables.add(Phrase.image(R.string.vegetables14, "vegetables14.png"));
        vegetables.add(Phrase.image(R.string.vegetables15, "vegetables15.png"));
        vegetables.add(Phrase.image(R.string.vegetables16, "vegetables16.png"));
        return vegetables;
    }

    private static List<Phrase> buildFruits() {
        ArrayList<Phrase> fruits = new ArrayList<>();
        fruits.add(Phrase.image(R.string.fruits01, "fruits01.png"));
        fruits.add(Phrase.image(R.string.fruits02, "fruits02.png"));
        fruits.add(Phrase.image(R.string.fruits03, "fruits03.png"));
        fruits.add(Phrase.image(R.string.fruits04, "fruits04.png"));
        fruits.add(Phrase.image(R.string.fruits05, "fruits05.png"));
        fruits.add(Phrase.image(R.string.fruits06, "fruits06.png"));
        fruits.add(Phrase.image(R.string.fruits07, "fruits07.png"));
        fruits.add(Phrase.image(R.string.fruits08, "fruits08.png"));
        fruits.add(Phrase.image(R.string.fruits09, "fruits09.png"));
        fruits.add(Phrase.image(R.string.fruits10, "fruits10.png"));
        fruits.add(Phrase.image(R.string.fruits11, "fruits11.png"));
        fruits.add(Phrase.image(R.string.fruits12, "fruits12.png"));
        fruits.add(Phrase.image(R.string.fruits13, "fruits13.png"));
        fruits.add(Phrase.image(R.string.fruits14, "fruits14.png"));
        fruits.add(Phrase.image(R.string.fruits15, "fruits15.png"));
        fruits.add(Phrase.image(R.string.fruits16, "fruits16.png"));
        fruits.add(Phrase.image(R.string.fruits17, "fruits17.png"));
        fruits.add(Phrase.image(R.string.fruits18, "fruits18.png"));
        fruits.add(Phrase.image(R.string.fruits19, "fruits19.png"));
        fruits.add(Phrase.image(R.string.fruits20, "fruits20.png"));
        fruits.add(Phrase.image(R.string.fruits21, "fruits21.png"));
        fruits.add(Phrase.image(R.string.fruits22, "fruits22.png"));
        return fruits;
    }

    private static List<Phrase> buildBerries() {
        ArrayList<Phrase> berries = new ArrayList<>();
        berries.add(Phrase.image(R.string.berries01, "berries01.png"));
        berries.add(Phrase.image(R.string.berries02, "berries02.gif"));
        berries.add(Phrase.image(R.string.berries03, "berries03.png"));
        berries.add(Phrase.image(R.string.berries04, "berries04.png"));
        berries.add(Phrase.image(R.string.berries05, "berries05.png"));
        berries.add(Phrase.image(R.string.berries06, "berries06.png"));
        berries.add(Phrase.image(R.string.berries07, "berries07.png"));
        berries.add(Phrase.image(R.string.berries08, "berries08.png"));
        berries.add(Phrase.image(R.string.berries09, "berries09.png"));
        berries.add(Phrase.image(R.string.berries10, "berries10.png"));
        berries.add(Phrase.image(R.string.berries11, "berries11.png"));
        berries.add(Phrase.image(R.string.berries12, "berries12.png"));
        berries.add(Phrase.image(R.string.berries13, "berries13.png"));
        berries.add(Phrase.image(R.string.berries14, "berries14.png"));
        berries.add(Phrase.image(R.string.berries15, "berries15.png"));
        berries.add(Phrase.image(R.string.berries16, "berries16.png"));
        return berries;
    }

    private static List<Phrase> buildFlowers() {
        ArrayList<Phrase> flowers = new ArrayList<>();
        flowers.add(Phrase.image(R.string.flowers01, "flowers01.png"));
        flowers.add(Phrase.image(R.string.flowers02, "flowers02.png"));
        flowers.add(Phrase.image(R.string.flowers03, "flowers03.png"));
        flowers.add(Phrase.image(R.string.flowers04, "flowers04.png"));
        flowers.add(Phrase.image(R.string.flowers05, "flowers05.png"));
        flowers.add(Phrase.image(R.string.flowers06, "flowers06.png"));
        flowers.add(Phrase.image(R.string.flowers07, "flowers07.png"));
        flowers.add(Phrase.image(R.string.flowers08, "flowers08.gif"));
        flowers.add(Phrase.image(R.string.flowers09, "flowers09.png"));
        flowers.add(Phrase.image(R.string.flowers10, "flowers10.png"));
        flowers.add(Phrase.image(R.string.flowers11, "flowers11.png"));
        flowers.add(Phrase.image(R.string.flowers12, "flowers12.png"));
        flowers.add(Phrase.image(R.string.flowers13, "flowers13.png"));
        flowers.add(Phrase.image(R.string.flowers14, "flowers14.png"));
        flowers.add(Phrase.image(R.string.flowers15, "flowers15.png"));
        return flowers;
    }

    private static List<Phrase> buildBody() {
        ArrayList<Phrase> body = new ArrayList<>();
        body.add(Phrase.image(R.string.body01, "body01.png"));
        body.add(Phrase.image(R.string.body02, "body02.gif"));
        body.add(Phrase.image(R.string.body03, "body03.png"));
        body.add(Phrase.image(R.string.body04, "body04.png"));
        body.add(Phrase.image(R.string.body05, "body05.png"));
        body.add(Phrase.image(R.string.body06, "body06.png"));
        body.add(Phrase.image(R.string.body07, "body07.png"));
        body.add(Phrase.image(R.string.body08, "body08.png"));
        body.add(Phrase.image(R.string.body09, "body09.png"));
        body.add(Phrase.image(R.string.body10, "body10.png"));
        body.add(Phrase.image(R.string.body11, "body11.png"));
        body.add(Phrase.image(R.string.body12, "body12.png"));
        body.add(Phrase.image(R.string.body13, "body13.png"));
        body.add(Phrase.image(R.string.body14, "body14.png"));
        body.add(Phrase.image(R.string.body15, "body15.png"));
        body.add(Phrase.image(R.string.body16, "body16.png"));
        body.add(Phrase.image(R.string.body17, "body17.png"));
        body.add(Phrase.image(R.string.body18, "body18.png"));
        body.add(Phrase.image(R.string.body19, "body19.png"));
        body.add(Phrase.image(R.string.body20, "body20.png"));
        body.add(Phrase.image(R.string.body21, "body21.png"));
        body.add(Phrase.image(R.string.body22, "body22.png"));
        body.add(Phrase.image(R.string.body23, "body23.png"));
        body.add(Phrase.image(R.string.body24, "body24.gif"));
        return body;
    }

    private static List<Phrase> buildEmotions() {
        ArrayList<Phrase> emotions = new ArrayList<>();
        emotions.add(Phrase.image(R.string.emotions01, "emotions01.gif"));
        emotions.add(Phrase.image(R.string.emotions02, "emotions02.gif"));
        emotions.add(Phrase.image(R.string.emotions03, "emotions03.gif"));
        emotions.add(Phrase.image(R.string.emotions04, "emotions04.gif"));
        emotions.add(Phrase.image(R.string.emotions05, "emotions05.gif"));
        emotions.add(Phrase.image(R.string.emotions06, "emotions06.gif"));
        emotions.add(Phrase.image(R.string.emotions07, "emotions07.gif"));
        emotions.add(Phrase.image(R.string.emotions08, "emotions08.gif"));
        emotions.add(Phrase.image(R.string.emotions09, "emotions09.gif"));
        emotions.add(Phrase.image(R.string.emotions10, "emotions10.gif"));
        emotions.add(Phrase.image(R.string.emotions11, "emotions11.gif"));
        emotions.add(Phrase.image(R.string.emotions12, "emotions12.gif"));
        emotions.add(Phrase.image(R.string.emotions13, "emotions13.gif"));
        emotions.add(Phrase.image(R.string.emotions14, "emotions14.gif"));
        emotions.add(Phrase.image(R.string.emotions15, "emotions15.gif"));
        emotions.add(Phrase.image(R.string.emotions16, "emotions16.gif"));
        emotions.add(Phrase.image(R.string.emotions17, "emotions17.gif"));
        return emotions;
    }

    private static List<Phrase> buildAnimals() {
        ArrayList<Phrase> animals = new ArrayList<>();
        animals.add(Phrase.image(R.string.animals01, "animals01.gif"));
        animals.add(Phrase.image(R.string.animals02, "animals02.gif"));
        animals.add(Phrase.image(R.string.animals03, "animals03.png"));
        animals.add(Phrase.image(R.string.animals04, "animals04.png"));
        animals.add(Phrase.image(R.string.animals05, "animals05.png"));
        animals.add(Phrase.image(R.string.animals06, "animals06.png"));
        animals.add(Phrase.image(R.string.animals07, "animals07.png"));
        animals.add(Phrase.image(R.string.animals08, "animals08.png"));
        animals.add(Phrase.image(R.string.animals09, "animals09.png"));
        animals.add(Phrase.image(R.string.animals10, "animals10.png"));
        animals.add(Phrase.image(R.string.animals11, "animals11.png"));
        animals.add(Phrase.image(R.string.animals12, "animals12.png"));
        animals.add(Phrase.image(R.string.animals13, "animals13.png"));
        animals.add(Phrase.image(R.string.animals14, "animals14.png"));
        animals.add(Phrase.image(R.string.animals15, "animals15.png"));
        animals.add(Phrase.image(R.string.animals16, "animals16.png"));
        animals.add(Phrase.image(R.string.animals17, "animals17.png"));
        animals.add(Phrase.image(R.string.animals18, "animals18.png"));
        animals.add(Phrase.image(R.string.animals19, "animals19.png"));
        animals.add(Phrase.image(R.string.animals20, "animals20.gif"));
        animals.add(Phrase.image(R.string.animals21, "animals21.png"));
        animals.add(Phrase.image(R.string.animals22, "animals22.png"));
        animals.add(Phrase.image(R.string.animals23, "animals23.png"));
        animals.add(Phrase.image(R.string.animals24, "animals24.png"));
        animals.add(Phrase.image(R.string.animals25, "animals25.png"));
        animals.add(Phrase.image(R.string.animals26, "animals26.png"));
        animals.add(Phrase.image(R.string.animals27, "animals27.png"));
        animals.add(Phrase.image(R.string.animals28, "animals28.png"));
        animals.add(Phrase.image(R.string.animals29, "animals29.png"));
        animals.add(Phrase.image(R.string.animals30, "animals30.png"));
        animals.add(Phrase.image(R.string.animals31, "animals31.png"));
        animals.add(Phrase.image(R.string.animals32, "animals32.png"));
        animals.add(Phrase.image(R.string.animals33, "animals33.png"));
        animals.add(Phrase.image(R.string.animals34, "animals34.png"));
        animals.add(Phrase.image(R.string.animals35, "animals35.png"));
        animals.add(Phrase.image(R.string.animals36, "animals36.png"));
        animals.add(Phrase.image(R.string.animals37, "animals37.png"));
        animals.add(Phrase.image(R.string.animals38, "animals38.png"));
        animals.add(Phrase.image(R.string.animals39, "animals39.png"));
        animals.add(Phrase.image(R.string.animals40, "animals40.png"));
        animals.add(Phrase.image(R.string.animals41, "animals41.png"));
        animals.add(Phrase.image(R.string.animals42, "animals42.png"));
        animals.add(Phrase.image(R.string.animals43, "animals43.png"));
        animals.add(Phrase.image(R.string.animals44, "animals44.png"));
        animals.add(Phrase.image(R.string.animals45, "animals45.png"));
        animals.add(Phrase.image(R.string.animals46, "animals46.png"));
        animals.add(Phrase.image(R.string.animals47, "animals47.png"));
        animals.add(Phrase.image(R.string.animals48, "animals48.png"));
        animals.add(Phrase.image(R.string.animals49, "animals49.png"));
        animals.add(Phrase.image(R.string.animals50, "animals50.png"));
        animals.add(Phrase.image(R.string.animals51, "animals51.gif"));
        animals.add(Phrase.image(R.string.animals52, "animals52.png"));
        animals.add(Phrase.image(R.string.animals53, "animals53.png"));
        animals.add(Phrase.image(R.string.animals54, "animals54.png"));
        animals.add(Phrase.image(R.string.animals55, "animals55.png"));
        animals.add(Phrase.image(R.string.animals56, "animals56.png"));
        animals.add(Phrase.image(R.string.animals57, "animals57.png"));
        animals.add(Phrase.image(R.string.animals58, "animals58.png"));
        animals.add(Phrase.image(R.string.animals59, "animals59.png"));
        animals.add(Phrase.image(R.string.animals60, "animals60.png"));
        animals.add(Phrase.image(R.string.animals61, "animals61.png"));
        animals.add(Phrase.image(R.string.animals62, "animals62.png"));
        animals.add(Phrase.image(R.string.animals63, "animals63.png"));
        animals.add(Phrase.image(R.string.animals64, "animals64.png"));
        animals.add(Phrase.image(R.string.animals65, "animals65.png"));
        animals.add(Phrase.image(R.string.animals66, "animals66.png"));
        animals.add(Phrase.image(R.string.animals67, "animals67.png"));
        animals.add(Phrase.image(R.string.animals68, "animals68.png"));
        animals.add(Phrase.image(R.string.animals69, "animals69.png"));
        animals.add(Phrase.image(R.string.animals70, "animals70.png"));
        animals.add(Phrase.image(R.string.animals71, "animals71.png"));
        animals.add(Phrase.image(R.string.animals72, "animals72.png"));
        return animals;
    }

    private static List<Phrase> buildHouse() {
        ArrayList<Phrase> house = new ArrayList<>();
        house.add(Phrase.image(R.string.house01, "house01.png"));
        house.add(Phrase.image(R.string.house02, "house02.png"));
        house.add(Phrase.image(R.string.house03, "house03.png"));
        house.add(Phrase.image(R.string.house04, "house04.png"));
        house.add(Phrase.image(R.string.house05, "house05.png"));
        house.add(Phrase.image(R.string.house06, "house06.png"));
        house.add(Phrase.image(R.string.house07, "house07.png"));
        house.add(Phrase.image(R.string.house08, "house08.png"));
        house.add(Phrase.image(R.string.house09, "house09.png"));
        house.add(Phrase.image(R.string.house10, "house10.png"));
        house.add(Phrase.image(R.string.house11, "house11.png"));
        house.add(Phrase.image(R.string.house12, "house12.png"));
        house.add(Phrase.image(R.string.house13, "house13.png"));
        house.add(Phrase.image(R.string.house14, "house14.png"));
        house.add(Phrase.image(R.string.house15, "house15.png"));
        house.add(Phrase.image(R.string.house16, "house16.png"));
        house.add(Phrase.image(R.string.house17, "house17.png"));
        house.add(Phrase.image(R.string.house18, "house18.png"));
        house.add(Phrase.image(R.string.house19, "house19.png"));
        house.add(Phrase.image(R.string.house20, "house20.png"));
        house.add(Phrase.image(R.string.house21, "house21.png"));
        house.add(Phrase.image(R.string.house22, "house22.png"));
        house.add(Phrase.image(R.string.house23, "house23.png"));
        house.add(Phrase.image(R.string.house24, "house24.png"));
        house.add(Phrase.image(R.string.house25, "house25.png"));
        house.add(Phrase.image(R.string.house26, "house26.png"));
        house.add(Phrase.image(R.string.house27, "house27.png"));
        house.add(Phrase.image(R.string.house28, "house28.png"));
        house.add(Phrase.image(R.string.house29, "house29.png"));
        house.add(Phrase.image(R.string.house30, "house30.png"));
        house.add(Phrase.image(R.string.house31, "house31.png"));
        house.add(Phrase.image(R.string.house32, "house32.png"));
        house.add(Phrase.image(R.string.house33, "house33.png"));
        house.add(Phrase.image(R.string.house34, "house34.png"));
        house.add(Phrase.image(R.string.house35, "house35.png"));
        house.add(Phrase.image(R.string.house36, "house36.png"));
        house.add(Phrase.image(R.string.house37, "house37.png"));
        house.add(Phrase.image(R.string.house38, "house38.png"));
        house.add(Phrase.image(R.string.house39, "house39.png"));
        house.add(Phrase.image(R.string.house40, "house40.png"));
        house.add(Phrase.image(R.string.house41, "house41.png"));
        house.add(Phrase.image(R.string.house42, "house42.png"));
        house.add(Phrase.image(R.string.house43, "house43.png"));
        house.add(Phrase.image(R.string.house44, "house44.png"));
        house.add(Phrase.image(R.string.house45, "house45.png"));
        house.add(Phrase.image(R.string.house46, "house46.png"));
        house.add(Phrase.image(R.string.house47, "house47.png"));
        return house;
    }

    private static List<Phrase> buildObjects() {
        ArrayList<Phrase> objects = new ArrayList<>();
        objects.add(Phrase.image(R.string.objects01, "objects01.png"));
        objects.add(Phrase.image(R.string.objects02, "objects02.png"));
        objects.add(Phrase.image(R.string.objects03, "objects03.png"));
        objects.add(Phrase.image(R.string.objects04, "objects04.png"));
        objects.add(Phrase.image(R.string.objects05, "objects05.png"));
        objects.add(Phrase.image(R.string.objects06, "objects06.png"));
        objects.add(Phrase.image(R.string.objects07, "objects07.png"));
        objects.add(Phrase.image(R.string.objects08, "objects08.png"));
        objects.add(Phrase.image(R.string.objects09, "objects09.png"));
        objects.add(Phrase.image(R.string.objects10, "objects10.png"));
        objects.add(Phrase.image(R.string.objects11, "objects11.png"));
        objects.add(Phrase.image(R.string.objects12, "objects12.png"));
        objects.add(Phrase.image(R.string.objects13, "objects13.png"));
        objects.add(Phrase.image(R.string.objects14, "objects14.png"));
        objects.add(Phrase.image(R.string.objects15, "objects15.png"));
        objects.add(Phrase.image(R.string.objects16, "objects16.png"));
        objects.add(Phrase.image(R.string.objects17, "objects17.png"));
        objects.add(Phrase.image(R.string.objects18, "objects18.png"));
        return objects;
    }

    private static List<Phrase> buildToys() {
        ArrayList<Phrase> toys = new ArrayList<>();
        toys.add(Phrase.image(R.string.toys01, "toys01.png"));
        toys.add(Phrase.image(R.string.toys02, "toys02.png"));
        toys.add(Phrase.image(R.string.toys03, "toys03.png"));
        toys.add(Phrase.image(R.string.toys04, "toys04.png"));
        toys.add(Phrase.image(R.string.toys05, "toys05.png"));
        toys.add(Phrase.image(R.string.toys06, "toys06.png"));
        toys.add(Phrase.image(R.string.toys07, "toys07.png"));
        toys.add(Phrase.image(R.string.toys08, "toys08.png"));
        toys.add(Phrase.image(R.string.toys09, "toys09.png"));
        toys.add(Phrase.image(R.string.toys10, "toys10.png"));
        toys.add(Phrase.image(R.string.toys11, "toys11.png"));
        toys.add(Phrase.image(R.string.toys12, "toys12.png"));
        toys.add(Phrase.image(R.string.toys13, "toys13.png"));
        toys.add(Phrase.image(R.string.toys14, "toys14.png"));
        toys.add(Phrase.image(R.string.toys15, "toys15.png"));
        toys.add(Phrase.image(R.string.toys16, "toys16.png"));
        toys.add(Phrase.image(R.string.toys17, "toys17.png"));
        return toys;
    }

    private static List<Phrase> buildMusicinst() {
        ArrayList<Phrase> musicinst = new ArrayList<>();
        musicinst.add(Phrase.image(R.string.musicinst01, "musicinst01.png"));
        musicinst.add(Phrase.image(R.string.musicinst02, "musicinst02.png"));
        musicinst.add(Phrase.image(R.string.musicinst03, "musicinst03.png"));
        musicinst.add(Phrase.image(R.string.musicinst04, "musicinst04.png"));
        musicinst.add(Phrase.image(R.string.musicinst05, "musicinst05.png"));
        musicinst.add(Phrase.image(R.string.musicinst06, "musicinst06.png"));
        musicinst.add(Phrase.image(R.string.musicinst07, "musicinst07.png"));
        musicinst.add(Phrase.image(R.string.musicinst08, "musicinst08.png"));
        musicinst.add(Phrase.image(R.string.musicinst09, "musicinst09.png"));
        musicinst.add(Phrase.image(R.string.musicinst10, "musicinst10.png"));
        musicinst.add(Phrase.image(R.string.musicinst11, "musicinst11.png"));
        musicinst.add(Phrase.image(R.string.musicinst12, "musicinst12.png"));
        musicinst.add(Phrase.image(R.string.musicinst13, "musicinst13.png"));
        musicinst.add(Phrase.image(R.string.musicinst14, "musicinst14.png"));
        musicinst.add(Phrase.image(R.string.musicinst15, "musicinst15.png"));
        musicinst.add(Phrase.image(R.string.musicinst16, "musicinst16.png"));
        musicinst.add(Phrase.image(R.string.musicinst17, "musicinst17.png"));
        return musicinst;
    }

    private static List<Phrase> buildTransport() {
        ArrayList<Phrase> transport = new ArrayList<>();
        transport.add(Phrase.image(R.string.transport01, "transport01.png"));
        transport.add(Phrase.image(R.string.transport02, "transport02.png"));
        transport.add(Phrase.image(R.string.transport03, "transport03.png"));
        transport.add(Phrase.image(R.string.transport04, "transport04.png"));
        transport.add(Phrase.image(R.string.transport05, "transport05.png"));
        transport.add(Phrase.image(R.string.transport06, "transport06.png"));
        transport.add(Phrase.image(R.string.transport07, "transport07.png"));
        transport.add(Phrase.image(R.string.transport08, "transport08.png"));
        transport.add(Phrase.image(R.string.transport09, "transport09.png"));
        transport.add(Phrase.image(R.string.transport10, "transport10.png"));
        transport.add(Phrase.image(R.string.transport11, "transport11.png"));
        transport.add(Phrase.image(R.string.transport12, "transport12.png"));
        return transport;
    }

    private static List<Phrase> buildSport() {
        ArrayList<Phrase> sport = new ArrayList<>();
        sport.add(Phrase.image(R.string.sport01, "sport01.gif"));
        sport.add(Phrase.image(R.string.sport02, "sport02.png"));
        sport.add(Phrase.image(R.string.sport03, "sport03.png"));
        sport.add(Phrase.image(R.string.sport04, "sport04.png"));
        sport.add(Phrase.image(R.string.sport05, "sport05.png"));
        sport.add(Phrase.image(R.string.sport06, "sport06.png"));
        sport.add(Phrase.image(R.string.sport07, "sport07.png"));
        sport.add(Phrase.image(R.string.sport08, "sport08.png"));
        sport.add(Phrase.image(R.string.sport09, "sport09.png"));
        sport.add(Phrase.image(R.string.sport10, "sport10.png"));
        sport.add(Phrase.image(R.string.sport11, "sport11.png"));
        sport.add(Phrase.image(R.string.sport12, "sport12.png"));
        sport.add(Phrase.image(R.string.sport13, "sport13.png"));
        sport.add(Phrase.image(R.string.sport14, "sport14.png"));
        sport.add(Phrase.image(R.string.sport15, "sport15.png"));
        sport.add(Phrase.image(R.string.sport16, "sport16.png"));
        sport.add(Phrase.image(R.string.sport17, "sport17.png"));
        sport.add(Phrase.image(R.string.sport18, "sport18.png"));
        sport.add(Phrase.image(R.string.sport19, "sport19.png"));
        sport.add(Phrase.image(R.string.sport20, "sport20.png"));
        sport.add(Phrase.image(R.string.sport21, "sport21.png"));
        sport.add(Phrase.image(R.string.sport22, "sport22.png"));
        sport.add(Phrase.image(R.string.sport23, "sport23.png"));
        sport.add(Phrase.image(R.string.sport24, "sport24.png"));
        sport.add(Phrase.image(R.string.sport25, "sport25.png"));
        sport.add(Phrase.image(R.string.sport26, "sport26.png"));
        sport.add(Phrase.image(R.string.sport27, "sport27.png"));
        sport.add(Phrase.image(R.string.sport28, "sport28.png"));
        return sport;
    }

    private static List<Phrase> buildCity() {
        ArrayList<Phrase> city = new ArrayList<>();
        city.add(Phrase.image(R.string.city01, "city01.png"));
        city.add(Phrase.image(R.string.city02, "city02.png"));
        city.add(Phrase.image(R.string.city03, "city03.png"));
        city.add(Phrase.image(R.string.city04, "city04.png"));
        city.add(Phrase.image(R.string.city05, "city05.png"));
        city.add(Phrase.image(R.string.city06, "city06.png"));
        city.add(Phrase.image(R.string.city07, "city07.png"));
        city.add(Phrase.image(R.string.city08, "city08.png"));
        city.add(Phrase.image(R.string.city09, "city09.png"));
        city.add(Phrase.image(R.string.city10, "city10.png"));
        city.add(Phrase.image(R.string.city11, "city11.png"));
        city.add(Phrase.image(R.string.city12, "city12.png"));
        city.add(Phrase.image(R.string.city13, "city13.png"));
        city.add(Phrase.image(R.string.city14, "city14.png"));
        city.add(Phrase.image(R.string.city15, "city15.png"));
        city.add(Phrase.image(R.string.city16, "city16.png"));
        city.add(Phrase.image(R.string.city17, "city17.png"));
        city.add(Phrase.image(R.string.city18, "city18.png"));
        city.add(Phrase.image(R.string.city19, "city19.png"));
        city.add(Phrase.image(R.string.city20, "city20.png"));
        city.add(Phrase.image(R.string.city21, "city21.png"));
        city.add(Phrase.image(R.string.city22, "city22.png"));
        city.add(Phrase.image(R.string.city23, "city23.png"));
        city.add(Phrase.image(R.string.city24, "city24.png"));
        city.add(Phrase.image(R.string.city25, "city25.png"));
        city.add(Phrase.image(R.string.city26, "city26.png"));
        city.add(Phrase.image(R.string.city27, "city27.png"));
        city.add(Phrase.image(R.string.city28, "city28.png"));
        city.add(Phrase.image(R.string.city29, "city29.png"));
        city.add(Phrase.image(R.string.city30, "city30.png"));
        city.add(Phrase.image(R.string.city31, "city31.png"));
        city.add(Phrase.image(R.string.city32, "city32.png"));
        city.add(Phrase.image(R.string.city33, "city33.png"));
        city.add(Phrase.image(R.string.city34, "city34.png"));
        city.add(Phrase.image(R.string.city35, "city35.png"));
        city.add(Phrase.image(R.string.city36, "city36.png"));
        city.add(Phrase.image(R.string.city37, "city37.png"));
        city.add(Phrase.image(R.string.city38, "city38.png"));
        city.add(Phrase.image(R.string.city39, "city39.png"));
        city.add(Phrase.image(R.string.city40, "city40.png"));
        city.add(Phrase.image(R.string.city41, "city41.png"));
        city.add(Phrase.image(R.string.city42, "city42.png"));
        city.add(Phrase.image(R.string.city43, "city43.png"));
        city.add(Phrase.image(R.string.city44, "city44.png"));
        city.add(Phrase.image(R.string.city45, "city45.png"));
        return city;
    }

    private static List<Phrase> buildArt() {
        ArrayList<Phrase> art = new ArrayList<>();
        art.add(Phrase.image(R.string.art01, "art01.png"));
        art.add(Phrase.image(R.string.art02, "art02.png"));
        art.add(Phrase.image(R.string.art03, "art03.png"));
        art.add(Phrase.image(R.string.art04, "art04.png"));
        art.add(Phrase.image(R.string.art05, "art05.png"));
        art.add(Phrase.image(R.string.art06, "art06.png"));
        art.add(Phrase.image(R.string.art07, "art07.png"));
        art.add(Phrase.image(R.string.art08, "art08.png"));
        art.add(Phrase.image(R.string.art09, "art09.png"));
        art.add(Phrase.image(R.string.art10, "art10.png"));
        art.add(Phrase.image(R.string.art11, "art11.png"));
        art.add(Phrase.image(R.string.art12, "art12.png"));
        art.add(Phrase.image(R.string.art13, "art13.png"));
        art.add(Phrase.image(R.string.art14, "art14.png"));
        art.add(Phrase.image(R.string.art15, "art15.png"));
        art.add(Phrase.image(R.string.art16, "art16.png"));
        art.add(Phrase.image(R.string.art17, "art17.png"));
        art.add(Phrase.image(R.string.art18, "art18.png"));
        art.add(Phrase.image(R.string.art19, "art19.png"));
        art.add(Phrase.image(R.string.art20, "art20.png"));
        art.add(Phrase.image(R.string.art21, "art21.png"));
        art.add(Phrase.image(R.string.art22, "art22.png"));
        art.add(Phrase.image(R.string.art23, "art23.png"));
        art.add(Phrase.image(R.string.art24, "art24.png"));
        art.add(Phrase.image(R.string.art25, "art25.png"));
        art.add(Phrase.image(R.string.art26, "art26.png"));
        art.add(Phrase.image(R.string.art27, "art27.png"));
        art.add(Phrase.image(R.string.art28, "art28.png"));
        art.add(Phrase.image(R.string.art29, "art29.png"));
        art.add(Phrase.image(R.string.art30, "art30.png"));
        return art;
    }

    private static List<Phrase> buildSchool() {
        ArrayList<Phrase> school = new ArrayList<>();
        school.add(Phrase.image(R.string.school01, "school01.png"));
        school.add(Phrase.image(R.string.school02, "school02.png"));
        school.add(Phrase.image(R.string.school03, "school03.png"));
        school.add(Phrase.image(R.string.school04, "school04.png"));
        school.add(Phrase.image(R.string.school05, "school05.png"));
        school.add(Phrase.image(R.string.school06, "school06.png"));
        school.add(Phrase.image(R.string.school07, "school07.png"));
        school.add(Phrase.image(R.string.school08, "school08.png"));
        school.add(Phrase.image(R.string.school09, "school09.png"));
        school.add(Phrase.image(R.string.school10, "school10.png"));
        school.add(Phrase.image(R.string.school11, "school11.png"));
        school.add(Phrase.image(R.string.school12, "school12.png"));
        school.add(Phrase.image(R.string.school13, "school13.png"));
        school.add(Phrase.image(R.string.school14, "school14.png"));
        school.add(Phrase.image(R.string.school15, "school15.png"));
        school.add(Phrase.image(R.string.school16, "school16.png"));
        school.add(Phrase.image(R.string.school17, "school17.png"));
        return school;
    }

    private static List<Phrase> buildNature() {
        ArrayList<Phrase> nature = new ArrayList<>();
        nature.add(Phrase.image(R.string.nature01, "nature01.png"));
        nature.add(Phrase.image(R.string.nature02, "nature02.png"));
        nature.add(Phrase.image(R.string.nature03, "nature03.gif"));
        nature.add(Phrase.image(R.string.nature04, "nature04.png"));
        nature.add(Phrase.image(R.string.nature05, "nature05.png"));
        nature.add(Phrase.image(R.string.nature06, "nature06.png"));
        nature.add(Phrase.image(R.string.nature07, "nature07.png"));
        nature.add(Phrase.image(R.string.nature08, "nature08.png"));
        nature.add(Phrase.image(R.string.nature09, "nature09.png"));
        nature.add(Phrase.image(R.string.nature10, "nature10.png"));
        nature.add(Phrase.image(R.string.nature11, "nature11.png"));
        nature.add(Phrase.image(R.string.nature12, "nature12.gif"));
        nature.add(Phrase.image(R.string.nature13, "nature13.png"));
        nature.add(Phrase.image(R.string.nature14, "nature14.png"));
        nature.add(Phrase.image(R.string.nature15, "nature15.png"));
        nature.add(Phrase.image(R.string.nature16, "nature16.png"));
        nature.add(Phrase.image(R.string.nature17, "nature17.png"));
        nature.add(Phrase.image(R.string.nature18, "nature18.png"));
        nature.add(Phrase.image(R.string.nature19, "nature19.png"));
        nature.add(Phrase.image(R.string.nature20, "nature20.png"));
        nature.add(Phrase.image(R.string.nature21, "nature21.png"));
        nature.add(Phrase.image(R.string.nature22, "nature22.png"));
        nature.add(Phrase.image(R.string.nature23, "nature23.png"));
        nature.add(Phrase.image(R.string.nature24, "nature24.png"));
        nature.add(Phrase.image(R.string.nature25, "nature25.png"));
        nature.add(Phrase.image(R.string.nature26, "nature26.png"));
        nature.add(Phrase.image(R.string.nature27, "nature27.png"));
        nature.add(Phrase.image(R.string.nature28, "nature28.png"));
        nature.add(Phrase.image(R.string.nature29, "nature29.png"));
        return nature;
    }

    private static List<Phrase> buildProf() {
        ArrayList<Phrase> prof = new ArrayList<>();
        prof.add(Phrase.image(R.string.prof01, "prof01.png"));
        prof.add(Phrase.image(R.string.prof02, "prof02.png"));
        prof.add(Phrase.image(R.string.prof03, "prof03.png"));
        prof.add(Phrase.image(R.string.prof04, "prof04.png"));
        prof.add(Phrase.image(R.string.prof05, "prof05.png"));
        prof.add(Phrase.image(R.string.prof06, "prof06.png"));
        prof.add(Phrase.image(R.string.prof07, "prof07.png"));
        prof.add(Phrase.image(R.string.prof08, "prof08.png"));
        prof.add(Phrase.image(R.string.prof09, "prof09.png"));
        prof.add(Phrase.image(R.string.prof10, "prof10.png"));
        prof.add(Phrase.image(R.string.prof11, "prof11.png"));
        prof.add(Phrase.image(R.string.prof12, "prof12.png"));
        prof.add(Phrase.image(R.string.prof13, "prof13.png"));
        prof.add(Phrase.image(R.string.prof14, "prof14.png"));
        prof.add(Phrase.image(R.string.prof15, "prof15.png"));
        prof.add(Phrase.image(R.string.prof16, "prof16.png"));
        prof.add(Phrase.image(R.string.prof17, "prof17.png"));
        prof.add(Phrase.image(R.string.prof18, "prof18.png"));
        prof.add(Phrase.image(R.string.prof19, "prof19.png"));
        prof.add(Phrase.image(R.string.prof20, "prof20.png"));
        prof.add(Phrase.image(R.string.prof21, "prof21.png"));
        prof.add(Phrase.image(R.string.prof22, "prof22.png"));
        prof.add(Phrase.image(R.string.prof23, "prof23.png"));
        prof.add(Phrase.image(R.string.prof24, "prof24.png"));
        prof.add(Phrase.image(R.string.prof25, "prof25.png"));
        prof.add(Phrase.image(R.string.prof26, "prof26.png"));
        prof.add(Phrase.image(R.string.prof27, "prof27.png"));
        prof.add(Phrase.image(R.string.prof28, "prof28.png"));
        prof.add(Phrase.image(R.string.prof29, "prof29.png"));
        prof.add(Phrase.image(R.string.prof30, "prof30.png"));
        return prof;
    }

    private static List<Phrase> buildVerbs() {
        ArrayList<Phrase> verbs = new ArrayList<>();
        verbs.add(Phrase.image(R.string.verbs01, "verbs01.png"));
        verbs.add(Phrase.image(R.string.verbs02, "verbs02.png"));
        verbs.add(Phrase.image(R.string.verbs03, "verbs03.gif"));
        verbs.add(Phrase.image(R.string.verbs04, "verbs04.png"));
        verbs.add(Phrase.image(R.string.verbs05, "verbs05.png"));
        verbs.add(Phrase.image(R.string.verbs06, "verbs06.png"));
        verbs.add(Phrase.image(R.string.verbs07, "verbs07.png"));
        verbs.add(Phrase.image(R.string.verbs08, "verbs08.png"));
        verbs.add(Phrase.image(R.string.verbs09, "verbs09.png"));
        verbs.add(Phrase.image(R.string.verbs10, "verbs10.png"));
        verbs.add(Phrase.image(R.string.verbs11, "verbs11.png"));
        verbs.add(Phrase.image(R.string.verbs12, "verbs12.png"));
        verbs.add(Phrase.image(R.string.verbs13, "verbs13.png"));
        verbs.add(Phrase.image(R.string.verbs14, "verbs14.png"));
        verbs.add(Phrase.image(R.string.verbs15, "verbs15.png"));
        verbs.add(Phrase.image(R.string.verbs16, "verbs16.png"));
        verbs.add(Phrase.image(R.string.verbs17, "verbs17.png"));
        verbs.add(Phrase.image(R.string.verbs18, "verbs18.png"));
        verbs.add(Phrase.image(R.string.verbs19, "verbs19.png"));
        verbs.add(Phrase.image(R.string.verbs20, "verbs20.png"));
        verbs.add(Phrase.image(R.string.verbs21, "verbs21.png"));
        verbs.add(Phrase.image(R.string.verbs22, "verbs22.png"));
        verbs.add(Phrase.image(R.string.verbs23, "verbs23.png"));
        verbs.add(Phrase.image(R.string.verbs24, "verbs24.png"));
        verbs.add(Phrase.image(R.string.verbs25, "verbs25.png"));
        verbs.add(Phrase.image(R.string.verbs26, "verbs26.png"));
        verbs.add(Phrase.image(R.string.verbs27, "verbs27.png"));
        verbs.add(Phrase.image(R.string.verbs28, "verbs28.png"));
        verbs.add(Phrase.image(R.string.verbs29, "verbs29.png"));
        verbs.add(Phrase.image(R.string.verbs30, "verbs30.png"));
        verbs.add(Phrase.image(R.string.verbs31, "verbs31.png"));
        verbs.add(Phrase.image(R.string.verbs32, "verbs32.png"));
        verbs.add(Phrase.image(R.string.verbs33, "verbs33.png"));
        verbs.add(Phrase.image(R.string.verbs34, "verbs34.png"));
        verbs.add(Phrase.image(R.string.verbs35, "verbs35.png"));
        verbs.add(Phrase.image(R.string.verbs36, "verbs36.png"));
        verbs.add(Phrase.image(R.string.verbs37, "verbs37.png"));
        verbs.add(Phrase.image(R.string.verbs38, "verbs38.png"));
        return verbs;
    }

    private static List<Phrase> buildAdjectives() {
        ArrayList<Phrase> adjectives = new ArrayList<>();
        adjectives.add(Phrase.image(R.string.adjectives01, "adjectives01.png"));
        adjectives.add(Phrase.image(R.string.adjectives02, "adjectives02.png"));
        adjectives.add(Phrase.image(R.string.adjectives03, "adjectives03.png"));
        adjectives.add(Phrase.image(R.string.adjectives04, "adjectives04.png"));
        adjectives.add(Phrase.image(R.string.adjectives05, "adjectives05.png"));
        adjectives.add(Phrase.image(R.string.adjectives06, "adjectives06.png"));
        adjectives.add(Phrase.image(R.string.adjectives07, "adjectives07.png"));
        adjectives.add(Phrase.image(R.string.adjectives08, "adjectives08.png"));
        adjectives.add(Phrase.image(R.string.adjectives09, "adjectives09.png"));
        adjectives.add(Phrase.image(R.string.adjectives10, "adjectives10.png"));
        adjectives.add(Phrase.image(R.string.adjectives11, "adjectives11.png"));
        adjectives.add(Phrase.image(R.string.adjectives12, "adjectives12.png"));
        adjectives.add(Phrase.image(R.string.adjectives13, "adjectives13.png"));
        adjectives.add(Phrase.image(R.string.adjectives14, "adjectives14.png"));
        adjectives.add(Phrase.image(R.string.adjectives15, "adjectives15.png"));
        adjectives.add(Phrase.image(R.string.adjectives16, "adjectives16.png"));
        adjectives.add(Phrase.image(R.string.adjectives17, "adjectives17.png"));
        adjectives.add(Phrase.image(R.string.adjectives18, "adjectives18.png"));
        adjectives.add(Phrase.image(R.string.adjectives19, "adjectives19.png"));
        adjectives.add(Phrase.image(R.string.adjectives20, "adjectives20.png"));
        adjectives.add(Phrase.image(R.string.adjectives21, "adjectives21.png"));
        adjectives.add(Phrase.image(R.string.adjectives22, "adjectives22.png"));
        adjectives.add(Phrase.image(R.string.adjectives23, "adjectives23.png"));
        adjectives.add(Phrase.image(R.string.adjectives24, "adjectives24.png"));
        adjectives.add(Phrase.image(R.string.adjectives25, "adjectives25.png"));
        adjectives.add(Phrase.image(R.string.adjectives26, "adjectives26.png"));
        adjectives.add(Phrase.image(R.string.adjectives27, "adjectives27.png"));
        adjectives.add(Phrase.image(R.string.adjectives28, "adjectives28.png"));
        adjectives.add(Phrase.image(R.string.adjectives29, "adjectives29.png"));
        adjectives.add(Phrase.image(R.string.adjectives30, "adjectives30.png"));
        adjectives.add(Phrase.image(R.string.adjectives31, "adjectives31.png"));
        adjectives.add(Phrase.image(R.string.adjectives32, "adjectives32.png"));
        return adjectives;
    }

    private static List<Phrase> buildPhrases() {
        ArrayList<Phrase> phrases = new ArrayList<>();
        phrases.add(Phrase.image(R.string.phrases01, "phrases01.gif"));
        phrases.add(Phrase.image(R.string.phrases02, "phrases02.gif"));
        phrases.add(Phrase.image(R.string.phrases03, "phrases03.png"));
        phrases.add(Phrase.image(R.string.phrases04, "phrases04.png"));
        phrases.add(Phrase.image(R.string.phrases05, "phrases05.png"));
        phrases.add(Phrase.image(R.string.phrases06, "phrases06.gif"));
        phrases.add(Phrase.image(R.string.phrases07, "phrases07.png"));
        phrases.add(Phrase.image(R.string.phrases08, "phrases08.png"));
        phrases.add(Phrase.image(R.string.phrases09, "phrases09.png"));
        phrases.add(Phrase.image(R.string.phrases10, "phrases10.png"));
        phrases.add(Phrase.image(R.string.phrases11, "phrases11.png"));
        phrases.add(Phrase.image(R.string.phrases12, "phrases12.png"));
        phrases.add(Phrase.image(R.string.phrases13, "phrases13.png"));
        phrases.add(Phrase.image(R.string.phrases14, "phrases14.gif"));
        phrases.add(Phrase.image(R.string.phrases15, "phrases14.gif"));
        phrases.add(Phrase.image(R.string.phrases16, "phrases14.gif"));
        phrases.add(Phrase.image(R.string.phrases17, "phrases17.png"));
        phrases.add(Phrase.image(R.string.phrases18, "phrases18.png"));
        phrases.add(Phrase.image(R.string.phrases19, "phrases19.png"));
        phrases.add(Phrase.image(R.string.phrases20, "phrases20.png"));
        phrases.add(Phrase.image(R.string.phrases21, "phrases21.png"));
        phrases.add(Phrase.image(R.string.phrases22, "phrases22.png"));
        phrases.add(Phrase.image(R.string.phrases23, "phrases23.png"));
        return phrases;
    }

    private static List<Phrase> buildPretext() {
        ArrayList<Phrase> pretext = new ArrayList<>();
        pretext.add(Phrase.image(R.string.pretext01, "pretext01.png"));
        pretext.add(Phrase.image(R.string.pretext02, "pretext02.png"));
        pretext.add(Phrase.image(R.string.pretext03, "pretext03.png"));
        pretext.add(Phrase.image(R.string.pretext04, "pretext04.png"));
        pretext.add(Phrase.image(R.string.pretext05, "pretext05.png"));
        pretext.add(Phrase.image(R.string.pretext06, "pretext06.png"));
        pretext.add(Phrase.image(R.string.pretext07, "pretext07.png"));
        pretext.add(Phrase.image(R.string.pretext08, "pretext08.png"));
        pretext.add(Phrase.image(R.string.pretext09, "pretext09.png"));
        pretext.add(Phrase.image(R.string.pretext10, "pretext10.png"));
        pretext.add(Phrase.image(R.string.pretext11, "pretext11.png"));
        pretext.add(Phrase.image(R.string.pretext12, "pretext12.png"));
        pretext.add(Phrase.image(R.string.pretext13, "pretext13.png"));
        pretext.add(Phrase.image(R.string.pretext14, "pretext14.png"));
        pretext.add(Phrase.image(R.string.pretext15, "pretext15.png"));
        pretext.add(Phrase.image(R.string.pretext16, "pretext16.png"));
        pretext.add(Phrase.image(R.string.pretext17, "pretext17.png"));
        pretext.add(Phrase.image(R.string.pretext18, "pretext18.png"));
        pretext.add(Phrase.image(R.string.pretext19, "pretext19.png"));
        pretext.add(Phrase.image(R.string.pretext20, "pretext20.png"));
        return pretext;
    }

    private static List<Phrase> buildGeo() {
        ArrayList<Phrase> geo = new ArrayList<>();
        geo.add(Phrase.image(R.string.geo01, "🇦🇨"));
        geo.add(Phrase.image(R.string.geo02, "🇦🇩"));
        geo.add(Phrase.image(R.string.geo03, "🇦🇪"));
        geo.add(Phrase.image(R.string.geo04, "🇦🇫"));
        geo.add(Phrase.image(R.string.geo05, "🇦🇬"));
        geo.add(Phrase.image(R.string.geo06, "🇦🇮"));
        geo.add(Phrase.image(R.string.geo07, "🇦🇱"));
        geo.add(Phrase.image(R.string.geo08, "🇦🇲"));
        geo.add(Phrase.image(R.string.geo09, "🇦🇴"));
        geo.add(Phrase.image(R.string.geo10, "🇦🇶"));
        geo.add(Phrase.image(R.string.geo11, "🇦🇷"));
        geo.add(Phrase.image(R.string.geo12, "🇦🇸"));
        geo.add(Phrase.image(R.string.geo13, "🇦🇹"));
        geo.add(Phrase.image(R.string.geo14, "🇦🇺"));
        geo.add(Phrase.image(R.string.geo15, "🇦🇼"));
        geo.add(Phrase.image(R.string.geo16, "🇦🇽"));
        geo.add(Phrase.image(R.string.geo17, "🇦🇿"));
        geo.add(Phrase.image(R.string.geo18, "🇧🇦"));
        geo.add(Phrase.image(R.string.geo19, "🇧🇧"));
        geo.add(Phrase.image(R.string.geo20, "🇧🇩"));
        geo.add(Phrase.image(R.string.geo21, "🇧🇪"));
        geo.add(Phrase.image(R.string.geo22, "🇧🇫"));
        geo.add(Phrase.image(R.string.geo23, "🇧🇬"));
        geo.add(Phrase.image(R.string.geo24, "🇧🇭"));
        geo.add(Phrase.image(R.string.geo25, "🇧🇮"));
        geo.add(Phrase.image(R.string.geo26, "🇧🇯"));
        geo.add(Phrase.image(R.string.geo27, "🇧🇱"));
        geo.add(Phrase.image(R.string.geo28, "🇧🇲"));
        geo.add(Phrase.image(R.string.geo29, "🇧🇳"));
        geo.add(Phrase.image(R.string.geo30, "🇧🇴"));
        geo.add(Phrase.image(R.string.geo31, "🇧🇶"));
        geo.add(Phrase.image(R.string.geo32, "🇧🇷"));
        geo.add(Phrase.image(R.string.geo33, "🇧🇸"));
        geo.add(Phrase.image(R.string.geo34, "🇧🇹"));
        geo.add(Phrase.image(R.string.geo35, "🇧🇻"));
        geo.add(Phrase.image(R.string.geo36, "🇧🇼"));
        geo.add(Phrase.image(R.string.geo37, "🇧🇾"));
        geo.add(Phrase.image(R.string.geo38, "🇧🇿"));
        geo.add(Phrase.image(R.string.geo39, "🇨🇦"));
        geo.add(Phrase.image(R.string.geo40, "🇨🇨"));
        geo.add(Phrase.image(R.string.geo41, "🇨🇩"));
        geo.add(Phrase.image(R.string.geo42, "🇨🇫"));
        geo.add(Phrase.image(R.string.geo43, "🇨🇬"));
        geo.add(Phrase.image(R.string.geo44, "🇨🇭"));
        geo.add(Phrase.image(R.string.geo45, "🇨🇮"));
        geo.add(Phrase.image(R.string.geo46, "🇨🇰"));
        geo.add(Phrase.image(R.string.geo47, "🇨🇱"));
        geo.add(Phrase.image(R.string.geo48, "🇨🇲"));
        geo.add(Phrase.image(R.string.geo49, "🇨🇳"));
        geo.add(Phrase.image(R.string.geo50, "🇨🇴"));
        geo.add(Phrase.image(R.string.geo51, "🇨🇵"));
        geo.add(Phrase.image(R.string.geo52, "🇨🇷"));
        geo.add(Phrase.image(R.string.geo53, "🇨🇺"));
        geo.add(Phrase.image(R.string.geo54, "🇨🇻"));
        geo.add(Phrase.image(R.string.geo55, "🇨🇼"));
        geo.add(Phrase.image(R.string.geo56, "🇨🇽"));
        geo.add(Phrase.image(R.string.geo57, "🇨🇾"));
        geo.add(Phrase.image(R.string.geo58, "🇨🇿"));
        geo.add(Phrase.image(R.string.geo59, "🇩🇪"));
        geo.add(Phrase.image(R.string.geo60, "🇩🇬"));
        geo.add(Phrase.image(R.string.geo61, "🇩🇯"));
        geo.add(Phrase.image(R.string.geo62, "🇩🇰"));
        geo.add(Phrase.image(R.string.geo63, "🇩🇲"));
        geo.add(Phrase.image(R.string.geo64, "🇩🇴"));
        geo.add(Phrase.image(R.string.geo65, "🇩🇿"));
        geo.add(Phrase.image(R.string.geo66, "🇪🇦"));
        geo.add(Phrase.image(R.string.geo67, "🇪🇨"));
        geo.add(Phrase.image(R.string.geo68, "🇪🇪"));
        geo.add(Phrase.image(R.string.geo69, "🇪🇬"));
        geo.add(Phrase.image(R.string.geo70, "🇪🇭"));
        geo.add(Phrase.image(R.string.geo71, "🇪🇷"));
        geo.add(Phrase.image(R.string.geo72, "🇪🇸"));
        geo.add(Phrase.image(R.string.geo73, "🇪🇹"));
        geo.add(Phrase.image(R.string.geo74, "🇪🇺"));
        geo.add(Phrase.image(R.string.geo75, "🇫🇮"));
        geo.add(Phrase.image(R.string.geo76, "🇫🇯"));
        geo.add(Phrase.image(R.string.geo77, "🇫🇰"));
        geo.add(Phrase.image(R.string.geo78, "🇫🇲"));
        geo.add(Phrase.image(R.string.geo79, "🇫🇴"));
        geo.add(Phrase.image(R.string.geo80, "🇫🇷"));
        geo.add(Phrase.image(R.string.geo81, "🇬🇦"));
        geo.add(Phrase.image(R.string.geo82, "🇬🇧"));
        geo.add(Phrase.image(R.string.geo83, "🇬🇩"));
        geo.add(Phrase.image(R.string.geo84, "🇬🇪"));
        geo.add(Phrase.image(R.string.geo85, "🇬🇫"));
        geo.add(Phrase.image(R.string.geo86, "🇬🇬"));
        geo.add(Phrase.image(R.string.geo87, "🇬🇭"));
        geo.add(Phrase.image(R.string.geo88, "🇬🇮"));
        geo.add(Phrase.image(R.string.geo89, "🇬🇱"));
        geo.add(Phrase.image(R.string.geo90, "🇬🇲"));
        geo.add(Phrase.image(R.string.geo91, "🇬🇳"));
        geo.add(Phrase.image(R.string.geo92, "🇬🇵"));
        geo.add(Phrase.image(R.string.geo93, "🇬🇶"));
        geo.add(Phrase.image(R.string.geo94, "🇬🇷"));
        geo.add(Phrase.image(R.string.geo95, "🇬🇸"));
        geo.add(Phrase.image(R.string.geo96, "🇬🇹"));
        geo.add(Phrase.image(R.string.geo97, "🇬🇺"));
        geo.add(Phrase.image(R.string.geo98, "🇬🇼"));
        geo.add(Phrase.image(R.string.geo99, "🇬🇾"));
        geo.add(Phrase.image(R.string.geo100, "🇭🇰"));
        geo.add(Phrase.image(R.string.geo101, "🇭🇲"));
        geo.add(Phrase.image(R.string.geo102, "🇭🇳"));
        geo.add(Phrase.image(R.string.geo103, "🇭🇷"));
        geo.add(Phrase.image(R.string.geo104, "🇭🇹"));
        geo.add(Phrase.image(R.string.geo105, "🇭🇺"));
        geo.add(Phrase.image(R.string.geo106, "🇮🇨"));
        geo.add(Phrase.image(R.string.geo107, "🇮🇩"));
        geo.add(Phrase.image(R.string.geo108, "🇪"));
        geo.add(Phrase.image(R.string.geo109, "🇮🇱"));
        geo.add(Phrase.image(R.string.geo110, "🇮🇲"));
        geo.add(Phrase.image(R.string.geo111, "🇮🇳"));
        geo.add(Phrase.image(R.string.geo112, "🇮🇴"));
        geo.add(Phrase.image(R.string.geo113, "🇮🇶"));
        geo.add(Phrase.image(R.string.geo114, "🇮🇷"));
        geo.add(Phrase.image(R.string.geo115, "🇮🇸"));
        geo.add(Phrase.image(R.string.geo116, "🇮🇹"));
        geo.add(Phrase.image(R.string.geo117, "🇯🇪"));
        geo.add(Phrase.image(R.string.geo118, "🇯🇲"));
        geo.add(Phrase.image(R.string.geo119, "🇯🇴"));
        geo.add(Phrase.image(R.string.geo120, "🇯🇵"));
        geo.add(Phrase.image(R.string.geo121, "🇰🇪"));
        geo.add(Phrase.image(R.string.geo122, "🇰🇬"));
        geo.add(Phrase.image(R.string.geo123, "🇰🇭"));
        geo.add(Phrase.image(R.string.geo124, "🇰🇮"));
        geo.add(Phrase.image(R.string.geo125, "🇰🇲"));
        geo.add(Phrase.image(R.string.geo126, "🇰🇳"));
        geo.add(Phrase.image(R.string.geo127, "🇰🇵"));
        geo.add(Phrase.image(R.string.geo128, "🇰🇷"));
        geo.add(Phrase.image(R.string.geo129, "🇰🇼"));
        geo.add(Phrase.image(R.string.geo130, "🇰🇾"));
        geo.add(Phrase.image(R.string.geo131, "🇰🇿"));
        geo.add(Phrase.image(R.string.geo132, "🇱🇦"));
        geo.add(Phrase.image(R.string.geo133, "🇱🇧"));
        geo.add(Phrase.image(R.string.geo134, "🇱🇨"));
        geo.add(Phrase.image(R.string.geo135, "🇱🇮"));
        geo.add(Phrase.image(R.string.geo136, "🇱🇰"));
        geo.add(Phrase.image(R.string.geo137, "🇱🇷"));
        geo.add(Phrase.image(R.string.geo138, "🇱🇸"));
        geo.add(Phrase.image(R.string.geo139, "🇱🇹"));
        geo.add(Phrase.image(R.string.geo140, "🇱🇺"));
        geo.add(Phrase.image(R.string.geo141, "🇱🇻"));
        geo.add(Phrase.image(R.string.geo142, "🇱🇾"));
        geo.add(Phrase.image(R.string.geo143, "🇲🇦"));
        geo.add(Phrase.image(R.string.geo144, "🇲🇨"));
        geo.add(Phrase.image(R.string.geo145, "🇲🇩"));
        geo.add(Phrase.image(R.string.geo146, "🇲🇪"));
        geo.add(Phrase.image(R.string.geo147, "🇲🇫"));
        geo.add(Phrase.image(R.string.geo148, "🇲🇬"));
        geo.add(Phrase.image(R.string.geo149, "🇲🇭"));
        geo.add(Phrase.image(R.string.geo150, "🇲🇰"));
        geo.add(Phrase.image(R.string.geo151, "🇲🇱"));
        geo.add(Phrase.image(R.string.geo152, "🇲🇲"));
        geo.add(Phrase.image(R.string.geo153, "🇲🇳"));
        geo.add(Phrase.image(R.string.geo154, "🇲🇴"));
        geo.add(Phrase.image(R.string.geo155, "🇲🇵"));
        geo.add(Phrase.image(R.string.geo156, "🇲🇶"));
        geo.add(Phrase.image(R.string.geo157, "🇲🇷"));
        geo.add(Phrase.image(R.string.geo158, "🇲🇸"));
        geo.add(Phrase.image(R.string.geo159, "🇲🇹"));
        geo.add(Phrase.image(R.string.geo160, "🇲🇺"));
        geo.add(Phrase.image(R.string.geo161, "🇲🇻"));
        geo.add(Phrase.image(R.string.geo162, "🇲🇼"));
        geo.add(Phrase.image(R.string.geo163, "🇲🇽"));
        geo.add(Phrase.image(R.string.geo164, "🇲🇾"));
        geo.add(Phrase.image(R.string.geo165, "🇲🇿"));
        geo.add(Phrase.image(R.string.geo166, "🇳🇦"));
        geo.add(Phrase.image(R.string.geo167, "🇳🇨"));
        geo.add(Phrase.image(R.string.geo168, "🇳🇪"));
        geo.add(Phrase.image(R.string.geo169, "🇳🇫"));
        geo.add(Phrase.image(R.string.geo170, "🇳🇬"));
        geo.add(Phrase.image(R.string.geo171, "🇳🇮"));
        geo.add(Phrase.image(R.string.geo172, "🇳🇱"));
        geo.add(Phrase.image(R.string.geo173, "🇳🇴"));
        geo.add(Phrase.image(R.string.geo174, "🇳🇵"));
        geo.add(Phrase.image(R.string.geo175, "🇳🇷"));
        geo.add(Phrase.image(R.string.geo176, "🇳🇺"));
        geo.add(Phrase.image(R.string.geo177, "🇳🇿"));
        geo.add(Phrase.image(R.string.geo178, "🇴🇲"));
        geo.add(Phrase.image(R.string.geo179, "🇵🇦"));
        geo.add(Phrase.image(R.string.geo180, "🇵🇪"));
        geo.add(Phrase.image(R.string.geo181, "🇵🇫"));
        geo.add(Phrase.image(R.string.geo182, "🇵🇬"));
        geo.add(Phrase.image(R.string.geo183, "🇵🇭"));
        geo.add(Phrase.image(R.string.geo184, "🇵🇰"));
        geo.add(Phrase.image(R.string.geo185, "🇵🇱"));
        geo.add(Phrase.image(R.string.geo186, "🇵🇲"));
        geo.add(Phrase.image(R.string.geo187, "🇵🇳"));
        geo.add(Phrase.image(R.string.geo188, "🇵🇷"));
        geo.add(Phrase.image(R.string.geo189, "🇵🇸"));
        geo.add(Phrase.image(R.string.geo190, "🇵🇹"));
        geo.add(Phrase.image(R.string.geo191, "🇵🇼"));
        geo.add(Phrase.image(R.string.geo192, "🇵🇾"));
        geo.add(Phrase.image(R.string.geo193, "🇶🇦"));
        geo.add(Phrase.image(R.string.geo194, "🇷🇪"));
        geo.add(Phrase.image(R.string.geo195, "🇷🇴"));
        geo.add(Phrase.image(R.string.geo196, "🇷🇸"));
        geo.add(Phrase.image(R.string.geo197, "🇷🇺"));
        geo.add(Phrase.image(R.string.geo198, "🇷🇼"));
        geo.add(Phrase.image(R.string.geo199, "🇸🇦"));
        geo.add(Phrase.image(R.string.geo200, "🇸🇧"));
        geo.add(Phrase.image(R.string.geo201, "🇸🇨"));
        geo.add(Phrase.image(R.string.geo202, "🇸🇩"));
        geo.add(Phrase.image(R.string.geo203, "🇸🇪"));
        geo.add(Phrase.image(R.string.geo204, "🇸🇬"));
        geo.add(Phrase.image(R.string.geo205, "🇸🇭"));
        geo.add(Phrase.image(R.string.geo206, "🇸🇮"));
        geo.add(Phrase.image(R.string.geo207, "🇸🇯"));
        geo.add(Phrase.image(R.string.geo208, "🇸🇰"));
        geo.add(Phrase.image(R.string.geo209, "🇸🇱"));
        geo.add(Phrase.image(R.string.geo210, "🇸🇲"));
        geo.add(Phrase.image(R.string.geo211, "🇸🇳"));
        geo.add(Phrase.image(R.string.geo212, "🇸🇴"));
        geo.add(Phrase.image(R.string.geo213, "🇸🇷"));
        geo.add(Phrase.image(R.string.geo214, "🇸🇸"));
        geo.add(Phrase.image(R.string.geo215, "🇸🇹"));
        geo.add(Phrase.image(R.string.geo216, "🇸🇻"));
        geo.add(Phrase.image(R.string.geo217, "🇸🇽"));
        geo.add(Phrase.image(R.string.geo218, "🇸🇾"));
        geo.add(Phrase.image(R.string.geo219, "🇸🇿"));
        geo.add(Phrase.image(R.string.geo220, "🇹🇦"));
        geo.add(Phrase.image(R.string.geo221, "🇹🇨"));
        geo.add(Phrase.image(R.string.geo222, "🇹🇩"));
        geo.add(Phrase.image(R.string.geo223, "🇹🇫"));
        geo.add(Phrase.image(R.string.geo224, "🇹🇬"));
        geo.add(Phrase.image(R.string.geo225, "🇹🇭"));
        geo.add(Phrase.image(R.string.geo226, "🇹🇯"));
        geo.add(Phrase.image(R.string.geo227, "🇹🇰"));
        geo.add(Phrase.image(R.string.geo228, "🇹🇱"));
        geo.add(Phrase.image(R.string.geo229, "🇹🇲"));
        geo.add(Phrase.image(R.string.geo230, "🇹🇳"));
        geo.add(Phrase.image(R.string.geo231, "🇹🇴"));
        geo.add(Phrase.image(R.string.geo232, "🇹🇷"));
        geo.add(Phrase.image(R.string.geo233, "🇹🇹"));
        geo.add(Phrase.image(R.string.geo234, "🇹🇻"));
        geo.add(Phrase.image(R.string.geo235, "🇹🇼"));
        geo.add(Phrase.image(R.string.geo236, "🇹🇿"));
        geo.add(Phrase.image(R.string.geo237, "🇺🇦"));
        geo.add(Phrase.image(R.string.geo238, "🇺🇬"));
        geo.add(Phrase.image(R.string.geo239, "🇺🇲"));
        geo.add(Phrase.image(R.string.geo240, "🇺🇳"));
        geo.add(Phrase.image(R.string.geo241, "🇺🇸"));
        geo.add(Phrase.image(R.string.geo242, "🇺🇾"));
        geo.add(Phrase.image(R.string.geo243, "🇺🇿"));
        geo.add(Phrase.image(R.string.geo244, "🇻🇦"));
        geo.add(Phrase.image(R.string.geo245, "🇻🇨"));
        geo.add(Phrase.image(R.string.geo246, "🇻🇪"));
        geo.add(Phrase.image(R.string.geo247, "🇻🇬"));
        geo.add(Phrase.image(R.string.geo248, "🇻🇮"));
        geo.add(Phrase.image(R.string.geo249, "🇻🇳"));
        geo.add(Phrase.image(R.string.geo250, "🇻🇺"));
        geo.add(Phrase.image(R.string.geo251, "🇼🇫"));
        geo.add(Phrase.image(R.string.geo252, "\uD83C\uDDFD\uD83C\uDDF0"));
        geo.add(Phrase.image(R.string.geo253, "🇽🇰"));
        geo.add(Phrase.image(R.string.geo254, "🇾🇪"));
        geo.add(Phrase.image(R.string.geo255, "🇾🇹"));
        geo.add(Phrase.image(R.string.geo256, "🇿🇦"));
        geo.add(Phrase.image(R.string.geo257, "🇿🇲"));
        geo.add(Phrase.image(R.string.geo258, "🇿🇼"));
        geo.add(Phrase.image(R.string.geo259, "\uD83C\uDF0F"));
        geo.add(Phrase.image(R.string.geo260, "\uD83C\uDF0D"));
        geo.add(Phrase.image(R.string.geo261, "\uD83C\uDF0D"));
        geo.add(Phrase.image(R.string.geo262, "\uD83C\uDF0D"));
        geo.add(Phrase.image(R.string.geo263, "\uD83C\uDF0E"));
        geo.add(Phrase.image(R.string.geo264, "\uD83C\uDF0F"));
        geo.add(Phrase.image(R.string.geo265, "\uD83C\uDF0E"));
        geo.add(Phrase.image(R.string.geo266, "\uD83C\uDF0E"));
        geo.add(Phrase.image(R.string.geo267, "\uD83C\uDF0E"));
        geo.add(Phrase.image(R.string.geo268, "\uD83C\uDF0A"));
        geo.add(Phrase.image(R.string.geo269, "\uD83C\uDF0A"));
        geo.add(Phrase.image(R.string.geo270, "\uD83C\uDF0A"));
        geo.add(Phrase.image(R.string.geo271, "\uD83C\uDF0A"));
        geo.add(Phrase.image(R.string.geo272, "\uD83C\uDF0A"));
        return geo;
    }
}
