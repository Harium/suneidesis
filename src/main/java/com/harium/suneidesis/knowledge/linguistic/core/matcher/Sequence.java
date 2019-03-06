package com.harium.suneidesis.knowledge.linguistic.core.matcher;

import java.util.ArrayList;
import java.util.List;

public class Sequence implements Matcher {

    protected List<String> keywords = new ArrayList<>();

    public Sequence(List<String> keywords) {
        this.keywords.addAll(keywords);
    }

    public Sequence(String... keywords) {
        for (String keyword : keywords) {
            this.keywords.add(keyword);
        }
    }

    @Override
    public boolean matches(String[] tokens) {
        if (keywords.isEmpty()) {
            return true;
        }

        int cursor = 0;
        String keyword = keywords.get(0);
        for (String token : tokens) {
            if (keyword.equals(token)) {
                if (cursor + 1 == keywords.size()) {
                    return true;
                }
                cursor++;
                keyword = keywords.get(cursor);
            }
        }

        return false;
    }

}
