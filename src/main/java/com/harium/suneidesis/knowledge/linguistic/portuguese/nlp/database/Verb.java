package com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.database;

public class Verb {

    private String lemma;

    private String preposition;

    public Verb(String lemma) {
        this.lemma = lemma;
    }

    public String getLemma() {
        return lemma;
    }

    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

    public String getPreposition() {
        return preposition;
    }

    public void setPreposition(String preposition) {
        this.preposition = preposition;
    }
}
