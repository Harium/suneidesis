package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class VerbConjugation {

    private long wordId;

    private long verbId; // Infinitive form

    private String person;

    private String tense;

    public VerbConjugation() {
    }

    public VerbConjugation(long wordId) {
        this.wordId = wordId;
    }

    public long getWordId() {
        return wordId;
    }

    public void setWordId(long wordId) {
        this.wordId = wordId;
    }

    public long getVerb() {
        return verbId;
    }

    public void setVerb(long verbId) {
        this.verbId = verbId;
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
