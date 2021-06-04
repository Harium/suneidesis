package com.harium.suneidesis.concept.word;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class WordPronoun extends Word {

    public WordPronoun(String name) {
        super(name, Tag.PRONOUN);
    }

    @Override
    public WordPronoun wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
