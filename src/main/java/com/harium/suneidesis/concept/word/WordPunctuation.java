package com.harium.suneidesis.concept.word;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class WordPunctuation extends Word {

    public WordPunctuation(String name) {
        super(name, Tag.PUNCTUATION);
    }

    @Override
    public WordPunctuation wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
