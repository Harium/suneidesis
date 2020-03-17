package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class WordMeaning {

    private long wordId;

    private String meaning;

    public WordMeaning() {
    }

    public WordMeaning(long wordId, String meaning) {
        this.wordId = wordId;
        this.meaning = meaning;
    }

    public long getWordId() {
        return wordId;
    }

    public void setWordId(long wordId) {
        this.wordId = wordId;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }
}
