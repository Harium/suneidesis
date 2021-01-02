package com.harium.suneidesis.concept.numeral;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;

public class Amount extends Concept {

    private static final String ATTRIBUTE_VALUE = "value";
    public static final Amount ZERO = new Amount("Zero", "0");

    public Amount(String name) {
        super(name, ConceptType.NUMERAL);
        setExpression("0");
    }

    public Amount(String name, String expression) {
        super(name, ConceptType.NUMERAL);
        setExpression(expression);
    }

    public void setExpression(String value) {
        Concept concept = new Concept();
        // Hacky way to avoid stack overflow
        concept.setId(value);
        attributes.set(ATTRIBUTE_VALUE, concept);
    }

    public String getExpression() {
        Concept value = attributes.get(ATTRIBUTE_VALUE);
        if (value == null) {
            value = ZERO;
        }
        return value.getId();
    }
}
