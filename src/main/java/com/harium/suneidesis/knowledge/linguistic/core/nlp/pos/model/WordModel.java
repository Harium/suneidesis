package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class WordModel {

    protected String wordId;

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
}
