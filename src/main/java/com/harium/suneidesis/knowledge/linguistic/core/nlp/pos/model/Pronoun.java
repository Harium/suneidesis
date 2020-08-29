package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class Pronoun extends WordModel {

    private String type;

    public Pronoun() {
    }

    public Pronoun(String wordId) {
        super(wordId);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
