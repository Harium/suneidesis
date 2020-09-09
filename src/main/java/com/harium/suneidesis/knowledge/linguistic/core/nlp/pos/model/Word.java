package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model;

public class Word extends WordModel {

    private String word;

    private String lemmaId;

    private String tag;

    public Word() {
    }

    public Word(String word, String tag) {
        this.word = word;
        this.tag = tag;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getLemmaId() {
        return lemmaId;
    }

    public void setLemmaId(String lemmaId) {
        this.lemmaId = lemmaId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

}
