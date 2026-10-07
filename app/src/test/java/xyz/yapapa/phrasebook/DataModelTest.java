package xyz.yapapa.phrasebook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/** Проверки данных карточек: категории не пустые, ключи и имена файлов не повторяются. */
public class DataModelTest {

    private static final Pattern IMAGE_NAME = Pattern.compile("[a-z]+\\d+\\.(png|gif)");

    /** Картинки, которыми осознанно пользуются несколько карточек: «Год» и «Тысячелетие» (time17.png на сервере нет), фразы «Ничего страшного», «Всё в порядке», «Не беспокойтесь». */
    private static final Set<String> SHARED_IMAGES = new HashSet<>(Arrays.asList("time16.png", "phrases14.gif"));

    @Test
    public void categoriesMatchTabs() {
        assertEquals(31, Category.values().length);
        assertEquals(Category.ALPHABET, Category.values()[0]);
        assertEquals(Category.GEO, Category.values()[30]);
    }

    @Test
    public void everyPhraseCategoryHasUniqueStrings() {
        for (Category category : Category.values()) {
            if (category.kind == Category.Kind.CHARS) continue;
            List<Phrase> phrases = DataModel.phrases(category);
            assertFalse(category + " пуста", phrases.isEmpty());

            Set<Integer> fields = new HashSet<>();
            for (Phrase phrase : phrases) {
                assertTrue(category + ": строка " + phrase.getField() + " повторяется",
                        fields.add(phrase.getField()));
            }
        }
    }

    @Test
    public void wordCardsHaveValidAndUniqueImageNames() {
        Set<String> names = new HashSet<>();
        for (Category category : Category.values()) {
            if (category.kind != Category.Kind.WORDS) continue;
            for (Phrase phrase : DataModel.phrases(category)) {
                String image = phrase.getImage();
                assertNotNull(category + ": нет картинки", image);
                assertTrue("Неверное имя файла: " + image, IMAGE_NAME.matcher(image).matches());
                assertTrue("Имя файла повторяется: " + image,
                        names.add(image) || SHARED_IMAGES.contains(image));
            }
        }
    }

    @Test
    public void colorCardsHaveColors() {
        for (Phrase phrase : DataModel.phrases(Category.COLORS)) {
            assertNotEquals("У цвета нет ресурса", 0, phrase.getColor());
        }
    }

    @Test
    public void flagCardsHaveEmoji() {
        for (Phrase phrase : DataModel.phrases(Category.GEO)) {
            assertNotNull(phrase.getImage());
            assertFalse(phrase.getImage().isEmpty());
        }
    }

    @Test
    public void alphabetsAreNotEmptyAndWithoutDuplicates() {
        for (String language : new String[]{"en", "ru", "de", "it", "es", "pt", "fi", "be", "uk", "fr", "zh"}) {
            List<String> letters = DataModel.alphabet(language);
            assertFalse(language, letters.isEmpty());
            assertEquals(language + ": буквы повторяются", letters.size(), new HashSet<>(letters).size());
        }
    }

    @Test
    public void cyrillicAlphabetsUseCyrillicLetters() {
        for (String language : new String[]{"ru", "be", "uk"}) {
            for (String letter : DataModel.alphabet(language)) {
                assertTrue(language + ": «" + letter + "» не кириллица",
                        Character.UnicodeBlock.of(letter.charAt(0)) == Character.UnicodeBlock.CYRILLIC);
            }
        }
    }

    @Test
    public void ukrainianAlphabetHasNoRussianOnlyLetters() {
        List<String> uk = DataModel.alphabet("uk");
        assertEquals(33, uk.size());
        for (String letter : new String[]{"Ы", "Э", "Ъ", "Ё"}) {
            assertFalse(letter, uk.contains(letter));
        }
        assertTrue(uk.contains("Ґ") && uk.contains("Є") && uk.contains("І") && uk.contains("Ї"));
    }

    @Test
    public void finnishAlphabetEndsWithScandinavianLetters() {
        List<String> fi = DataModel.alphabet("fi");
        assertEquals(29, fi.size());
        assertEquals(Arrays.asList("Å", "Ä", "Ö"), fi.subList(26, 29));
    }

    @Test
    public void numbersCoverZeroToThousandAndMillion() {
        List<String> numbers = DataModel.numbers();
        assertEquals(1002, numbers.size());
        assertEquals("0", numbers.get(0));
        assertEquals("1000", numbers.get(1000));
        assertEquals("1000000", numbers.get(1001));
    }
}
