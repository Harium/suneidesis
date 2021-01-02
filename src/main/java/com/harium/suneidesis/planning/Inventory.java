package com.harium.suneidesis.planning;

import com.harium.suneidesis.consciousness.Consciousness;
import com.harium.suneidesis.concept.Thing;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.storage.MemoryRepository;
import com.harium.suneidesis.storage.Repository;

import java.util.Collection;

public class Inventory extends Concept {

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

    // Private property
    // TODO Relax rules in case of emergency?
    public boolean canAccess(Consciousness subject) {
        return owner == subject;
    }
}
