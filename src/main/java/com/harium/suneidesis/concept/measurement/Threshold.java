package com.harium.suneidesis.concept.measurement;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Primitive;

import java.math.BigDecimal;

public class Threshold extends Range {

    // Threshold level of a need (if any)
    private static final String ATTRIBUTE_THRESHOLD = "threshold";

    public Threshold() {
        super();
    }

    public Threshold(String name) {
        super(name);
    }

    public String getThreshold() {
        return getAttributes().get(ATTRIBUTE_THRESHOLD).getName();
    }

    public Concept getThresholdConcept() {
        return getAttributes().get(ATTRIBUTE_THRESHOLD);
    }

    public BigDecimal getThresholdAsBigDecimal() {
        return asBigDecimal(getThreshold());
    }

    public void setThreshold(String threshold) {
        this.getAttributes().save(ATTRIBUTE_THRESHOLD, new Primitive(threshold));
    }

    public Threshold threshold(String value) {
        setThreshold(value);
        return this;
    }

    @Override
    public Threshold wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }

    public boolean isBelowThreshold() {
        BigDecimal value = getValueAsBigDecimal();
        BigDecimal threshold = getThresholdAsBigDecimal();

        return value != null && value.compareTo(threshold) < 0;
    }

    public boolean isAboveThreshold() {
        BigDecimal value = getValueAsBigDecimal();
        BigDecimal threshold = getThresholdAsBigDecimal();

        return value != null && value.compareTo(threshold) > 0;
    }
}
