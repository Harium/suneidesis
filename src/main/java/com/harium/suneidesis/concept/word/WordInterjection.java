package com.harium.suneidesis.concept.word;


import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class WordInterjection extends Word {

    public WordInterjection(String name) {
        super(name, Tag.INTERJECTION);
    }

    public WordInterjection(String name, String type) {
        this(name);
        setWordType(new Word(type));
    }

}
