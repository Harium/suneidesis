package com.harium.suneidesis.concept.word;


import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class WordInterjection extends Word {

    public WordInterjection(String name) {
        super(name, Tag.INTERJECTION);
    }

    public WordInterjection(String name, String type) {
        this(name);
        setWordType(new Word(type));
    }

    @Override
    public WordInterjection wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
