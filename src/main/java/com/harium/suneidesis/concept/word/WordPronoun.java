package com.harium.suneidesis.concept.word;


import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class WordPronoun extends Word {

    public WordPronoun(String name) {
        super(name, Tag.PRONOUN);
    }

    public WordPronoun(String name, String type) {
        this(name);
        setWordType(new Word(type));
    }

}
