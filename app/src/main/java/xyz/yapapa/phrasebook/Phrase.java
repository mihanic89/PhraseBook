package xyz.yapapa.phrasebook;

/**
 * Одна карточка: ресурс строки и либо имя картинки (файл на сервере или эмодзи-флаг),
 * либо ресурс цвета.
 */
final class Phrase {

    private final int field;
    private final String image;
    private final int color;

    private Phrase(int field, String image, int color) {
        this.field = field;
        this.image = image;
        this.color = color;
    }

    static Phrase image(int field, String image) {
        return new Phrase(field, image, 0);
    }

    static Phrase color(int field, int color) {
        return new Phrase(field, null, color);
    }

    /** Ресурс строки с текстом карточки. */
    int getField() {
        return field;
    }

    String getImage() {
        return image;
    }

    int getColor() {
        return color;
    }
}
