package com.harium.suneidesis.concept.word;


public class WordConjunction extends Word {

    public WordConjunction(String name) {
        super(name, Word.TAG_CONJUNCTION);
    }

    public WordConjunction(String name, String type) {
        super(name, Word.TAG_CONJUNCTION);
        setWordType(new Word(type));
    }
}
