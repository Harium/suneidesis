package com.harium.suneidesis.concept.helper.matchers;

import com.harium.suneidesis.math.ExpressionParser;

import java.math.BigDecimal;

public class Equals extends NumericalMatcher {

    public Equals(BigDecimal reference) {
        super(reference);
    }

    public Equals(String reference) {
        super(reference);
    }

    @Override
    public boolean evaluate(String expression) {
        BigDecimal value = ExpressionParser.parse(expression);
        return value.compareTo(reference) == 0;
    }

}
