package com.harium.suneidesis.repository;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.repository.decorator.EntryDecorator;
import com.harium.suneidesis.repository.decorator.TimeDecorator;
import com.harium.suneidesis.repository.generator.BaseIdGenerator;
import com.harium.suneidesis.repository.generator.BaseTimeGenerator;
import com.harium.suneidesis.repository.generator.IdGenerator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

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

    protected void initDecorators() {
        decorators.add(new TimeDecorator(new BaseTimeGenerator()));
    }

    @Override
    public Iterator<Concept> iterator() {
        return getAll().values().iterator();
    }

    public abstract String add(Concept concept);

    public abstract void merge(KnowledgeBase concepts);

    public void addAll(Collection<Concept> concepts) {
        for (Concept concept : concepts) {
            add(concept);
        }
    }

    protected Concept decorate(Concept info) {
        for (EntryDecorator decorator : decorators) {
            decorator.decorate(info);
        }
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
