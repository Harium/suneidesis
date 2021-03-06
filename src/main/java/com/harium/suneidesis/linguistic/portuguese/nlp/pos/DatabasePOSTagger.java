package com.harium.suneidesis.linguistic.portuguese.nlp.pos;

import com.harium.suneidesis.linguistic.nlp.pos.POSTagger;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.linguistic.nlp.pos.TagPair;
import com.harium.suneidesis.repository.word.WordKnowledgeBase;

public abstract class DatabasePOSTagger implements POSTagger {

    protected WordKnowledgeBase database;

    public DatabasePOSTagger(WordKnowledgeBase database) {
        this.database = database;
    }

    protected TagPair[] initTagArray(String[] tokens) {
        TagPair[] output = new TagPair[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            output[i] = new TagPair(tokens[i], Tag.UNKNOWN);
        }

        return output;
    }
}
