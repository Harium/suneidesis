package com.harium.suneidesis.planning;

import com.harium.suneidesis.concept.Being;
import com.harium.suneidesis.concept.Concept;

public class Inventory extends Concept {

    private static final String ATTRIBUTE_OWNER = "owner";

    public Inventory() {
        super("inventory");
    }

    public void add(Concept concept) {
        set(concept.getName(), concept);
    }

    public Inventory owner(Being owner) {
        set(ATTRIBUTE_OWNER, owner);
        return this;
    }

    public Concept getOwner() {
        return get(ATTRIBUTE_OWNER);
    }
}
