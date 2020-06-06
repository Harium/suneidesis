package com.harium.suneidesis.planning;

import com.harium.suneidesis.knowledge.Thing;
import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.storage.MemoryRepository;
import com.harium.suneidesis.storage.Repository;

import java.util.Collection;

public class Storage extends Concept {

    private Concept owner;

    private Repository<Thing> items = new MemoryRepository<>();

    public void add(Concept concept) {
        items.add(concept);
    }

    public Collection<Thing> getAll() {
        return items.getAll();
    }

    public Concept getOwner() {
        return owner;
    }

    public void setOwner(Concept owner) {
        this.owner = owner;
    }

}
