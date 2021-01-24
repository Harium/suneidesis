package com.harium.suneidesis.repository;

import com.harium.suneidesis.concept.Fact;
import com.harium.suneidesis.generator.IdGenerator;

import java.util.HashMap;
import java.util.Map;

public class MemoryKnowledgeBase extends KnowledgeBase {

    private Map<String, Fact> data = new HashMap<>();

    public MemoryKnowledgeBase() {
        super();
    }

    public MemoryKnowledgeBase(String name) {
        super(name);
    }

    public MemoryKnowledgeBase(IdGenerator idGenerator) {
        super(idGenerator);
    }

    @Override
    public Map<String, Fact> getAll() {
        return data;
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
        for (Fact fact: facts.getValues()) {
            add(fact);
        }
    }
}
