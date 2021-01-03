package com.harium.suneidesis.concept.attribute;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.numeral.Numeral;

import java.util.HashMap;
import java.util.Map;

import static com.harium.suneidesis.concept.numeral.Numeral.ZERO;

public class Properties extends Concept {

    private final Map<String, Concept> index = new HashMap<>();
    private final Map<Concept, Numeral> map = new HashMap<>();

    public void add(Concept property, Numeral numeral) {
        index.put(property.getName(), property);
        map.put(property, numeral);
    }

    public Numeral query(Concept part) {
        Numeral numeral = map.get(part);
        if (numeral == null) {
            numeral = ZERO;
        }
        return numeral;
    }

    public Numeral query(String name) {
        Concept key = index.get(name);
        if (key == null) {
           return ZERO;
        }

        return map.get(key);
    }
}
