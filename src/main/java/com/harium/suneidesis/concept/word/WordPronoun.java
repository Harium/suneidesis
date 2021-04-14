package com.harium.suneidesis.concept.word;


public class WordPronoun extends Word {

    public WordPronoun(String name) {
        super(name, Word.TAG_PRONOUN);
    }

    public WordPronoun(String name, String type) {
        this(name);
        setWordType(new Word(type));
    }

}
