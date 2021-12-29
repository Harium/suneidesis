package com.harium.suneidesis.linguistic.nlp;

import com.harium.suneidesis.linguistic.nlp.pos.TagPair;

/**
 * NLP here stands for Natural Language Processor
 */
public interface NLP {

    TagPair[] posTag(String sentence);

    String lemmatize(String word);

}
