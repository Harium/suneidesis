package com.harium.suneidesis.knowledge.linguistic.english;

import com.harium.suneidesis.knowledge.beign.Being;
import com.harium.suneidesis.knowledge.linguistic.core.adjective.AdjectiveParser;

public class SimpleAdjectiveParser implements AdjectiveParser {

    @Override
    public String parse(String query, Being beign) {
        String[] parts = query.replaceAll("\\?", "").split(" ");

        String action = parts[1];
        String adjectiveQuery = parts[2];

        if (!BaseParser.checkAction(action, SimpleParser.TO_BE)) {
            return BaseParser.I_DON_T_KNOW;
        }

        if (query.contains(SimpleParser.YOU)) {
            for (String adjective : beign.getStatus().all()) {
                if (adjective.equalsIgnoreCase(adjectiveQuery)) {
                    return "Yes, I am " + adjectiveQuery + ".";
                }
            }

            return "No, I am not " + adjectiveQuery + ".";

        }

        return null;
    }

}
