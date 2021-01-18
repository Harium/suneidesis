package com.harium.suneidesis.linguistic.matcher;

public class Regex implements Matcher {

    private String regex;

    public Regex(String regex) {
        this.regex = regex;
    }

    public boolean matches(String[] tokens) {
        for (String token : tokens) {
            if (token.matches(regex)) {
                return true;
            }
        }
        return false;
    }
}
