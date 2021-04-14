package com.harium.suneidesis.concept.word;


public class WordInterjection extends Word {

    public WordInterjection(String name) {
        super(name, Word.TAG_INTERJECTION);
    }

    public WordInterjection(String name, String type) {
        this(name);
        setWordType(new Word(type));
    }

}
