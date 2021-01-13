package com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.pos;

import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.POSTagger;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.Tag;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.TagPair;
import com.harium.suneidesis.knowledge.linguistic.core.storage.WordRepository;
import com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.database.MemoryWordRepository;

public abstract class DatabasePOSTagger implements POSTagger {

    protected WordRepository database;

    public DatabasePOSTagger() {
        this.database = new MemoryWordRepository();
    }

    public DatabasePOSTagger(WordRepository database) {
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
