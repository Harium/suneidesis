package com.harium.suneidesis.concept;

public class Unit extends Concept {

    private static final String ATTRIBUTE_SYMBOL = "symbol";
    private static final String ATTRIBUTE_UNIT_TYPE = "unit type";

    protected static final String UNIT_TYPE_LENGTH = "length";
    protected static final String UNIT_TYPE_TIME = "time";

    public Unit(String name) {
        super(name);
    }

    public Unit(String name, String symbol) {
        super(name);
        symbol(symbol);
    }

    public Unit symbol(String accuracy) {
        getAttributes().add(ATTRIBUTE_SYMBOL, new Concept(accuracy));
        return this;
    }

    public Concept getSymbolConcept() {
        return getAttributes().get(ATTRIBUTE_SYMBOL);
    }

    public String getSymbol() {
        return getSymbolConcept().getName();
    }

    public Unit unitType(String unitType) {
        getAttributes().add(ATTRIBUTE_UNIT_TYPE, new Concept(unitType));
        return this;
    }

    public Concept getUnitTypeConcept() {
        return getAttributes().get(ATTRIBUTE_UNIT_TYPE);
    }

    public String getUnitType() {
        return getUnitTypeConcept().getName();
    }

    @Override
    public Unit wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
