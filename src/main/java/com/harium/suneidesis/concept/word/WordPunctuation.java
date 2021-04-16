package com.harium.suneidesis.concept.word;


import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class WordPunctuation extends Word {

    public WordPunctuation(String name) {
        super(name, Tag.PUNCTUATION);
    }

    public WordPunctuation(String name, String type) {
        this(name);
        setWordType(new Word(type));
    }

}
