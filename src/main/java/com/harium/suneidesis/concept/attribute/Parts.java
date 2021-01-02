package com.harium.suneidesis.concept.attribute;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.numeral.Amount;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.harium.suneidesis.concept.numeral.Amount.ZERO;

public class Parts extends Concept {

    private final Map<String, Concept> index = new HashMap<>();
    private final Map<Concept, Amount> map = new HashMap<>();


    public void add(Concept part, Amount numeral) {
        index.put(part.getName(), part);
        map.put(part, numeral);
    }

    public Amount query(Concept part) {
        Amount amount = map.get(part);
        if (amount == null) {
            amount = ZERO;
        }
        return amount;
    }

    public Amount query(String name) {
        Concept key = index.get(name);
        if (key == null) {
           return ZERO;
        }

        return map.get(key);
    }
}
