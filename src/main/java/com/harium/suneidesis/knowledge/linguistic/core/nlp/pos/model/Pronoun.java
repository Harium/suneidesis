package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class Pronoun {

    private long wordId;

    private String type;

    public Pronoun() {
    }

    public Pronoun(long wordId) {
        this.wordId = wordId;
    }

    public long getWordId() {
        return wordId;
    }

    public void setWordId(long wordId) {
        this.wordId = wordId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
