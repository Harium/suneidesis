package com.harium.suneidesis.concept.attribute;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.measurement.Measurement;

import java.util.HashMap;
import java.util.Map;

import static com.harium.suneidesis.concept.measurement.Measurement.ZERO;

public class Properties extends Concept {

    private final Map<String, Concept> map = new HashMap<>();
    private final Map<Concept, Measurement> quantities = new HashMap<>();

    public Properties(String name) {
        super(name);
    }

    public void add(Concept property, Measurement measurement) {
        map.put(property.getName(), property);
        quantities.put(property, measurement);
    }

    public Measurement query(Concept part) {
        Measurement measurement = quantities.get(part);
        if (measurement == null) {
            measurement = ZERO;
        }
        return measurement;
    }

    public Measurement query(String name) {
        Concept key = map.get(name);
        if (key == null) {
           return ZERO;
        }

        return quantities.get(key);
    }

    public void merge(Properties properties) {
        for (Map.Entry<Concept, Measurement> entry : properties.quantities.entrySet()) {
            add(entry.getKey(), entry.getValue());
        }
    }

    public boolean equals(Properties properties) {
        boolean equals = true;
        for (Map.Entry<Concept, Measurement> entry : quantities.entrySet()) {
            Concept key = entry.getKey();
            Measurement q = entry.getValue();

            Concept concept = properties.map.get(key.getName());
            Measurement toCompare = properties.quantities.get(concept);

            equals &= q.equals(toCompare);
        }
        return equals;
    }
}
