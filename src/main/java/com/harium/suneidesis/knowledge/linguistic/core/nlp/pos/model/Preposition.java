package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class Preposition extends WordModel {

    // Simple, double, compound
    private String type;

    // Time, place
    private String use;

    public Preposition() {
    }

    public Preposition(String wordId) {
        super(wordId);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }
}
