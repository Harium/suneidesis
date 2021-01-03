package com.harium.suneidesis.concept.word;


public class WordAdverb extends Word {

    public static final String ATTRIBUTE_TYPE = "type";

    public WordAdverb(String name) {
        super(name, Word.TAG_ADVERB);
    }

    public WordAdverb(String name, String type) {
        this(name);
        setType(new Word(type));
    }

    public Word getType() {
        return (Word) attributes.get(ATTRIBUTE_TYPE);
    }

    public String getTypeWord() {
        return getType().getName();
    }

    public void setType(Word Type) {
        attributes.set(ATTRIBUTE_TYPE, Type);
    }
}
