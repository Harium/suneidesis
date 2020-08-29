package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class Numeral extends WordModel {

    private String type;

    public Numeral() {
    }

    public Numeral(String wordId, String type) {
        super(wordId);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
