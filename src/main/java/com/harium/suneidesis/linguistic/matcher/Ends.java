package com.harium.suneidesis.linguistic.matcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ends implements Matcher {

    protected List<String> keywords = new ArrayList<>();

    public Ends(List<String> keywords) {
        this.keywords.addAll(keywords);
    }

    public Ends(String... keywords) {
        this.keywords.addAll(Arrays.asList(keywords));
    }

    @Override
    public boolean matches(String[] tokens) {
        if (keywords.isEmpty()) {
            return true;
        }

        int t = 0;
        int cursor = tokens.length-keywords.size();
        String keyword = keywords.get(0);
        while (cursor<tokens.length) {
            String token = tokens[cursor];
            if (keyword.equals(token)) {
                cursor++;
                if (cursor > keywords.size()) {
                    return true;
                }
                t++;
                keyword = keywords.get(t);
            } else {
                return false;
            }
        }

        return false;
    }

}
