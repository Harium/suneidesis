package com.harium.suneidesis.linguistic.matcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sequence implements Matcher {

    protected List<String> keywords = new ArrayList<>();

    public Sequence(List<String> keywords) {
        this.keywords.addAll(keywords);
    }

    public Sequence(String... keywords) {
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
