package com.harium.suneidesis.concept.attribute;

import com.harium.suneidesis.concept.Action;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.concept.Place;
import com.harium.suneidesis.concept.numeral.Amount;

import java.util.HashMap;
import java.util.Map;

public class Attributes {

    public static final String ATTRIBUTE_ABILITIES = "abilities";
    public static final String ATTRIBUTE_PARTS = "parts";

    public static final String ATTRIBUTE_LOCATION = "location";
    public static final String ATTRIBUTE_NAME = "name";

    private Abilities abilities;
    private Parts parts;
    private Map<String, Concept> attributes = new HashMap<>();

    public Concept get(String key) {
        Concept concept = attributes.get(key);
        if (concept == null) {
            return Concept.UNKNOWN;
        }
        return concept;
    }

    public void set(String key, Concept concept) {
        attributes.put(key, concept);
    }

    public Abilities getAbilities() {
        if (abilities == null) {
            abilities = new Abilities();
            attributes.put(ATTRIBUTE_ABILITIES, abilities);
        }
        return abilities;
    }

    public Parts getParts() {
        if (parts == null) {
            parts = new Parts();
            attributes.put(ATTRIBUTE_PARTS, parts);
        }
        return parts;
    }

    /**
     * Helper Methods
     */
    public String getName() {
        return attributes.get(ATTRIBUTE_NAME).getId();
    }

    public void setName(String name) {
        Concept concept = new Concept();
        // Hacky way to avoid buffer overflow
        concept.setId(name);
        concept.setType(ConceptType.NAME);
        attributes.put(ATTRIBUTE_NAME, concept);
    }

    public void can(Action concept) {
        getAbilities().add(concept);
    }

    public void has(Concept part, Amount amount) {
        getParts().add(part, amount);
    }

    public void isLocatedAt(Place concept) {
        attributes.put(ATTRIBUTE_LOCATION, concept);
    }

    public Concept getPart(String key) {
        return getParts().query(key);
    }
}
