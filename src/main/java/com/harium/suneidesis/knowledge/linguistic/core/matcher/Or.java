package com.harium.suneidesis.knowledge.linguistic.core.matcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Or implements Matcher {

    protected List<Matcher> matchers = new ArrayList<>();

    public Or(List<Matcher> matchers) {
        this.matchers.addAll(matchers);
    }

    public Or(Matcher... matchers) {
        this.matchers.addAll(Arrays.asList(matchers));
    }

    @Override
    public boolean matches(String[] tokens) {
        if (matchers.isEmpty()) {
            return true;
        }

        for (Matcher matcher : matchers) {
            if (matcher.matches(tokens)) {
                return true;
            }
        }

        return false;
    }

}
