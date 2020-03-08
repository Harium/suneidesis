package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class Conjuction {

    private String word;

    private String type;

    public Conjuction() {
    }

    public Conjuction(String word) {
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
}
