package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class Preposition {

    private String word;

    // Simple, double, compound
    private String type;

    // Time, place
    private String use;

    public Preposition() {
    }

    public Preposition(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
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
