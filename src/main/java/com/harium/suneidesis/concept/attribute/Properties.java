package com.harium.suneidesis.concept.attribute;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Measurement;

import java.util.HashMap;
import java.util.Map;

import static com.harium.suneidesis.concept.Measurement.ZERO;

public class Properties extends Concept {

    private final Map<String, Concept> nameIndex = new HashMap<>();
    private final Map<Concept, Measurement> map = new HashMap<>();

    public void add(Concept property, Measurement measurement) {
        nameIndex.put(property.getName(), property);
        map.put(property, measurement);
    }

    public Measurement query(Concept part) {
        Measurement measurement = map.get(part);
        if (measurement == null) {
            measurement = ZERO;
        }
        return measurement;
    }

    public Measurement query(String name) {
        Concept key = nameIndex.get(name);
        if (key == null) {
           return ZERO;
        }

        return map.get(key);
    }

    public void merge(Properties properties) {
        for (Map.Entry<Concept, Measurement> entry : properties.map.entrySet()) {
            add(entry.getKey(), entry.getValue());
        }
    }

    public boolean equals(Properties properties) {
        boolean equals = true;
        for (Map.Entry<Concept, Measurement> entry : map.entrySet()) {
            Concept key = entry.getKey();
            Measurement q = entry.getValue();

            Concept concept = properties.nameIndex.get(key.getName());
            Measurement toCompare = properties.map.get(concept);

            equals &= q.equals(toCompare);
        }
        return equals;
    }
}
