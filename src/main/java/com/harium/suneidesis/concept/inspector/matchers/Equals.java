package com.harium.suneidesis.concept.inspector.matchers;

import com.harium.suneidesis.math.ExpressionParser;

public class Equals extends NumericalMatcher {

    public Equals(long reference) {
        super(reference);
    }

    @Override
    public boolean evaluate(String expression) {
        long value = ExpressionParser.parse(expression);
        return value == reference;
    }

}
