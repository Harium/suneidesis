package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class Pronoun {

    private String word;

    private String type;

    public Pronoun() {
    }

    public Pronoun(String word) {
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
