package com.harium.suneidesis.linguistic.nlp.pos;

public interface POSTagger {

    TagPair[] posTag(String[] tokens);

}
