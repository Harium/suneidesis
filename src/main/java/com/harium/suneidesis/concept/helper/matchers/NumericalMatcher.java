package com.harium.suneidesis.concept.helper.matchers;

import com.harium.suneidesis.concept.helper.MeasureMatcher;

import java.math.BigDecimal;

public abstract class NumericalMatcher implements MeasureMatcher {

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
