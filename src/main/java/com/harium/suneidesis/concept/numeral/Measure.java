package com.harium.suneidesis.concept.numeral;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;

public class Measure extends Concept {

    private static final String ATTRIBUTE_UNIT = "unit";
    private static final String ATTRIBUTE_VALUE = "value";
    private static final String ATTRIBUTE_ACCURACY = "accuracy";

    public static final Measure ZERO = new Measure("Zero", "0");

    /**
     * This constructor uses value instead of name in purpose
     * @param value - the value in unknown units
     */
    public Measure(String value) {
        super(ConceptType.MEASURE);
        setValue(value);
    }

    public Measure(String value, String unit) {
        super(ConceptType.MEASURE);
        setValue(value);
        setUnit(unit);
    }

    public Measure(String value, String unit, String name) {
        super(name, ConceptType.MEASURE);
        setValue(value);
        setUnit(unit);
    }

    public Concept getValue() {
        return attributes.get(ATTRIBUTE_VALUE);
    }

    public String getValueText() {
        Concept value = attributes.get(ATTRIBUTE_VALUE);
        if (value == null) {
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

    public Measure setValue(String value) {
        attributes.insert(ATTRIBUTE_VALUE, new Concept(value));
        return this;
    }

    public Measure setUnit(String unit) {
        attributes.insert(ATTRIBUTE_UNIT, new Concept(unit));
        return this;
    }
}
