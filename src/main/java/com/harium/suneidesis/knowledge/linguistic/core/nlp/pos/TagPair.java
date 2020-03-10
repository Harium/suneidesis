package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos;

public class TagPair {

    String word;

    Tag tag;

    public TagPair() {

    }

    public TagPair(String word, Tag tag) {
        this.word = word;
        this.tag = tag;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }
}
