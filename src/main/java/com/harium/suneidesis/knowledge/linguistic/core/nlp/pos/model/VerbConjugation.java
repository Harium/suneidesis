package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class VerbConjugation {

    private String word;

    private String verb; // Infinitive form

    private String person;

    private String tense;

    public VerbConjugation() {
    }

    public VerbConjugation(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getTense() {
        return tense;
    }

    public void setTense(String tense) {
        this.tense = tense;
    }
}
