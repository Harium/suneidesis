package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class Conjuction extends WordModel {

    private String type;

    public Conjuction() {
    }

    public Conjuction(String wordId) {
        super(wordId);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
