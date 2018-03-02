package xyz.yapapa.phrasebook;

import java.io.Serializable;

/**
 * Created by Misha on 09.01.2018.
 */

class Phrase implements Serializable {
    private Integer field ;
    private String image;

    public Integer getColor() {
        return color;
    }

    private Integer color;

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public String getTranslateLanguage() {
        return translateLanguage;
    }

    private String defaultLanguage;
    private String translateLanguage;

    public Phrase(Integer field, String image) {
        this.field = field;
        this.image = image;
    }
    public Phrase(Integer field, String image, String defaultLanguage, String translateLanguage) {
        this.field = field;
        this.image = image;
        this.defaultLanguage = defaultLanguage;
        this.translateLanguage = translateLanguage;
    }

    public Phrase(Integer field, Integer color, String defaultLanguage, String translateLanguage) {
        this.field = field;
        this.color = color;
        this.defaultLanguage = defaultLanguage;
        this.translateLanguage = translateLanguage;
    }
    public void setField(Integer field) {
        this.field = field;
    }

    public String getImage() {

        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getField() {

        return field;
    }


}
