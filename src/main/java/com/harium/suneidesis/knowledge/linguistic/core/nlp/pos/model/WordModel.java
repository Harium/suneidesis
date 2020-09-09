package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class WordModel {

    protected String wordId;

    protected String lemmaId;

    public WordModel() {}

    public WordModel(String wordId) {
        this.wordId = wordId;
    }

    public String getWordId() {
        return wordId;
    }

    public void setWordId(String wordId) {
        this.wordId = wordId;
    }

    public String getLemmaId() {
        return lemmaId;
    }

    public void setLemmaId(String lemmaId) {
        this.lemmaId = lemmaId;
    }
}
