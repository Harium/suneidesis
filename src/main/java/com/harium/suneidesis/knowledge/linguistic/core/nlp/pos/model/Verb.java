package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class Verb extends WordModel {

    // The same verb may have none or more than one
    // E.g: to,from,of,X <- None
    private String prepositions;

    private String transitivity;

    public Verb() {
    }

    public Verb(String wordId) {
        super(wordId);
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
