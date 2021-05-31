package com.harium.suneidesis.concept;

/**
 * Meta class that describes a concept
 */
public class Meaning extends Concept {

    public Meaning() {
        super(ConceptType.MEANING);
    }

    public Meaning(String name) {
        super(name, ConceptType.MEANING);
    }

    @Override
    public Meaning wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
