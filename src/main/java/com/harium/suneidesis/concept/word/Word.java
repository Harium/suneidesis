package com.harium.suneidesis.concept.word;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.concept.Primitive;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class Word extends Primitive {

    public static final String ATTRIBUTE_TAG = "tag";
    public static final String ATTRIBUTE_LEMMA = "lemma";
    public static final String ATTRIBUTE_WORD_TYPE = "word_type";

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

    public Word getLemma() {
        return (Word) getAttributes().get(ATTRIBUTE_LEMMA);
    }

    public String getLemmaWord() {
        return getAttributes().get(ATTRIBUTE_LEMMA).getName();
    }

    public void setLemma(Word lemma) {
        getAttributes().insert(ATTRIBUTE_LEMMA, lemma);
    }

    public Word getTag() {
        return (Word) getAttributes().get(ATTRIBUTE_TAG);
    }

    public String getTagWord() {
        return getAttributes().get(ATTRIBUTE_TAG).getName();
    }

    public void setTag(Word tag) {
        getAttributes().insert(ATTRIBUTE_TAG, tag);
    }

    public void setTag(String tagName) {
        getAttributes().insert(ATTRIBUTE_TAG, new Word(tagName));
    }

    public Word getWordType() {
        return (Word) getAttributes().get(ATTRIBUTE_WORD_TYPE);
    }

    public String getWordTypeText() {
        return getWordType().getName();
    }

    public void setWordType(Word Type) {
        getAttributes().insert(ATTRIBUTE_WORD_TYPE, Type);
    }

    @Override
    public Word wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
