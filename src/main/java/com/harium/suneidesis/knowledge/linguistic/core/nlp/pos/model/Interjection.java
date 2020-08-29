package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class Interjection extends WordModel {

    private String type;

    public Interjection() {
    }

    public Interjection(String wordId) {
        super(wordId);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
