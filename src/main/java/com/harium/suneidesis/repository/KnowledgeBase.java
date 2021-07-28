package com.harium.suneidesis.repository;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.repository.decorator.EntryDecorator;
import com.harium.suneidesis.repository.generator.BaseIdGenerator;
import com.harium.suneidesis.repository.generator.IdGenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class KnowledgeBase implements KnowledgeBaseRepository<Concept> {

    // Reserved word for introspection
    public static final String SELF = "_self";

    private String name;

    private IdGenerator idGenerator;

    protected List<EntryDecorator> decorators = new ArrayList<>();

    public KnowledgeBase() {
        super();
        initGenerators();
    }

    public KnowledgeBase(String name) {
        super();
        this.name = name;
        initGenerators();
    }

    public KnowledgeBase(IdGenerator idGenerator) {
        super();
        this.idGenerator = idGenerator;
    }

    public void initGenerators() {
        idGenerator = new BaseIdGenerator();
    }

    public abstract Concept add(String key, Concept concept);

    @Override
    public String add(Concept concept) {
        Concept id = concept.getIdConcept();
        String idText;
        if (id.isUnknown()) {
            idText = idGenerator.generateId(concept);
        } else {
            idText = id.getId();
        }

        decorate(concept);

        add(idText, concept);
        return idText;
    }

    public void merge(KnowledgeBase knowledgeBase) {
        Iterator<Concept> iterator = knowledgeBase.iterator();
        while (iterator.hasNext()) {
            Concept concept = iterator.next();
            add(concept.getId(), concept);
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
