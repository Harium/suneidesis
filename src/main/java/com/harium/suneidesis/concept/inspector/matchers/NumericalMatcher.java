package com.harium.suneidesis.concept.inspector.matchers;

import com.harium.suneidesis.concept.inspector.Matcher;

public abstract class NumericalMatcher implements Matcher {

    protected final long reference;

    public NumericalMatcher(long reference) {
        this.reference = reference;
    }

}
