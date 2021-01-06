package com.harium.suneidesis.knowledge.inspector.matchers;

import com.harium.suneidesis.knowledge.inspector.Matcher;

public abstract class NumericalMatcher implements Matcher {

    protected final long reference;

    public NumericalMatcher(long reference) {
        this.reference = reference;
    }

}
