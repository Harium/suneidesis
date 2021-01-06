package com.harium.suneidesis.knowledge.inspector.matchers;

import com.harium.suneidesis.math.ExpressionParser;

public class LowerThan extends NumericalMatcher {

    public LowerThan(long reference) {
        super(reference);
    }

    @Override
    public boolean evaluate(String expression) {
        long value = ExpressionParser.parse(expression);
        return value < reference;
    }

}
