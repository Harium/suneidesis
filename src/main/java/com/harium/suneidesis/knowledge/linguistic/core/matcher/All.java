package com.harium.suneidesis.knowledge.linguistic.core.matcher;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class All implements Matcher {

    protected List<String> keywords = new ArrayList<>();

    public All(List<String> keywords) {
        this.keywords.addAll(keywords);
    }

    public All(String... keywords) {
        for (String keyword : keywords) {
            this.keywords.add(keyword);
        }
    }

    @Override
    public boolean matches(String[] tokens) {
        if (keywords.isEmpty()) {
            return true;
        }

        Set<String> bucket = new HashSet<>();
        bucket.addAll(keywords);

        for (String token : tokens) {
            if (bucket.contains(token)) {
                bucket.remove(token);
            }
        }

        return bucket.isEmpty();
    }

}
