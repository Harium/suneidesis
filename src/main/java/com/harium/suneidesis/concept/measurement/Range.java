package com.harium.suneidesis.concept.measurement;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Primitive;

public class Range extends Measurement {

    // Minimum level of measurement
    private static final String ATTRIBUTE_MIN = "min";
    // Maximum level of measurement
    private static final String ATTRIBUTE_MAX = "max";

    public Range() {
        super();
    }

    public Range(String name) {
        super(name);
    }

    public String getMin() {
        return getAttributes().get(ATTRIBUTE_MIN).getName();
    }

    public Concept getMinConcept() {
        return getAttributes().get(ATTRIBUTE_MIN);
    }

    public void setMin(String min) {
        this.getAttributes().save(ATTRIBUTE_MIN, new Primitive(min));
    }

    public Range min(String min) {
        setMin(min);
        return this;
    }

    public String getMax() {
        return getAttributes().get(ATTRIBUTE_MAX).getName();
    }

    public Concept getMaxConcept() {
        return getAttributes().get(ATTRIBUTE_MAX);
    }

    public void setMax(String min) {
        this.getAttributes().save(ATTRIBUTE_MAX, new Primitive(min));
    }

    public Range max(String max) {
        setMax(max);
        return this;
    }

}
