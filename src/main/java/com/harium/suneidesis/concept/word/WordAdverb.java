package com.harium.suneidesis.concept.word;


public class WordAdverb extends Word {

    public WordAdverb(String name) {
        super(name, Word.TAG_ADVERB);
    }

    public WordAdverb(String name, String type) {
        this(name);
        setWordType(new Word(type));
    }

}
