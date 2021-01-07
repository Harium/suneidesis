package com.harium.suneidesis.knowledge.inspector.matchers;

import com.harium.suneidesis.knowledge.inspector.Matcher;

import java.math.BigDecimal;

public abstract class NumericalMatcher implements Matcher {

    protected final BigDecimal reference;

    public NumericalMatcher(BigDecimal reference) {
        this.reference = reference;
    }

    public NumericalMatcher(String reference) {
        this(new BigDecimal(reference));
    }

    public NumericalMatcher(long reference) {
        this(new BigDecimal(reference));
    }

}
