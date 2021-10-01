package com.harium.suneidesis.concept.word;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;

/**
 * This class is used to represent multiple types of shortening a word
 * like: abbreviation, contractions, acronyms or initialism
 */
public class WordShort extends Word {

    public WordShort(String name) {
        super(name, Tag.SHORT);
    }

    @Override
    public WordShort wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
