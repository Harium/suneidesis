package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class Determiner {

    private String word;

    private String gender;

    private String type;

    public Determiner() {
    }

    public Determiner(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
