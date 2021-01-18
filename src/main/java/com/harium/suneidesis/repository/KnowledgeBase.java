package com.harium.suneidesis.repository;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Fact;
import com.harium.suneidesis.concept.Time;
import com.harium.suneidesis.generator.BaseIdGenerator;
import com.harium.suneidesis.generator.BaseTimeGenerator;
import com.harium.suneidesis.generator.IdGenerator;
import com.harium.suneidesis.generator.TimeGenerator;

import java.util.ArrayList;
import java.util.List;

public abstract class KnowledgeBase implements Repository<Fact> {

    private static final String ATTRIBUTE_CREATED_AT = "created_at";

    private String name;

    private IdGenerator idGenerator = new BaseIdGenerator();

    private TimeGenerator timeGenerator = new BaseTimeGenerator();

    public KnowledgeBase(String name) {
        super();
        this.name = name;
    }

    public KnowledgeBase(IdGenerator idGenerator) {
        super();
        this.idGenerator = idGenerator;
    }

    public abstract void merge(KnowledgeBase facts);

    public List<Fact> query(Search search) {
        List<Fact> result = new ArrayList<>();
        for (Fact fact : getAll()) {
            // Search nested concepts
            for (Concept concept : fact.getAttributes().getAll()) {
                if (search.term.equals(concept.getName())) {
                    // Check permission
                    if (!concept.isSecret()) {
                        result.add(fact);
                    } else if (fact.getSourceId().getName().equals(search.userId)) {
                        result.add(fact);
                    }
                    break;
                }
            }
        }
        return result;
    }

    public String add(Concept concept) {
        String id = idGenerator.generateId();
        Fact wrap = wrap(concept);
        set(id, wrap);
        return id;
    }

    protected Fact wrap(Concept info) {
        Fact fact = new Fact();
        String when = timeGenerator.generateTime();
        Time time = new Time(when);
        fact.time(time);
        fact.subject(info);
        return fact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IdGenerator getIdGenerator() {
        return idGenerator;
    }

    public void setIdGenerator(IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }
}
