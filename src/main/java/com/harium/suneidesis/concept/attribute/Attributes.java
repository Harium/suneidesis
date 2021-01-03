package com.harium.suneidesis.concept.attribute;

import com.harium.suneidesis.concept.Action;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Place;
import com.harium.suneidesis.concept.numeral.Numeral;
import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.storage.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Attributes implements Repository<Concept> {

    public static final String ATTRIBUTE_ABILITIES = "abilities";
    public static final String ATTRIBUTE_PARTS = "parts";

    public static final String ATTRIBUTE_LOCATION = "location";
    public static final String ATTRIBUTE_NAME = "name";

    private Abilities abilities;
    private Properties properties;
    private Map<String, Concept> attributes = new HashMap<>();

    public Concept get(String key) {
        Concept concept = attributes.get(key);
        if (concept == null) {
            return Concept.UNKNOWN;
        }
        return concept;
    }

    @Override
    public Collection<Concept> getAll() {
        return attributes.values();
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

    public Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            attributes.put(ATTRIBUTE_PARTS, properties);
        }
        return properties;
    }

    /**
     * Helper Methods
     */
    public String getName() {
        return attributes.get(ATTRIBUTE_NAME).getName();
    }

    public void setName(String name) {
        Word nameWord = getOrCreateWord(name);
        attributes.put(ATTRIBUTE_NAME, nameWord);
    }

    private Word getOrCreateWord(String name) {
        return new Word(name);
    }

    public void can(Action concept) {
        getAbilities().add(concept);
    }

    public void has(Concept part, Numeral numeral) {
        getProperties().add(part, numeral);
    }

    public void isLocatedAt(Place concept) {
        attributes.put(ATTRIBUTE_LOCATION, concept);
    }

    public Concept getProperty(String key) {
        return getProperties().query(key);
    }
}
