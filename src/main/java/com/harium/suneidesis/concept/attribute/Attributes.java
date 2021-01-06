package com.harium.suneidesis.concept.attribute;

import com.harium.suneidesis.concept.Action;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Place;
import com.harium.suneidesis.concept.numeral.Quantity;
import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.storage.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Attributes implements Repository<Concept> {

    public static final String ATTRIBUTE_ABILITIES = "abilities";
    public static final String ATTRIBUTE_PROPERTIES = "props";
    public static final String ATTRIBUTE_LOCATION = "location";
    public static final String ATTRIBUTE_NAME = "name";

    public static final Word UNKNOWN_WORD = new Word("");

    private Abilities abilities;
    private Properties properties;
    private Map<String, Concept> attributeMap = new HashMap<>();

    public Concept get(String key) {
        Concept concept = attributeMap.get(key);
        if (concept == null) {
            return Concept.UNKNOWN;
        }
        return concept;
    }

    @Override
    public Collection<Concept> getAll() {
        return attributeMap.values();
    }

    public void set(String key, Concept concept) {
        attributeMap.put(key, concept);
    }

    public Abilities getAbilities() {
        if (abilities == null) {
            abilities = new Abilities();
            attributeMap.put(ATTRIBUTE_ABILITIES, abilities);
        }
        return abilities;
    }

    public Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            attributeMap.put(ATTRIBUTE_PROPERTIES, properties);
        }
        return properties;
    }

    /**
     * Helper Methods
     */
    public String getNameWord() {
        return getName().getName();
    }

    public Word getName() {
        Concept name = attributeMap.get(ATTRIBUTE_NAME);
        if (name != null) {
            return (Word) name;
        }

        return UNKNOWN_WORD;
    }

    public void setName(String name) {
        Word nameWord = getOrCreateWord(name);
        setNameWord(nameWord);
    }

    public void setNameWord(Word name) {
        attributeMap.put(ATTRIBUTE_NAME, name);
    }

    private Word getOrCreateWord(String name) {
        return new Word(name);
    }

    public void is(Concept concept) {
        merge(concept.getAttributes());
    }

    private void merge(Attributes attributes) {
        for (Map.Entry<String, Concept> entry: attributes.attributeMap.entrySet()) {
            String key = entry.getKey();
            if (ATTRIBUTE_NAME.equals(key)) {
                continue;
            }
            if (ATTRIBUTE_PROPERTIES.equals(key)) {
                Properties properties = (Properties) entry.getValue();
                getProperties().merge(properties);
            } else if (ATTRIBUTE_ABILITIES.equals(key)) {
                Abilities abilities = (Abilities) entry.getValue();
                getAbilities().merge(abilities);
            } else {
                attributeMap.put(key, entry.getValue());
            }
        }
    }

    public void can(Action concept) {
        getAbilities().add(concept);
    }

    public void has(Concept part, Quantity quantity) {
        getProperties().add(part, quantity);
    }

    public void isLocatedAt(Place concept) {
        attributeMap.put(ATTRIBUTE_LOCATION, concept);
    }

    public Concept getProperty(String key) {
        return getProperties().query(key);
    }

    public boolean equals(Attributes attributes) {
        boolean equals = true;
        for (Map.Entry<String, Concept> entry: attributes.attributeMap.entrySet()) {
            String key = entry.getKey();
            if (ATTRIBUTE_NAME.equals(key)) {
                //equals &= getName().equals(attributes.getName());
                continue;
            }
            if (ATTRIBUTE_PROPERTIES.equals(key)) {
                equals &= propertiesEquals(attributes);
            } else if (ATTRIBUTE_ABILITIES.equals(key)) {
                equals &= abilitiesEquals(attributes);
            } else {
                Concept value = entry.getValue();
                Concept toCompare = attributes.get(key);
                equals &= value.equals(toCompare);
            }
        }

        return equals;
    }

    private boolean abilitiesEquals(Attributes attributes) {
        if (attributes.abilities == null) {
            return abilities == null;
        }
        return attributes.abilities.equals(abilities);
    }

    private boolean propertiesEquals(Attributes attributes) {
        if (attributes.properties == null) {
            return properties == null;
        }
        return attributes.properties.equals(properties);
    }
}
