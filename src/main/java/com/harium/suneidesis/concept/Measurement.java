package com.harium.suneidesis.concept;

public class Measurement extends Concept {

    private static final String ATTRIBUTE_ACCURACY = "accuracy";
    private static final String ATTRIBUTE_UNIT = "unit";
    private static final String ATTRIBUTE_VALUE = "value";

    public static final Unit DEFAULT_UNIT = new Unit("unit", "u");
    public static final Measurement ZERO = new Measurement("0", DEFAULT_UNIT);

    /**
     * This constructor uses value instead of name in purpose
     * @param value - the value in unknown units
     */
    public Measurement(String value) {
        super(ConceptType.MEASUREMENT);
        value(value);
    }

    public Measurement(String value, Concept unit) {
        super(ConceptType.MEASUREMENT);
        value(value);
        unit(unit);
    }

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
            return "0";
        }
        return value.getValue();
    }

    public Concept getUnitConcept() {
        return getAttributes().get(ATTRIBUTE_UNIT);
    }

    public String getUnit() {
        return getUnitConcept().getName();
    }

    public Measurement value(String value) {
        getAttributes().add(ATTRIBUTE_VALUE, new Concept(value));
        return this;
    }

    public Measurement unit(Concept unit) {
        getAttributes().add(ATTRIBUTE_UNIT, unit);
        return this;
    }

    public Measurement unit(String unit) {
        return unit(new Unit(unit));
    }

    public Measurement accuracy(String accuracy) {
        getAttributes().add(ATTRIBUTE_ACCURACY, new Concept(accuracy));
        return this;
    }

    public boolean equals(Measurement q) {
        boolean sameValue = q.getValue().equals(getValue());
        boolean sameUnit = q.getUnit().equals(getUnit());

        return sameValue && sameUnit;
    }
}
