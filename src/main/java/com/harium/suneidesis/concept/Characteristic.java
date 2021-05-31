package com.harium.suneidesis.concept;

public class Characteristic extends Concept {

    public Characteristic(String name) {
        super(name, ConceptType.CHARACTERISTIC);
    }

    @Override
    public Characteristic wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
