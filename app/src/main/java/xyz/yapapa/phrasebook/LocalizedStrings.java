package xyz.yapapa.phrasebook;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Строки карточек на родном и изучаемом языках. Ресурсы каждого языка создаются один раз:
 * раньше {@code Configuration} и {@code Context} создавались при каждом bind и клике.
 */
final class LocalizedStrings {

    private final Context appContext;
    private final String originalLanguage;
    private final String translationLanguage;
    private final Map<String, Resources> cache = new HashMap<>();

    LocalizedStrings(Context context, String originalLanguage, String translationLanguage) {
        this.appContext = context.getApplicationContext();
        this.originalLanguage = originalLanguage;
        this.translationLanguage = translationLanguage;
    }

    /** Текст на родном языке (верхняя подпись карточки). */
    String original(int stringRes) {
        return get(stringRes, originalLanguage);
    }

    /** Текст на изучаемом языке (нижняя подпись карточки). */
    String translation(int stringRes) {
        return get(stringRes, translationLanguage);
    }

    private String get(int stringRes, String language) {
        return resources(language).getString(stringRes);
    }

    private Resources resources(String language) {
        Resources resources = cache.get(language);
        if (resources == null) {
            Configuration configuration = new Configuration(appContext.getResources().getConfiguration());
            configuration.setLocale(Locale.forLanguageTag(language));
            resources = appContext.createConfigurationContext(configuration).getResources();
            cache.put(language, resources);
        }
        return resources;
    }
}
