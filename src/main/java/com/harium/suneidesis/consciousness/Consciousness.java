package com.harium.suneidesis.consciousness;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.knowledge.fact.Fact;
import com.harium.suneidesis.storage.MemoryRepository;
import com.harium.suneidesis.storage.Repository;

public class Consciousness extends Concept {

    protected Repository repository = new MemoryRepository();

    public Consciousness(String name, ConceptType type) {
        super(name, type);
    }

    public Repository<Fact> getMemories() {
        return repository;
    }

    public void setMemories(Repository<Fact> memories) {
        this.repository = memories;
    }

}
