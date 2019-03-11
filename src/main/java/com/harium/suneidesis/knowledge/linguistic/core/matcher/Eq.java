package com.harium.suneidesis.knowledge.linguistic.core.matcher;

public class Eq implements Matcher {

    private String word;

    public Eq(String word) {
        this.word = word;
    }

    @Override
    public boolean matches(String[] tokens) {
        for (String token : tokens) {
            if (token.equals(word)) {
                return true;
            }
        }
        return false;
    }
}
