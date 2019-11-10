package com.harium.suneidesis.knowledge.linguistic.english.box;

import com.harium.suneidesis.input.InputContext;
import com.harium.suneidesis.instance.Instance;
import com.harium.suneidesis.knowledge.linguistic.core.adjective.AdjectiveParser;
import com.harium.suneidesis.output.Output;

public class SimpleAdjectiveParser implements AdjectiveParser {

    public static final String[] TO_BE = {"is", "are"};
    public static final String YOU = "you";

    @Override
    public boolean matches(InputContext context) {
        String query = context.getSentence();
        String[] parts = query.split(" ");
        return BaseEnglishBox.checkAction(parts[0], TO_BE);
    }

    @Override
    public void parse(InputContext context) {
        String query = context.getSentence();
        Instance being = context.getInstance();
        Output output = context.getOutput();
        String[] parts = query.split(" ");

        String action = parts[1];
        String adjectiveQuery = parts[2];

        if (!BaseEnglishBox.checkAction(action, TO_BE)) {
            output.print("");
        }

        if (query.contains(YOU)) {
            for (String adjective : being.getStatus().all()) {
                if (adjective.equalsIgnoreCase(adjectiveQuery)) {
                    output.print("Yes, I am " + adjectiveQuery + ".");
                }
            }

            output.print("No, I am not " + adjectiveQuery + ".");

        }

        output.print("");
    }

}
