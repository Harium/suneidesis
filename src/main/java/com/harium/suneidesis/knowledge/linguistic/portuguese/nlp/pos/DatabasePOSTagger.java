package com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.pos;

import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.POSTagger;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.Tag;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.TagPair;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.database.WordDatabase;
import com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.database.MemoryDatabase;

public abstract class DatabasePOSTagger implements POSTagger {

    protected WordDatabase database;

    public DatabasePOSTagger() {
        this.database = new MemoryDatabase();
    }

    public DatabasePOSTagger(WordDatabase database) {
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
