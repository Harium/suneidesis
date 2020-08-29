package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class WordMeaning extends WordModel {

    private String meaning;

    public WordMeaning() {
    }

    public WordMeaning(String wordId, String meaning) {
        super(wordId);
        this.meaning = meaning;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
