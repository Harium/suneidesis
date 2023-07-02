package com.harium.suneidesis.linguistic.nlp;

import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class Token {

    public String word;

    public String lemma;

    public Tag tag;

    public Token(String word, String lemma, Tag tag) {
        this.word = word;
        this.lemma = lemma;
        this.tag = tag;
    }
}
