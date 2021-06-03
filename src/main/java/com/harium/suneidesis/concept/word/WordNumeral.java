package com.harium.suneidesis.concept.word;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class WordNumeral extends Word {

    public WordNumeral(String name) {
        super(name, Tag.NUMERAL);
    }

    @Override
    public WordNumeral wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
