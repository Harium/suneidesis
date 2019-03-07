package com.harium.suneidesis.knowledge.linguistic.english.box;

import com.harium.suneidesis.instance.Instance;
import com.harium.suneidesis.knowledge.linguistic.core.adjective.AdjectiveParser;
import com.harium.suneidesis.output.Output;

public class SimpleAdjectiveParser implements AdjectiveParser {

    public static final String[] TO_BE = {"is", "are"};
    public static final String YOU = "you";

    @Override
    public boolean matches(String query) {
        String[] parts = query.split(" ");
        return BaseEnglishBox.checkAction(parts[0], TO_BE);
    }

    @Override
    public void parse(String query, Instance beign, Output output) {
        String[] parts = query.split(" ");

        String action = parts[1];
        String adjectiveQuery = parts[2];

        if (!BaseEnglishBox.checkAction(action, TO_BE)) {
            output.print("");
        }

        if (query.contains(YOU)) {
            for (String adjective : beign.getStatus().all()) {
                if (adjective.equalsIgnoreCase(adjectiveQuery)) {
                    output.print("Yes, I am " + adjectiveQuery + ".");
                }
            }

            output.print("No, I am not " + adjectiveQuery + ".");

        }

        output.print("");
    }

}
