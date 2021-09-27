package com.harium.suneidesis.linguistic.nlp;

import com.harium.suneidesis.linguistic.nlp.pos.TagPair;

public interface NLP {

    TagPair[] posTag(String sentence);

}
