package xyz.yapapa.phrasebook;

import java.io.Serializable;

/**
 * Created by Misha on 09.01.2018.
 */

class Phrase implements Serializable {
    private Integer field ;
    private Integer image;

    public String getDefaultLanguage() {
        return defaultLanguage;
    }

    public String getTranslateLanguage() {
        return translateLanguage;
    }

    private String defaultLanguage;
    private String translateLanguage;

    public Phrase(Integer field, Integer image) {
        this.field = field;
        this.image = image;
    }
    public Phrase(Integer field, Integer image, String defaultLanguage, String translateLanguage) {
        this.field = field;
        this.image = image;
        this.defaultLanguage = defaultLanguage;
        this.translateLanguage = translateLanguage;
    }
    public void setField(Integer field) {
        this.field = field;
    }

    public Integer getImage() {

        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Integer getField() {

        return field;
    }


}
