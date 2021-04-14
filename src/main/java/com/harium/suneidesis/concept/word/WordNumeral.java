package com.harium.suneidesis.concept.word;


public class WordNumeral extends Word {

    public WordNumeral(String name) {
        super(name, Word.TAG_NUMERAL);
    }

    public WordNumeral(String name, String type) {
        this(name);
        setWordType(new Word(type));
    }

}
