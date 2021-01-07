package com.harium.suneidesis.knowledge.inspector.matchers;

import com.harium.suneidesis.math.ExpressionParser;

import java.math.BigDecimal;

public class GreaterThan extends NumericalMatcher {

    public GreaterThan(BigDecimal reference) {
        super(reference);
    }

    public GreaterThan(String reference) {
        super(reference);
    }

    @Override
    public boolean evaluate(String expression) {
        BigDecimal value = ExpressionParser.parse(expression);
        return value.compareTo(reference) > 0;
    }

}
