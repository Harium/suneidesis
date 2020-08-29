package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class Punctuation extends WordModel {

    // Interrogation, exclamation
    private String type;

    public Punctuation() {
    }

    public Punctuation(String wordId) {
        super(wordId);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
