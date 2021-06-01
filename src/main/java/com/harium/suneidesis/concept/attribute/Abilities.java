package com.harium.suneidesis.concept.attribute;

import com.harium.suneidesis.concept.Action;
import com.harium.suneidesis.concept.Concept;

public class Abilities extends Concept {

    public Abilities() {
        super(Attributes.ATTRIBUTE_ABILITIES);
    }

    public Abilities(String name) {
        super(name);
    }

    public void add(Action action) {
        has(action.getName(), action);
    }

    public boolean contains(String actionKey) {
        return getMap().values().stream().anyMatch(concept -> actionKey.equalsIgnoreCase(concept.getName()));
    }

    public boolean equals(Inheritance inheritance) {
        return getAttributes().equals(inheritance.getAttributes());
    }

    @Override
    public Abilities wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }

}
