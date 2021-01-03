package com.harium.suneidesis.concept.attribute;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.numeral.Quantity;

import java.util.HashMap;
import java.util.Map;

import static com.harium.suneidesis.concept.numeral.Quantity.ZERO;

public class Properties extends Concept {

    private final Map<String, Concept> index = new HashMap<>();
    private final Map<Concept, Quantity> map = new HashMap<>();

    public void add(Concept property, Quantity quantity) {
        index.put(property.getName(), property);
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
        Concept key = index.get(name);
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
}
