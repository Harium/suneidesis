package com.harium.suneidesis.concept.numeral;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;

public class Quantity extends Concept {

    private static final String ATTRIBUTE_UNIT = "unit";
    private static final String ATTRIBUTE_VALUE = "value";

    public static final Quantity ZERO = new Quantity("Zero", "0");

    /**
     * This constructor uses value instead of name in purpose
     * @param value - the value in unknown units
     */
    public Quantity(String value) {
        super(ConceptType.QUANTITY);
        setValue(value);
    }

    public Quantity(String value, String unit) {
        super(ConceptType.QUANTITY);
        setValue(value);
        setUnit(unit);
    }

    public Quantity(String value, String unit, String name) {
        super(name, ConceptType.QUANTITY);
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

    public Quantity setValue(String value) {
        attributes.set(ATTRIBUTE_VALUE, new Concept(value));
        return this;
    }

    public Quantity setUnit(String unit) {
        attributes.set(ATTRIBUTE_UNIT, new Concept(unit));
        return this;
    }
}
