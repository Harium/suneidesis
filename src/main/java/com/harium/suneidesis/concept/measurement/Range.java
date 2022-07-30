package com.harium.suneidesis.concept.measurement;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Primitive;

import java.math.BigDecimal;

/**
 * Range of min and max value inclusive
 */
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

    public BigDecimal getMinAsBigDecimal() {
        return asBigDecimal(getMin());
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

    public BigDecimal getMaxAsBigDecimal() {
        return asBigDecimal(getMax());
    }

    public void setMax(String min) {
        this.getAttributes().save(ATTRIBUTE_MAX, new Primitive(min));
    }

    public Range max(String max) {
        setMax(max);
        return this;
    }

    public boolean isInsideRange() {
        BigDecimal value = getValueAsBigDecimal();
        BigDecimal min = getMinAsBigDecimal();
        BigDecimal max = getMaxAsBigDecimal();

        return value != null && value.compareTo(min) >= 0 && value.compareTo(max) <= 0;
    }

    @Override
    public Range wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
