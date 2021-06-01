package com.harium.suneidesis.concept.attribute;

import com.harium.suneidesis.concept.Concept;

import java.util.Map;

public class Inheritance extends Concept {

    public Inheritance() {
        super(Attributes.ATTRIBUTE_INHERITANCE);
    }

    public Inheritance(String name) {
        super(name);
    }

    public void add(Concept concept) {
        has(concept.getName(), concept);
    }

    public boolean queryIs(String key) {
        for (Map.Entry<String, Concept> entry : getMap().entrySet()) {
            if (entry.getKey().equals(key)) {
                return true;
            }
            // Recursive
            if (entry.getValue().getAttributes().queryIs(key)) {
                return true;
            }
        }
        return false;
    }

    public boolean can(String actionKey) {
        for (Concept concept : getMap().values()) {
            if (concept.getAttributes().can(actionKey)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Inheritance inheritance) {
        return getAttributes().equals(inheritance.getAttributes());
    }

    @Override
    public Inheritance wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
