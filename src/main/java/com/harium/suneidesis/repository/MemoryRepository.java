package com.harium.suneidesis.repository;

import com.harium.suneidesis.concept.Fact;
import com.harium.suneidesis.generator.IdGenerator;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemoryRepository extends KnowledgeBase {

    private Map<String, Fact> data = new HashMap<>();

    public MemoryRepository(String name) {
        super(name);
    }

    public MemoryRepository(IdGenerator idGenerator) {
        super(idGenerator);
    }

    @Override
    public Collection<Fact> getAll() {
        return data.values();
    }

    @Override
    public void set(String key, Fact fact) {
        data.put(key, fact);
    }

    @Override
    public Fact get(String key) {
        return data.get(key);
    }

    @Override
    public void merge(KnowledgeBase facts) {
        // TODO Wrap facts in facts
        // Fact -> merged from another base -> Real Fact = the real information
        for (Fact fact: facts.getAll()) {
            add(fact);
        }
    }
}
