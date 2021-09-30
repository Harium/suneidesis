package com.harium.suneidesis.linguistic.nlp;

import com.harium.suneidesis.linguistic.nlp.pos.TagPair;

public interface POSTagger {

    TagPair[] posTag(String[] tokens);

}
