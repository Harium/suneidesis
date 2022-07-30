package com.harium.suneidesis.concept.measurement;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.concept.Primitive;
import com.harium.suneidesis.concept.Unit;
import com.harium.suneidesis.concept.helper.MeasureMatcher;

import java.math.BigDecimal;

public class Measurement extends Concept {

    private static final String ATTRIBUTE_ACCURACY = "accuracy";
    private static final String ATTRIBUTE_UNIT = "unit";
    private static final String ATTRIBUTE_VALUE = "value";

    public static final String VALUE_UNKNOWN = "";
    public static final Unit DEFAULT_UNIT = new Unit("unit", "u");
    public static final Measurement ZERO = new Measurement("0", DEFAULT_UNIT);

    public Measurement() {
        super(ConceptType.MEASUREMENT);
    }

    public Measurement(Concept unit) {
        super(ConceptType.MEASUREMENT);
        unit(unit);
    }

    public Measurement(String name) {
        super(name, ConceptType.MEASUREMENT);
    }

    /**
     * Convenient constructor that receives value and unit
     *
     * @param value
     * @param unit
     */
    public Measurement(String value, Concept unit) {
        super(ConceptType.MEASUREMENT);
        value(value);
        unit(unit);
    }

    /**
     * Convenient constructor that receives value and unit
     *
     * @param value
     * @param unit
     */
    public Measurement(String value, String unit) {
        super(ConceptType.MEASUREMENT);
        value(value);
        unit(unit);
    }

    public Measurement(String value, String unit, String name) {
        super(name, ConceptType.MEASUREMENT);
        value(value);
        unit(unit);
    }

    public Concept getValueConcept() {
        return getAttributes().get(ATTRIBUTE_VALUE);
    }

    public String getValue() {
        Concept value = getAttributes().get(ATTRIBUTE_VALUE);
        if (value.isUnknown()) {
            return VALUE_UNKNOWN;
        }
        return value.getValue();
    }

    public BigDecimal getValueAsBigDecimal() {
        return asBigDecimal(getValue());
    }

    public Measurement value(String value) {
        getAttributes().save(ATTRIBUTE_VALUE, new Primitive(value));
        return this;
    }

    public Concept getUnitConcept() {
        return getAttributes().get(ATTRIBUTE_UNIT);
    }

    public String getUnit() {
        return getUnitConcept().getName();
    }

    public Measurement unit(Concept unit) {
        getAttributes().save(ATTRIBUTE_UNIT, unit);
        return this;
    }

    public Measurement unit(String unit) {
        return unit(new Unit(unit));
    }

    public Measurement accuracy(String accuracy) {
        getAttributes().save(ATTRIBUTE_ACCURACY, new Concept(accuracy));
        return this;
    }

    protected BigDecimal asBigDecimal(String value) {
        if (VALUE_UNKNOWN.equals(value)) {
            return null;
        }

        return new BigDecimal(value);
    }

    public boolean matches(MeasureMatcher matcher) {
        return matcher.evaluate(getValue());
    }

    public boolean equals(Measurement q) {
        if (q == null) {
            return false;
        }
        boolean sameValue = q.getValue().equals(getValue());
        boolean sameUnit = q.getUnit().equals(getUnit());

        return sameValue && sameUnit;
    }

    public Measurement increment(double increment) {
        BigDecimal decimal = getValueAsBigDecimal();
        String value = decimal.add(BigDecimal.valueOf(increment)).toPlainString();
        value(value);

        return this;
    }
}
