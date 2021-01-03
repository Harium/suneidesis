package com.harium.suneidesis.concept.word;


public class WordConjunction extends Word {

    public static final String ATTRIBUTE_TYPE = "type";

    public WordConjunction(String name) {
        super(name, Word.TAG_CONJUNCTION);
    }

    public WordConjunction(String name, String type) {
        super(name, Word.TAG_CONJUNCTION);
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
