package com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.database;

import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.Tag;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model.Verb;

import java.util.List;

public interface WordDatabase {

    long getId(String word);

    List<Tag> getTags(String word);

    Verb getVerb(String verb);
}
