package com.harium.suneidesis.linguistic.matcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Starts implements Matcher {

    protected List<String> keywords = new ArrayList<>();

    public Starts(List<String> keywords) {
        this.keywords.addAll(keywords);
    }

    public Starts(String... keywords) {
        this.keywords.addAll(Arrays.asList(keywords));
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
                cursor++;
                if (cursor >= keywords.size()) {
                    return true;
                }
                keyword = keywords.get(cursor);
            } else {
                return false;
            }
        }

        return false;
    }

}
