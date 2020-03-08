package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class Numeral {

    private String word;

    private String type;

    public Numeral() {
    }

    public Numeral(String word, String type) {
        this.word = word;
        this.type = type;
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
