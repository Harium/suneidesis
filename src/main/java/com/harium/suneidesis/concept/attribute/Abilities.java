package com.harium.suneidesis.concept.attribute;

import com.harium.suneidesis.concept.Action;
import com.harium.suneidesis.concept.Concept;

import java.util.HashMap;
import java.util.Map;

public class Abilities extends Concept {

    private final Map<String, Action> map = new HashMap<>();

    public Abilities(String name) {
        super(name);
    }

    public void add(Action action) {
        map.put(action.getName(), action);
    }

    public boolean query(Action action) {
        return map.containsKey(action.getName());
    }

    public boolean query(String name) {
        return map.values().stream().anyMatch(concept -> name.equalsIgnoreCase(concept.getName()));
    }

    public void merge(Abilities abilities) {
        map.putAll(abilities.map);
    }

    public boolean equals(Abilities abilities) {
        boolean equals = true;
        for (Action action : map.values()) {
            equals &= abilities.query(action.getName());
        }
        return equals;
    }
}
