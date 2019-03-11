package com.harium.suneidesis.knowledge.linguistic.core.matcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class And implements Matcher {

    protected List<Matcher> matchers = new ArrayList<>();

    public And(List<Matcher> matchers) {
        this.matchers.addAll(matchers);
    }

    public And(Matcher... matchers) {
        this.matchers.addAll(Arrays.asList(matchers));
    }

    @Override
    public boolean matches(String[] tokens) {
        if (matchers.isEmpty()) {
            return true;
        }

        int matches = 0;

        for (Matcher matcher : matchers) {
            if (matcher.matches(tokens)) {
                matches++;
            }
        }

        return matches == matchers.size();
    }

}
