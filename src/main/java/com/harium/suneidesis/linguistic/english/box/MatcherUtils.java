package com.harium.suneidesis.linguistic.english.box;

public class MatcherUtils {

    public static String optionalSentence() {
        return "(.*?)";
    }

    public static String someSentence() {
        return "(.+)";
    }

    public static String whiteSpace() {
        return "\\s";
    }

    public static String can() {
        return "can|could";
    }

    public static String have() {
        return "have|has";
    }

    public static String optional(String sentence) {
        return "(" + sentence + ")?";
    }

    public static String once(String sentence) {
        return "(" + sentence + ")";
    }

}
