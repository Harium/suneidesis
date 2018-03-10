package com.harium.suneidesis.knowledge.linguistic.english;

public class BaseParser {

    public static final String I_DON_T_KNOW = "I don't know.";

    public static boolean checkAction(String action, String ... verbs) {
        for (String verb : verbs) {
            if (action.equalsIgnoreCase(verb)) {
                return true;
            }
        }
        return false;
    }
}
