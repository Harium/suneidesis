package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class Determiner extends WordModel {

    private String gender;

    private String type;

    public Determiner() {
    }

    public Determiner(String wordId) {
        super(wordId);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
