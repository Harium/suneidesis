package com.harium.suneidesis.concept.attribute;

import com.harium.suneidesis.concept.*;
import com.harium.suneidesis.concept.Measurement;
import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.repository.Repository;
import com.harium.suneidesis.repository.RepositoryCursor;
import org.apache.commons.lang3.NotImplementedException;
import org.dizitart.no2.Filter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Attributes implements Repository<Concept> {

    public static final String ATTRIBUTE_NAME = "name";
    public static final String ATTRIBUTE_DATA_TYPE = "dataType";

    public static final String ATTRIBUTE_ABILITIES = "abilities";
    public static final String ATTRIBUTE_PROPERTIES = "props";
    public static final String ATTRIBUTE_INHERITANCE = "inheritance";
    public static final String ATTRIBUTE_LOCATION = "location";

    private String name = "";
    private DataType dataType = DataType.OBJECT;

    // What the concept *can* do
    private Abilities abilities;
    // What the concept *has*
    private Properties properties;
    // Primitive concepts that this concept *is* derived from
    private Inheritance inheritance;
    // How the concept is defined
    private final Map<String, Concept> attributeMap = new HashMap<>();

    public Concept get(String key) {
        Concept concept = attributeMap.get(key);
        if (concept != null) {
            return concept;
        } else if (inheritance == null) {
            return ConceptType.UNKNOWN;
        }

        return getInheritance().get(key);
    }

    public boolean contains(String key) {
        if (inheritance != null) {
            for (Concept concept : getInheritance().getMap().values()) {
                if (concept.hasKey(key)) {
                    return true;
                }
            }
        }

        return !get(key).isUnknown();
    }

    @Override
    public void clear() {
        attributeMap.clear();
        properties.getAttributes().clear();
        abilities.getAttributes().clear();
        inheritance.getAttributes().clear();
    }

    @Override
    public void close() {

    }

    @Override
    public boolean isClosed() {
        return false;
    }

    public boolean queryIs(String key) {
        return getInheritance().queryIs(key);
    }

    @Override
    public Map<String, Concept> getAll() {
        return attributeMap;
    }

    @Override
    public Iterator<Concept> iterator() {
        return attributeMap.values().iterator();
    }

    public Concept add(String key, Concept concept) {
        return attributeMap.put(key, concept);
    }

    @Override
    public String add(Concept concept) {
        String id = concept.getId();
        add(id, concept);
        return id;
    }

    public boolean remove(Concept concept) {
        return attributeMap.values().remove(concept);
    }

    public boolean removeByName(String key) {
        for (Iterator<Concept> iterator = attributeMap.values().iterator(); iterator.hasNext(); ) {
            Concept concept = iterator.next();
            if (key.equals(concept.getName())) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public Concept removeAttribute(String key) {
        return attributeMap.remove(key);
    }

    public Abilities getAbilities() {
        if (abilities == null) {
            abilities = new Abilities(ATTRIBUTE_ABILITIES);
            attributeMap.put(ATTRIBUTE_ABILITIES, abilities);
        }
        return abilities;
    }

    public Properties getProperties() {
        if (properties == null) {
            properties = new Properties(ATTRIBUTE_PROPERTIES);
            attributeMap.put(ATTRIBUTE_PROPERTIES, properties);
        }
        return properties;
    }

    public Inheritance getInheritance() {
        if (inheritance == null) {
            inheritance = new Inheritance(ATTRIBUTE_INHERITANCE);
            attributeMap.put(ATTRIBUTE_INHERITANCE, inheritance);
        }
        return inheritance;
    }

    /**
     * Helper Methods
     */
    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public String getName() {
        return name;
    }

    public Concept getNameConcept() {
        return new Word(name);
    }

    public void setName(String name) {
        this.name = name;
    }

    // Assign a super class
    public void is(Concept concept) {
        getInheritance().add(concept);

        // TODO Optimize super classes (if a super class has the same inheritance, it can be removed)

        // For each attribute
        for (Map.Entry<String, Concept> entry : attributeMap.entrySet()) {
            String key = entry.getKey();
            Concept c = entry.getValue();

            // If both attributes and super class' attributes has the same concept, remove the concept from map
            if (c.equals(concept.getAttributes().get(key))) {
                attributeMap.remove(key);
            }
        }
    }

    public void merge(Attributes attr) {
        for (Map.Entry<String, Concept> entry : attr.attributeMap.entrySet()) {
            String key = entry.getKey();
            if (ATTRIBUTE_NAME.equals(key)) {
                continue;
            }
            if (ATTRIBUTE_PROPERTIES.equals(key)) {
                Properties properties = (Properties) entry.getValue();
                getProperties().merge(properties);
            } else if (ATTRIBUTE_ABILITIES.equals(key)) {
                Abilities abilities = (Abilities) entry.getValue();
                getAbilities().getAttributes().merge(abilities.getAttributes());
            } else if (ATTRIBUTE_INHERITANCE.equals(key)) {
                Inheritance inheritance = (Inheritance) entry.getValue();
                getInheritance().getAttributes().merge(inheritance.getAttributes());
            } else {
                attributeMap.put(key, entry.getValue());
            }
        }
    }

    public void can(Action concept) {
        getAbilities().add(concept);
    }

    public boolean can(String actionKey) {
        if (getAbilities().contains(actionKey)) {
            return true;
        }

        return getInheritance().can(actionKey);
    }

    public void hasPart(Concept part, Measurement measurement) {
        getProperties().add(part, measurement);
    }

    public void isLocatedAt(Place concept) {
        attributeMap.put(ATTRIBUTE_LOCATION, concept);
    }

    public Concept getProperty(String key) {
        return getProperties().query(key);
    }

    public boolean equals(Attributes attributes) {
        // Skip name from root
        return equals(this, attributes, false);
    }

    private static boolean equals(Attributes a, Attributes b, boolean checkName) {
        boolean equals = true;

        if (checkName && a.getName() != null && !a.getName().equals(b.getName())) {
            return false;
        }

        for (Map.Entry<String, Concept> entry: b.attributeMap.entrySet()) {
            String key = entry.getKey();
            if (ATTRIBUTE_PROPERTIES.equals(key)) {
                equals &= propertiesEquals(a.properties, b.properties);
            } else if (ATTRIBUTE_ABILITIES.equals(key)) {
                equals &= abilitiesEquals(a.abilities, b.abilities);
            } else if (ATTRIBUTE_INHERITANCE.equals(key)) {
                equals &= inheritanceEquals(a.inheritance, b.inheritance);
            } else {
                Concept value = entry.getValue();
                Concept toCompare = a.get(key);
                if (value.isPrimitive() && toCompare.isPrimitive()) {
                    equals &= value.getName().equals(toCompare.getName());
                } else if (!value.isPrimitive() && !toCompare.isPrimitive()) {
                    equals &= equals(value.getAttributes(), toCompare.getAttributes(), true);
                } else {
                    return false;
                }
            }
        }

        return equals;
    }

    private static boolean abilitiesEquals(Abilities a, Abilities b) {
        if (a == null) {
            return b == null;
        }
        return a.equals(b);
    }

    private static boolean propertiesEquals(Properties a, Properties b) {
        if (a == null) {
            return b == null;
        }
        return a.equals(b);
    }

    private static boolean inheritanceEquals(Inheritance a, Inheritance b) {
        if (a == null) {
            return b == null;
        }
        return a.equals(b);
    }

    public Set<Map.Entry<String, Concept>> entrySet() {
        return attributeMap.entrySet();
    }

}
