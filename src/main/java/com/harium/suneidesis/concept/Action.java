package com.harium.suneidesis.concept;

public class Action extends Concept {

    public Action(String name) {
        super(name, ConceptType.ACTION);
    }

    @Override
    public Action wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
