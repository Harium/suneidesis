package com.harium.suneidesis.knowledge.beign;

import java.util.HashMap;
import java.util.Map;

public class Status {

    public static final float MAX = 1.0f;
    public static final float MIN = 0f;
    public static final float NEUTRAL = (MAX - MIN) / 2;

    private Map<String, Float> attributes;

    public Status() {
        super();
        attributes = new HashMap<String, Float>();
    }

    public void add(String attribute) {
        attributes.put(attribute, MAX);
    }

    public void add(String attribute, float value) {
        attributes.put(attribute, value);
    }

    public float get(String attribute) {
        if (attributes.containsKey(attribute)) {
            return attributes.get(attribute);
        }
        return MIN;
    }

    public boolean has(String attribute) {
        return attributes.containsKey(attribute);
    }

}
