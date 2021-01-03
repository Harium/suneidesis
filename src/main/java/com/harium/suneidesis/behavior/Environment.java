package com.harium.suneidesis.behavior;

import com.harium.suneidesis.concept.Thing;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.storage.MemoryRepository;
import com.harium.suneidesis.storage.Repository;

import java.util.Collection;

public class Environment {

    Repository<Thing> concepts = new MemoryRepository<>();

    public String add(Concept concept) {
        String id = concept.getId();
        concepts.set(concept.getId(), concept);
        return id;
    }

    public Collection<Thing> getAll() {
        return concepts.getAll();
    }
}
