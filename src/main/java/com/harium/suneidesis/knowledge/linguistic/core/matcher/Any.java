package com.harium.suneidesis.knowledge.linguistic.core.matcher;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Any implements Matcher {

    protected Set<String> keywords = new HashSet<>();

    public Any(List<String> keywords) {
        this.keywords.addAll(keywords);
    }

    public Any(String... keywords) {
        for (String keyword : keywords) {
            this.keywords.add(keyword);
        }
    }

    @Override
    public boolean matches(String[] tokens) {
        if (keywords.isEmpty()) {
            return true;
        }
        for (String token : tokens) {
            if (keywords.contains(token)) {
                return true;
            }
        }
        return false;
    }

}
