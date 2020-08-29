package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class VerbConjugation extends WordModel {

    private String verbWordId; // Infinitive form

    private String person;

    private String tense;

    public VerbConjugation() {
    }

    public VerbConjugation(String wordId) {
        super(wordId);
    }

    public String getVerbWordId() {
        return verbWordId;
    }

    public void setVerbWordId(String verbWordId) {
        this.verbWordId = verbWordId;
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
