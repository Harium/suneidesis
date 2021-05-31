package com.harium.suneidesis.concept;

public class Phenomenon extends Concept {

    protected static final String ATTRIBUTE_TYPE = "phenomenon_type";

    public static final Concept TYPE_WEATHER = new Concept("weather");
    public static final Concept TYPE_PHYSICAL = new Concept("physical");

    public Phenomenon(String name) {
        super(name, ConceptType.PHENOMENON);
    }

    public Phenomenon setPhenomenonType(Concept type) {
        has(ATTRIBUTE_TYPE, type);
        return this;
    }

    public Concept getPhenomenonType() {
        return get(ATTRIBUTE_TYPE);
    }

    @Override
    public Phenomenon wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
