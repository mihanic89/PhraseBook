package xyz.yapapa.phrasebook;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Проверки переводов: во всех языках одинаковые ключи, нет пустых и неэкранированных строк. */
public class TranslationsTest {

    private static final String[] LANGUAGES = {"en", "ru", "fr", "de", "es", "it", "pt", "fi", "be", "uk", "zh"};
    private static final Pattern STRING = Pattern.compile("<string name=\"([^\"]+)\"[^>]*>(.*)</string>");
    /**
     * Правила Android для строк: апостроф допустим только после обратной косой черты или внутри
     * двойных кавычек ("'"), а кавычки должны закрываться.
     */
    private static boolean hasBadQuoting(String value) {
        boolean quoted = false;
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (c == '\\') {
                i++;
            } else if (c == '"') {
                quoted = !quoted;
            } else if (c == '\'' && !quoted) {
                return true;
            }
        }
        return quoted;
    }

    private static Map<String, String> load(String folder) throws IOException {
        File file = new File("src/main/res/" + folder + "/strings.xml");
        Map<String, String> strings = new TreeMap<>();
        for (String line : Files.readAllLines(file.toPath(), StandardCharsets.UTF_8)) {
            Matcher matcher = STRING.matcher(line);
            if (matcher.find()) strings.put(matcher.group(1), matcher.group(2));
        }
        return strings;
    }


    @Test
    public void allLanguagesHaveTheSameKeys() throws IOException {
        Set<String> expected = load("values-en").keySet();
        for (String language : LANGUAGES) {
            Set<String> keys = load("values-" + language).keySet();
            Set<String> missing = new TreeSet<>(expected);
            missing.removeAll(keys);
            Set<String> extra = new TreeSet<>(keys);
            extra.removeAll(expected);
            assertTrue(language + ": нет ключей " + missing, missing.isEmpty());
            assertTrue(language + ": лишние ключи " + extra, extra.isEmpty());
        }
    }

    @Test
    public void noEmptyOrUnescapedStrings() throws IOException {
        for (String language : LANGUAGES) {
            for (Map.Entry<String, String> entry : load("values-" + language).entrySet()) {
                String where = language + "/" + entry.getKey();
                assertFalse(where + " пусто", entry.getValue().trim().isEmpty());
                assertFalse(where + ": неверное экранирование в «" + entry.getValue() + "»",
                        hasBadQuoting(entry.getValue()));
                assertEquals(where + ": пробелы по краям", entry.getValue().trim(), entry.getValue());
            }
        }
    }

    @Test
    public void defaultStringsCoverEnglishKeys() throws IOException {
        Set<String> defaults = load("values").keySet();
        assertTrue(defaults.containsAll(load("values-en").keySet()));
    }

    @Test
    public void everyCardStringExistsInEveryLanguage() throws Exception {
        Map<Integer, String> names = new TreeMap<>();
        for (Field field : R.string.class.getFields()) {
            names.put(field.getInt(null), field.getName());
        }
        for (Category category : Category.values()) {
            if (category.kind == Category.Kind.CHARS) continue;
            for (Phrase phrase : DataModel.phrases(category)) {
                String name = names.get(phrase.getField());
                for (String language : LANGUAGES) {
                    assertTrue(language + ": нет строки " + name,
                            load("values-" + language).containsKey(name));
                }
            }
        }
    }

    @Test
    public void tabTitlesExistInEveryLanguage() throws Exception {
        for (String language : LANGUAGES) {
            Map<String, String> strings = load("values-" + language);
            for (int i = 1; i <= Category.values().length; i++) {
                assertTrue(language + ": нет tab" + i, strings.containsKey(String.format("tab%02d", i)));
            }
        }
    }
}
