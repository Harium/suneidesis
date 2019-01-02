package com.harium.suneidesis.consciousness;

import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.concept.ConceptType;
import com.harium.suneidesis.knowledge.storage.Fact;
import com.harium.suneidesis.knowledge.storage.Storage;

import java.util.List;

public class Consciousness extends Concept {

    protected Storage storage = new Storage();

    public Consciousness(String name, ConceptType type) {
        super(name, type);
    }

    public List<Fact> getMemories() {
        return storage.getFacts();
    }

    public void setMemories(List<Fact> memories) {
        this.storage.setFacts(memories);
    }

}
