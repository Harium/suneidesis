package com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.database;

import java.util.List;

public interface WordDatabase {

    List<String> getTags(String word);

    Verb getVerb(String verb);

}
