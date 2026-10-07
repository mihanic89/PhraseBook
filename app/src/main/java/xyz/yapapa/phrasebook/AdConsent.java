package xyz.yapapa.phrasebook;

import android.app.Activity;
import android.content.Context;

import com.google.android.gms.ads.MobileAds;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.UserMessagingPlatform;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Согласие на рекламу через Google UMP. Форма показывается только там, где её требует закон
 * (ЕЭЗ, Великобритания, Швейцария, штаты США и т. п.); сами сообщения настраиваются в AdMob
 * в разделе «Конфиденциальность и сообщения». Реклама запрашивается только после
 * {@link #canRequestAds}. Пока {@code BuildConfig.ADS_ENABLED == false}, ни реклама, ни UMP
 * не запускаются (флаг в app/build.gradle).
 */
final class AdConsent {

    /** Отладка: показать форму как в ЕЭЗ (только в debug-сборке). */
    private static final boolean DEBUG_FORCE_EEA = false;
    /** Отладка: при каждом запуске сбрасывать сохранённое согласие (только в debug-сборке). */
    private static final boolean DEBUG_RESET = false;

    private static final AtomicBoolean mobileAdsStarted = new AtomicBoolean(false);

    interface Listener {
        /** Сбор согласия завершён (успешно или с ошибкой); дальше проверяйте {@link #canRequestAds}. */
        void onConsentGathered();
    }

    private AdConsent() {
    }

    private static ConsentInformation info(Context context) {
        return UserMessagingPlatform.getConsentInformation(context);
    }

    /** Обновляет статус согласия и при необходимости показывает форму. */
    static void gather(Activity activity, Listener listener) {
        if (!BuildConfig.ADS_ENABLED) {
            listener.onConsentGathered();
            return;
        }
        ConsentRequestParameters.Builder params = new ConsentRequestParameters.Builder();
        if (BuildConfig.DEBUG && DEBUG_FORCE_EEA) {
            params.setConsentDebugSettings(new ConsentDebugSettings.Builder(activity)
                    .setDebugGeography(ConsentDebugSettings.DebugGeography.DEBUG_GEOGRAPHY_EEA)
                    .build());
        }
        ConsentInformation info = info(activity);
        if (BuildConfig.DEBUG && DEBUG_RESET) {
            info.reset();
        }
        info.requestConsentInfoUpdate(activity, params.build(),
                () -> UserMessagingPlatform.loadAndShowConsentFormIfRequired(activity,
                        formError -> listener.onConsentGathered()),
                requestError -> listener.onConsentGathered());
    }

    /** Можно ли запрашивать рекламу (согласие получено или не требуется). */
    static boolean canRequestAds(Context context) {
        return BuildConfig.ADS_ENABLED && info(context).canRequestAds();
    }

    /** Нужно ли показывать пункт «Настройки конфиденциальности рекламы». */
    static boolean isPrivacyOptionsRequired(Context context) {
        return BuildConfig.ADS_ENABLED && info(context).getPrivacyOptionsRequirementStatus()
                == ConsentInformation.PrivacyOptionsRequirementStatus.REQUIRED;
    }

    /** Повторно показывает форму, чтобы пользователь мог изменить решение. */
    static void showPrivacyOptions(Activity activity, Listener listener) {
        UserMessagingPlatform.showPrivacyOptionsForm(activity, formError -> listener.onConsentGathered());
    }

    /** Инициализирует Mobile Ads один раз за процесс; вызывать только при {@link #canRequestAds}. */
    static void startMobileAds(Context context) {
        if (mobileAdsStarted.compareAndSet(false, true)) {
            MobileAds.initialize(context.getApplicationContext(), status -> { });
        }
    }
}
