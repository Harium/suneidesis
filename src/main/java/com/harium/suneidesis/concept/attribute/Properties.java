package com.harium.suneidesis.concept.attribute;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.numeral.Quantity;

import java.util.HashMap;
import java.util.Map;

import static com.harium.suneidesis.concept.numeral.Quantity.ZERO;

public class Properties extends Concept {

    private final Map<String, Concept> nameIndex = new HashMap<>();
    private final Map<Concept, Quantity> map = new HashMap<>();

    public void add(Concept property, Quantity quantity) {
        nameIndex.put(property.getName(), property);
        map.put(property, quantity);
    }

    public Quantity query(Concept part) {
        Quantity quantity = map.get(part);
        if (quantity == null) {
            quantity = ZERO;
        }
        return quantity;
    }

    public Quantity query(String name) {
        Concept key = nameIndex.get(name);
        if (key == null) {
           return ZERO;
        }

        return map.get(key);
    }

    public void merge(Properties properties) {
        for (Map.Entry<Concept, Quantity> entry : properties.map.entrySet()) {
            add(entry.getKey(), entry.getValue());
        }
    }

    public boolean equals(Properties properties) {
        boolean equals = true;
        for (Map.Entry<Concept, Quantity> entry : map.entrySet()) {
            Concept key = entry.getKey();
            Quantity q = entry.getValue();

            Concept concept = properties.nameIndex.get(key.getName());
            Quantity toCompare = properties.map.get(concept);

            equals &= q.getExpression().equals(toCompare.getExpression());
        }
        return equals;
    }
}
