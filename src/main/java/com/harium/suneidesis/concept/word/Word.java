package com.harium.suneidesis.concept.word;

import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.concept.Primitive;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;

public class Word extends Primitive {

    public static final String ATTRIBUTE_TAG = "tag";
    public static final String ATTRIBUTE_LEMMA = "lemma";
    public static final String ATTRIBUTE_WORD_TYPE = "word_type";

    private String wordId;

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
        return wordId;
    }

    public void setWordId(String id) {
        this.wordId = id;
    }

    public Word getLemma() {
        return (Word) attributes.get(ATTRIBUTE_LEMMA);
    }

    public String getLemmaWord() {
        return attributes.get(ATTRIBUTE_LEMMA).getName();
    }

    public void setLemma(Word lemma) {
        attributes.insert(ATTRIBUTE_LEMMA, lemma);
    }

    public Word getTag() {
        return (Word) attributes.get(ATTRIBUTE_TAG);
    }

    public String getTagWord() {
        return attributes.get(ATTRIBUTE_TAG).getName();
    }

    public void setTag(Word tag) {
        attributes.insert(ATTRIBUTE_TAG, tag);
    }

    public void setTag(String tagName) {
        attributes.insert(ATTRIBUTE_TAG, new Word(tagName));
    }

    public Word getWordType() {
        return (Word) attributes.get(ATTRIBUTE_WORD_TYPE);
    }

    public String getWordTypeText() {
        return getWordType().getName();
    }

    public void setWordType(Word Type) {
        attributes.insert(ATTRIBUTE_WORD_TYPE, Type);
    }
}
