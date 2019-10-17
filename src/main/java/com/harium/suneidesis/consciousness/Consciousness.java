package com.harium.suneidesis.consciousness;

import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.concept.ConceptType;
import com.harium.suneidesis.knowledge.fact.Fact;
import com.harium.suneidesis.knowledge.storage.MemoryStorage;
import com.harium.suneidesis.knowledge.storage.Storage;

import java.util.List;

public class Consciousness extends Concept {

    protected Storage storage = new MemoryStorage();

    public Consciousness(String name, ConceptType type) {
        super(name, type);
    }

    public Storage<Fact> getMemories() {
        return storage;
    }

    public void setMemories(Storage<Fact> memories) {
        this.storage = memories;
    }

}
