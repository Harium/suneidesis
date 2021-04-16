package com.harium.suneidesis.concept.word;

import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class WordAdverb extends Word {

    public WordAdverb(String name) {
        super(name, Tag.ADVERB);
    }

    public WordAdverb(String name, String type) {
        this(name);
        setWordType(new Word(type));
    }

}
