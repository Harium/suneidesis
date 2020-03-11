package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class Verb {

    private long wordId;

    // The same verb may have none or more than one
    private String preposition;

    private String transitivity;

    public Verb() {
    }

    public Verb(long wordId) {
        this.wordId = wordId;
    }

    public long getWordId() {
        return wordId;
    }

    public void setWordId(long wordId) {
        this.wordId = wordId;
    }

    public String getPreposition() {
        return preposition;
    }

    public void setPreposition(String preposition) {
        this.preposition = preposition;
    }

    public String getTransitivity() {
        return transitivity;
    }

    public void setTransitivity(String transitivity) {
        this.transitivity = transitivity;
    }
}
