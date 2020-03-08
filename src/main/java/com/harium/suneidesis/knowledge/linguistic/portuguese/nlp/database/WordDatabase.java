package com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.database;

import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.Tag;

import java.util.List;

public interface WordDatabase {

    List<Tag> getTags(String word);

    Verb getVerb(String verb);

}
