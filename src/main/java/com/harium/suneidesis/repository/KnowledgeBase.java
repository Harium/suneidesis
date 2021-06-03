package com.harium.suneidesis.repository;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.repository.decorator.EntryDecorator;
import com.harium.suneidesis.repository.generator.BaseIdGenerator;
import com.harium.suneidesis.repository.generator.IdGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class KnowledgeBase implements Repository<Concept> {

    // Reserved word for introspection
    public static final String SELF = "self";

    private String name;

    protected IdGenerator idGenerator = new BaseIdGenerator();

    protected List<EntryDecorator> decorators = new ArrayList<>();

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

    public abstract String add(Concept concept);

    public void merge(KnowledgeBase concepts) {
        Map<String, Concept> map = concepts.getAll();
        for (Map.Entry<String, Concept> entry : map.entrySet()) {
            add(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public Iterator<Concept> iterator() {
        return getAll().values().iterator();
    }

    protected Concept decorate(Concept concept) {
        for (EntryDecorator decorator : decorators) {
            decorator.decorate(concept);
        }
        return concept;
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
