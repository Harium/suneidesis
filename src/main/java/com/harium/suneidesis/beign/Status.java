package com.harium.suneidesis.beign;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Status {

    public static final float MAX = 1.0f;
    public static final float MIN = 0f;
    public static final float NEUTRAL = (MAX - MIN) / 2;

    private Map<String, Float> attributes;
    private Map<String, Float> thresholds;

    public Status() {
        super();
        attributes = new HashMap<String, Float>();
        thresholds = new HashMap<String, Float>();
    }

    public void add(String attribute) {
        attributes.put(attribute, NEUTRAL);
    }

    public void add(String attribute, float value) {
        attributes.put(attribute, value);
    }

    public void add(String attribute, float value, float threshold) {
        attributes.put(attribute, value);
        thresholds.put(attribute, threshold);
    }

    public void addThreshold(String attribute, float threshold) {
        thresholds.put(attribute, threshold);
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

    public Collection<String> all() {
        return attributes.keySet();
    }

    public void increment(String attribute, float increment) {
        if (!attributes.containsKey(attribute)) {
            return;
        }
        float value = attributes.get(attribute) + increment;
        attributes.put(attribute, value);
    }
}
