package com.harium.suneidesis.concept.attribute;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.numeral.Measure;

import java.util.HashMap;
import java.util.Map;

import static com.harium.suneidesis.concept.numeral.Measure.ZERO;

public class Properties extends Concept {

    private final Map<String, Concept> nameIndex = new HashMap<>();
    private final Map<Concept, Measure> map = new HashMap<>();

    public void add(Concept property, Measure measure) {
        nameIndex.put(property.getName(), property);
        map.put(property, measure);
    }

    public Measure query(Concept part) {
        Measure measure = map.get(part);
        if (measure == null) {
            measure = ZERO;
        }
        return measure;
    }

    public Measure query(String name) {
        Concept key = nameIndex.get(name);
        if (key == null) {
           return ZERO;
        }

        return map.get(key);
    }

    public void merge(Properties properties) {
        for (Map.Entry<Concept, Measure> entry : properties.map.entrySet()) {
            add(entry.getKey(), entry.getValue());
        }
    }

    public boolean equals(Properties properties) {
        boolean equals = true;
        for (Map.Entry<Concept, Measure> entry : map.entrySet()) {
            Concept key = entry.getKey();
            Measure q = entry.getValue();

            Concept concept = properties.nameIndex.get(key.getName());
            Measure toCompare = properties.map.get(concept);

            boolean sameValue = q.getValueText().equals(toCompare.getValueText());
            boolean sameUnit = q.getUnitText().equals(toCompare.getUnitText());

            equals &= sameValue && sameUnit;
        }
        return equals;
    }
}
