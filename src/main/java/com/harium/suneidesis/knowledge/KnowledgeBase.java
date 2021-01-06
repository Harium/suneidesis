package com.harium.suneidesis.knowledge;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Fact;
import com.harium.suneidesis.storage.MemoryRepository;
import com.harium.suneidesis.storage.Repository;

import java.util.ArrayList;
import java.util.List;

public class KnowledgeBase extends Concept {

    private Repository<Fact> facts = new MemoryRepository<>();

    public KnowledgeBase(String name) {
        super(name);
    }

    public void setFacts(Repository<Fact> facts) {
        this.facts = facts;
    }

    public List<Fact> query(String term) {
        List<Fact> result = new ArrayList<>();
        for (Fact fact : facts.getAll()) {
            for (Concept concept : fact.getAttributes().getAll()) {
                if (term.equals(concept.getName())) {
                    result.add(fact);
                    break;
                }
            }
        }
        return result;
    }
}
