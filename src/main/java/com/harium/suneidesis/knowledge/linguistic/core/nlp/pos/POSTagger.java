package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos;

public interface POSTagger {

    TagPair[] posTag(String[] tokens);

}
