package com.harium.suneidesis.concept.numeral;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;

public class Measure extends Concept {

    private static final String ATTRIBUTE_UNIT = "unit";
    private static final String ATTRIBUTE_VALUE = "value";
    private static final String ATTRIBUTE_ACCURACY = "accuracy";
    private static final String ATTRIBUTE_MODIFIER = "modifier";

    private static final String MODIFIER_NO = "no";

    public static final Measure ZERO = new Measure("0", "u").modifier(MODIFIER_NO);

    /**
     * This constructor uses value instead of name in purpose
     * @param value - the value in unknown units
     */
    public Measure(String value) {
        super(ConceptType.MEASURE);
        value(value);
    }

    public Measure(String value, String unit) {
        super(ConceptType.MEASURE);
        value(value);
        unit(unit);
    }

    public Measure(String value, String unit, String name) {
        super(name, ConceptType.MEASURE);
        value(value);
        unit(unit);
    }

    public Concept getValue() {
        return attributes.get(ATTRIBUTE_VALUE);
    }

    public String getValueText() {
        Concept value = attributes.get(ATTRIBUTE_VALUE);
        if (value.isUnknown()) {
            return "0";
        }
        return value.getName();
    }

    public Concept getUnit() {
        return attributes.get(ATTRIBUTE_UNIT);
    }

    public String getUnitText() {
        return attributes.get(ATTRIBUTE_UNIT).getName();
    }

    public Measure value(String value) {
        attributes.insert(ATTRIBUTE_VALUE, new Concept(value));
        return this;
    }

    public Measure unit(String unit) {
        attributes.insert(ATTRIBUTE_UNIT, new Concept(unit));
        return this;
    }

    public Measure accuracy(String accuracy) {
        attributes.insert(ATTRIBUTE_ACCURACY, new Concept(accuracy));
        return this;
    }

    public Measure modifier(String modifier) {
        attributes.insert(ATTRIBUTE_MODIFIER, new Concept(modifier));
        return this;
    }
}
