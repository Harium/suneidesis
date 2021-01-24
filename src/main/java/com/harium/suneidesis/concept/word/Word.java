package com.harium.suneidesis.concept.word;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.concept.DataType;
import com.harium.suneidesis.concept.Primitive;

public class Word extends Primitive {

    public static final String ATTRIBUTE_TAG = "tag";
    public static final String ATTRIBUTE_LEMMA = "lemma";

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

    private String id;

    public Word(String name) {
        super(ConceptType.WORD);
        setName(name);
    }

    public Word(String name, String tag) {
        this(name);
        has(ATTRIBUTE_TAG, new Word(tag));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
