package com.harium.suneidesis.concept;

public class Measurement extends Concept {

    private static final String ATTRIBUTE_ACCURACY = "accuracy";
    private static final String ATTRIBUTE_UNIT = "unit";
    private static final String ATTRIBUTE_VALUE = "value";
    private static final String ATTRIBUTE_SYMBOL = "symbol";

    public static final Measurement ZERO = new Measurement("0", "u");

    /**
     * This constructor uses value instead of name in purpose
     * @param value - the value in unknown units
     */
    public Measurement(String value) {
        super(ConceptType.MEASUREMENT);
        value(value);
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
        return getUnit().getName();
    }

    public Concept getSymbol() {
        return attributes.get(ATTRIBUTE_SYMBOL);
    }

    public String getSymbolText() {
        return getSymbol().getName();
    }

    public Measurement value(String value) {
        attributes.insert(ATTRIBUTE_VALUE, new Concept(value));
        return this;
    }

    public Measurement unit(String unit) {
        attributes.insert(ATTRIBUTE_UNIT, new Concept(unit));
        return this;
    }

    public Measurement accuracy(String accuracy) {
        attributes.insert(ATTRIBUTE_ACCURACY, new Concept(accuracy));
        return this;
    }

    public Measurement symbol(String accuracy) {
        attributes.insert(ATTRIBUTE_SYMBOL, new Concept(accuracy));
        return this;
    }

    public boolean equals(Measurement q) {
        boolean sameValue = q.getValueText().equals(getValueText());
        boolean sameUnit = q.getUnitText().equals(getUnitText());

        return sameValue && sameUnit;
    }
}
