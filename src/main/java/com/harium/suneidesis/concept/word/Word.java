package com.harium.suneidesis.concept.word;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.concept.Primitive;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class Word extends Primitive {

    public static final String ATTRIBUTE_TAG = "tag";
    public static final String ATTRIBUTE_LEMMA = "lemma";
    public static final String ATTRIBUTE_WORD_TYPE = "word_type";
    public static final String ATTRIBUTE_MEANING = "meaning";
    public static final String ATTRIBUTE_LANGUAGE = "language";

    // Plural / Singular
    public static final String ATTRIBUTE_NUMBER = "number";
    public static final String ATTRIBUTE_NUMBER_PLURAL = "plural";
    public static final String ATTRIBUTE_NUMBER_SINGULAR = "singular";

    public Word(String name) {
        super(name, ConceptType.WORD);
    }

    public Word(String name, String tag) {
        this(name);
        has(ATTRIBUTE_TAG, new Word(tag));
    }

    public Word(String name, Tag tag) {
        this(name);
        has(ATTRIBUTE_TAG, new Word(tag.name()));
    }

    public String getWordId() {
        return getId();
    }

    public void setWordId(String id) {
        this.id(id);
    }

    public Concept getLemmaConcept() {
        return getAttributes().get(ATTRIBUTE_LEMMA);
    }

    public String getLemma() {
        return getLemmaConcept().getName();
    }

    public void setLemma(Word lemma) {
        getAttributes().save(ATTRIBUTE_LEMMA, lemma);
    }

    public Concept getMeaningConcept() {
        return getAttributes().get(ATTRIBUTE_MEANING);
    }

    public String getMeaning() {
        return getMeaningConcept().getName();
    }

    public void setMeaning(Concept meaning) {
        getAttributes().save(ATTRIBUTE_MEANING, meaning);
    }

    public Concept getLanguageConcept() {
        return getAttributes().get(ATTRIBUTE_LANGUAGE);
    }

    public String getLanguage() {
        return getLanguageConcept().getName();
    }

    public void setLanguage(Concept language) {
        getAttributes().save(ATTRIBUTE_LANGUAGE, language);
    }

    public Concept getNumberConcept() {
        return getAttributes().get(ATTRIBUTE_NUMBER);
    }

    public String getNumber() {
        return getNumberConcept().getName();
    }

    public void setNumber(Word number) {
        getAttributes().save(ATTRIBUTE_NUMBER, number);
    }

    public void setNumberPlural() {
        setNumber(new Word(ATTRIBUTE_NUMBER_PLURAL));
    }

    public void setNumberSingular() {
        setNumber(new Word(ATTRIBUTE_NUMBER_SINGULAR));
    }

    public Concept getTagConcept() {
        return getAttributes().get(ATTRIBUTE_TAG);
    }

    public String getTag() {
        return getTagConcept().getName();
    }

    public void setTag(Word tag) {
        getAttributes().save(ATTRIBUTE_TAG, tag);
    }

    public void setTag(String tagName) {
        setTag(new Word(tagName));
    }

    public Concept getWordTypeConcept() {
        return getAttributes().get(ATTRIBUTE_WORD_TYPE);
    }

    public String getWordType() {
        return getWordTypeConcept().getName();
    }

    public void setWordType(Word type) {
        getAttributes().save(ATTRIBUTE_WORD_TYPE, type);
    }

    @Override
    public Word wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
