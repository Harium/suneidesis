package com.harium.suneidesis.concept.helper.matchers;

import com.harium.suneidesis.math.ExpressionParser;

import java.math.BigDecimal;

public class LowerThan extends NumericalMatcher {

    public LowerThan(BigDecimal reference) {
        super(reference);
    }

    public LowerThan(String reference) {
        super(reference);
    }

    @Override
    public boolean evaluate(String expression) {
        BigDecimal value = ExpressionParser.parse(expression);
        return value.compareTo(reference) < 0;
    }

}
