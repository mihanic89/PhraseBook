package xyz.yapapa.phrasebook;

/**
 * Категории карточек в порядке вкладок: порядковый номер совпадает с позицией в ViewPager,
 * иконка и подпись вкладки — {@code tabNN}.
 */
enum Category {
    ALPHABET(Kind.CHARS, R.drawable.tab01, R.string.tab01),
    NUMBERS(Kind.CHARS, R.drawable.tab02, R.string.tab02),
    COLORS(Kind.COLORS, R.drawable.tab03, R.string.tab03),
    FORMS(Kind.WORDS, R.drawable.tab04, R.string.tab04),
    TIME(Kind.WORDS, R.drawable.tab05, R.string.tab05),
    FAMILY(Kind.WORDS, R.drawable.tab06, R.string.tab06),
    CLOTHES(Kind.WORDS, R.drawable.tab07, R.string.tab07),
    FOOD(Kind.WORDS, R.drawable.tab08, R.string.tab08),
    VEGETABLES(Kind.WORDS, R.drawable.tab09, R.string.tab09),
    FRUITS(Kind.WORDS, R.drawable.tab10, R.string.tab10),
    BERRIES(Kind.WORDS, R.drawable.tab11, R.string.tab11),
    FLOWERS(Kind.WORDS, R.drawable.tab12, R.string.tab12),
    BODY(Kind.WORDS, R.drawable.tab13, R.string.tab13),
    EMOTIONS(Kind.WORDS, R.drawable.tab14, R.string.tab14),
    ANIMALS(Kind.WORDS, R.drawable.tab15, R.string.tab15),
    HOUSE(Kind.WORDS, R.drawable.tab16, R.string.tab16),
    OBJECTS(Kind.WORDS, R.drawable.tab17, R.string.tab17),
    TOYS(Kind.WORDS, R.drawable.tab18, R.string.tab18),
    MUSICINST(Kind.WORDS, R.drawable.tab19, R.string.tab19),
    SPORT(Kind.WORDS, R.drawable.tab20, R.string.tab20),
    TRANSPORT(Kind.WORDS, R.drawable.tab21, R.string.tab21),
    CITY(Kind.WORDS, R.drawable.tab22, R.string.tab22),
    NATURE(Kind.WORDS, R.drawable.tab23, R.string.tab23),
    ART(Kind.WORDS, R.drawable.tab24, R.string.tab24),
    SCHOOL(Kind.WORDS, R.drawable.tab25, R.string.tab25),
    PROF(Kind.WORDS, R.drawable.tab26, R.string.tab26),
    VERBS(Kind.WORDS, R.drawable.tab27, R.string.tab27),
    ADJECTIVES(Kind.WORDS, R.drawable.tab28, R.string.tab28),
    PHRASES(Kind.WORDS, R.drawable.tab29, R.string.tab29),
    PRETEXT(Kind.WORDS, R.drawable.tab30, R.string.tab30),
    GEO(Kind.FLAGS, R.drawable.tab31, R.string.tab31);

    /** Как выглядит карточка. */
    enum Kind {
        /** Буква или число, озвучивается как есть. */
        CHARS,
        /** Цветная плашка. */
        COLORS,
        /** Картинка с сервера. */
        WORDS,
        /** Эмодзи-флаг. */
        FLAGS
    }

    final Kind kind;
    final int iconRes;
    final int titleRes;

    Category(Kind kind, int iconRes, int titleRes) {
        this.kind = kind;
        this.iconRes = iconRes;
        this.titleRes = titleRes;
    }
}
