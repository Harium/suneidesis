package com.harium.suneidesis.concept.word;

import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.concept.Primitive;

public class Word extends Primitive {

    public static final String ATTRIBUTE_TAG = "tag";
    public static final String ATTRIBUTE_LEMMA = "lemma";
    public static final String ATTRIBUTE_WORD_TYPE = "word_type";

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

    private String wordId;

    public Word(String name) {
        super(name, ConceptType.WORD);
    }

    public Word(String name, String tag) {
        this(name);
        has(ATTRIBUTE_TAG, new Word(tag));
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

    public Word getWordType() {
        return (Word) attributes.get(ATTRIBUTE_WORD_TYPE);
    }

    public String getWordTypeText() {
        return getWordType().getName();
    }

    public void setWordType(Word Type) {
        attributes.set(ATTRIBUTE_WORD_TYPE, Type);
    }
}
