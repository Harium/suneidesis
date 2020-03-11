package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class Determiner {

    private long wordId;

    private String gender;

    private String type;

    public Determiner() {
    }

    public Determiner(long wordId) {
        this.wordId = wordId;
    }

    public long getWordId() {
        return wordId;
    }

    public void setWordId(long wordId) {
        this.wordId = wordId;
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
