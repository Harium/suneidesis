package com.harium.suneidesis.concept.word;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.concept.attribute.Attributes;

public class Word extends Concept {

    public static final String ATTRIBUTE_TAG = "tag";
    public static final String ATTRIBUTE_LEMMA = "lemma";
    private static final String ATTRIBUTE_VALUE = "value";

    public static final String TAG_ADJECTIVE = "adjective";
    public static final String TAG_ADVERB = "adverb";
    public static final String TAG_CONJUNCTION = "conjunction";
    public static final String TAG_DETERMINER = "det";
    public static final String TAG_INTERJECTION = "interjection";
    public static final String TAG_NOUN = "noun";
    public static final String TAG_NUMERAL = "number";
    public static final String TAG_PREPOSITION = "preposition";
    public static final String TAG_PRONOUN = "pronoun";
    public static final String TAG_PUNCTUATION = "punct";
    public static final String TAG_VERB = "verb";
    public static final String TAG_VERB_CONJUGATION = "verb_conj";

    private String word;

    public Word(String name) {
        super(ConceptType.WORD);
        this.word = name;
    }

    public Word(String name, String tag) {
        this(name);
        set(ATTRIBUTE_TAG, new Word(tag));
    }

    @Override
    public void setName(String name) {
        // Hacky way to avoid stack overflow
        word = name;
    }

    public String getName() {
        // Hacky way to avoid stack overflow
        return word;
    }

    public Word getLemma() {
        return (Word) attributes.get(ATTRIBUTE_LEMMA);
    }

    public String getLemmaWord() {
        return attributes.get(ATTRIBUTE_LEMMA).getName();
    }

    public void setLemma(Word lemma) {
        attributes.set(ATTRIBUTE_LEMMA, lemma);
    }

    public Word getTag() {
        return (Word) attributes.get(ATTRIBUTE_TAG);
    }

    public String getTagWord() {
        return attributes.get(ATTRIBUTE_TAG).getName();
    }

    public void setTag(Word tag) {
        attributes.set(ATTRIBUTE_TAG, tag);
    }

    public void setTag(String tagName) {
        attributes.set(ATTRIBUTE_TAG, new Word(tagName));
    }
}
