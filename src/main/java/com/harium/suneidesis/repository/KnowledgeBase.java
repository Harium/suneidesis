package com.harium.suneidesis.repository;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Time;
import com.harium.suneidesis.generator.BaseIdGenerator;
import com.harium.suneidesis.generator.BaseTimeGenerator;
import com.harium.suneidesis.generator.IdGenerator;
import com.harium.suneidesis.generator.TimeGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public abstract class KnowledgeBase implements Repository<Concept> {

    private static final String ATTRIBUTE_CREATED_AT = "created_at";

    private String name;

    private IdGenerator idGenerator = new BaseIdGenerator();

    private TimeGenerator timeGenerator = new BaseTimeGenerator();

    public KnowledgeBase() {
        super();
    }

    public KnowledgeBase(String name) {
        super();
        this.name = name;
    }

    public KnowledgeBase(IdGenerator idGenerator) {
        super();
        this.idGenerator = idGenerator;
    }

    @Override
    public Collection<Concept> getValues() {
        return getAll().values();
    }

    public abstract void merge(KnowledgeBase facts);

    public List<Concept> query(Search search) {
        List<Concept> result = new ArrayList<>();
        for (Concept concept : getValues()) {
            // Search nested concepts
            if (search.term.equals(concept.getName())) {
                // Check permission
                if (!concept.isSecret()) {
                    result.add(concept);
                } /*else if (concept.getSourceId().getName().equals(search.userId)) {
                    result.add(concept);
                }*/
                break;
            }
        }
        return result;
    }

    public String add(Concept concept) {
        String id = concept.getId().getName();
        if (contains(concept.getId().getName())) {
            return id;
        }
        id = idGenerator.generateId();
        Concept wrap = wrap(concept);
        set(id, wrap);

        for (Map.Entry<String, Concept> entry : concept.getAttributes().entrySet()) {
            if (ATTRIBUTE_CREATED_AT.equals(entry.getKey())) {
                continue;
            }
            add(entry.getValue());
        }

        return id;
    }

    protected Concept wrap(Concept info) {
        String when = timeGenerator.generateTime();
        Time time = new Time(when);
        info.set(ATTRIBUTE_CREATED_AT, time);

        return info;
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
