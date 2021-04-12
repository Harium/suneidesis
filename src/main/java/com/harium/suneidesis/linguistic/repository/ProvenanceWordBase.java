package com.harium.suneidesis.linguistic.repository;

import com.harium.suneidesis.concept.Action;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Provenance;
import com.harium.suneidesis.repository.decorator.EntryDecorator;

public class ProvenanceWordBase extends MemoryWordBase implements WordRepository {

    public static final Concept MEDIUM_TEXT = new Concept("dictionary");
    public static final Action METHOD_INPUT = new Action("input");

    public ProvenanceWordBase(String name) {
        super(name);
        init();
    }

    private void init() {
        MEDIUM_TEXT.id(getIdGenerator().generateId());
        add(MEDIUM_TEXT);
        METHOD_INPUT.id(getIdGenerator().generateId());
        add(METHOD_INPUT);
    }

    @Override
    protected void initDecorators() {
        super.initDecorators();
        decorators.add(new TextProvenanceDecorator());
    }

    static class TextProvenanceDecorator implements EntryDecorator {
        @Override
        public void decorate(Concept concept) {
            concept.set(Provenance.ATTRIBUTE_ACQUISITION_MEDIUM, MEDIUM_TEXT);
            concept.set(Provenance.ATTRIBUTE_ACQUISITION_METHOD, METHOD_INPUT);
        }
    }

}
