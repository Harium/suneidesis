package com.harium.suneidesis.linguistic.portuguese.nlp.pos;

import com.harium.suneidesis.linguistic.nlp.pos.POSTagger;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.linguistic.nlp.pos.TagPair;
import com.harium.suneidesis.linguistic.repository.WordRepository;
import com.harium.suneidesis.linguistic.portuguese.nlp.database.MemoryWordBase;

public abstract class DatabasePOSTagger implements POSTagger {

    protected WordRepository database;

    public DatabasePOSTagger() {
        this.database = new MemoryWordBase();
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
