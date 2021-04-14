package com.harium.suneidesis.concept.word;


public class WordPunctuation extends Word {

    public WordPunctuation(String name) {
        super(name, Word.TAG_PUNCTUATION);
    }

    public WordPunctuation(String name, String type) {
        this(name);
        setWordType(new Word(type));
    }

}
