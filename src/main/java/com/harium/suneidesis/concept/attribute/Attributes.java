package com.harium.suneidesis.concept.attribute;

import com.harium.suneidesis.concept.*;
import com.harium.suneidesis.concept.numeral.Measure;
import com.harium.suneidesis.concept.primitive.Text;
import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.repository.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Attributes implements Repository<Concept> {

    public static final String ATTRIBUTE_ABILITIES = "abilities";
    public static final String ATTRIBUTE_PROPERTIES = "props";
    public static final String ATTRIBUTE_LOCATION = "location";
    public static final String ATTRIBUTE_NAME = "name";
    public static final String ATTRIBUTE_DATA_TYPE = "dataType";

    public static final Text UNKNOWN_WORD = new Text("?");

    private DataType dataType = DataType.OBJECT;
    private String value;

    private Abilities abilities;
    private Properties properties;
    private final Map<String, Concept> attributeMap = new HashMap<>();

    public Concept get(String key) {
        Concept concept = attributeMap.get(key);
        if (concept == null) {
            return Concept.UNKNOWN;
        }
        return concept;
    }

    public boolean contains(String key) {
        return attributeMap.containsKey(key);
    }

    @Override
    public Map<String, Concept> getAll() {
        return attributeMap;
    }

    @Override
    public Collection<Concept> getValues() {
        return attributeMap.values();
    }

    public void insert(String key, Concept concept) {
        attributeMap.put(key, concept);
    }

    public void remove(Concept concept) {
        attributeMap.values().remove(concept);
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
    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public String getValueContent() {
        if (DataType.PRIMITIVE.equals(getDataType())) {
            return value;
        } else {
            return getValue().getName();
        }
    }

    public Text getValue() {
        if (DataType.PRIMITIVE.equals(getDataType())) {
            return new Text(value);
        } else {
            Concept value = attributeMap.get(ATTRIBUTE_NAME);
            if (value != null) {
                return (Text) value;
            }
        }
        return UNKNOWN_WORD;
    }

    public void setValue(String value) {
        if (DataType.PRIMITIVE.equals(getDataType())) {
            this.value = value;
        } else {
            Text nameWord = getOrCreateWord(value);
            setNameConcept(nameWord);
        }
    }

    public void setNameConcept(Concept name) {
        attributeMap.put(ATTRIBUTE_NAME, name);
    }

    private Text getOrCreateWord(String name) {
        return new Text(name);
    }

    public void is(Concept concept) {
        merge(concept.getAttributes());
    }

    public void merge(Attributes attributes) {
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

    public void hasPart(Concept part, Measure measure) {
        getProperties().add(part, measure);
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
        for (Map.Entry<String, Concept> entry: b.attributeMap.entrySet()) {
            String key = entry.getKey();
            if (checkName && ATTRIBUTE_NAME.equals(key)) {
                equals &= b.getValue().equals(a.getValue());
                continue;
            }
            if (ATTRIBUTE_PROPERTIES.equals(key)) {
                equals &= propertiesEquals(a.properties, b.properties);
            } else if (ATTRIBUTE_ABILITIES.equals(key)) {
                equals &= abilitiesEquals(a.abilities, b.abilities);
            } else {
                Concept value = entry.getValue();
                Concept toCompare = a.get(key);
                equals &= equals(value.getAttributes(), toCompare.getAttributes(), true);
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

    public Set<Map.Entry<String, Concept>> entrySet() {
        return attributeMap.entrySet();
    }

}
