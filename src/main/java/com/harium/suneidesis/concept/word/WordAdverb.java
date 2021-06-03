package com.harium.suneidesis.concept.word;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class WordAdverb extends Word {

    public WordAdverb(String name) {
        super(name, Tag.ADVERB);
    }

    @Override
    public WordAdverb wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
