package com.harium.suneidesis.concept.attribute;

import com.harium.suneidesis.concept.Concept;

import java.util.HashMap;
import java.util.Map;

public class Inheritance extends Concept {

    private final Map<String, Concept> map = new HashMap<>();

    public void add(Concept concept) {
        map.put(concept.getName(), concept);
    }

    public boolean query(Concept concept) {
        return map.containsKey(concept.getName());
    }

    public boolean query(String name) {
        return map.values().stream().anyMatch(concept -> name.equalsIgnoreCase(concept.getName()));
    }

    public boolean queryIs(String key) {
        for (Map.Entry<String, Concept> entry : map.entrySet()) {
            if (key.equals(entry.getKey())) {
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
        for (Concept is : map.values()) {
            if (is.getAttributes().getAbilities().query(actionKey)) {
                return true;
            }
        }

        return false;
    }

    public void merge(Inheritance inheritance) {
        map.putAll(inheritance.map);
    }

    public boolean equals(Inheritance inheritance) {
        boolean equals = true;
        for (Concept concept : map.values()) {
            equals &= inheritance.query(concept.getName());
        }
        return equals;
    }

    public Concept getKey(String key) {
        // Check super classes
        for (Concept is : map.values()) {
            Concept concept = is.getAttributes().get(key);
            if (concept != null) {
                return concept;
            }
        }
        return Concept.UNKNOWN;
    }

    public Map<String, Concept> getMap() {
        return map;
    }
}
