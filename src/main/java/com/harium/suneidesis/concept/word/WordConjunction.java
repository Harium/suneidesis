package com.harium.suneidesis.concept.word;


import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class WordConjunction extends Word {

    public WordConjunction(String name) {
        super(name, Tag.CONJUCTION);
    }

    public WordConjunction(String name, String type) {
        this(name);
        setWordType(new Word(type));
    }
}
