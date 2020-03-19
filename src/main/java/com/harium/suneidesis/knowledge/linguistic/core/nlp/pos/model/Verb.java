package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class Verb {

    private long wordId;

    // The same verb may have none or more than one
    // E.g: a|de|em|X <--- None
    private String prepositions;

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

    public String getPrepositions() {
        return prepositions;
    }

    public void setPrepositions(String prepositions) {
        this.prepositions = prepositions;
    }

    public String getTransitivity() {
        return transitivity;
    }

    public void setTransitivity(String transitivity) {
        this.transitivity = transitivity;
    }
}
