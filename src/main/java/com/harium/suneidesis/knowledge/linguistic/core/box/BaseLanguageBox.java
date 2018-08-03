package com.harium.suneidesis.knowledge.linguistic.core.box;

import com.harium.suneidesis.instance.Instance;
import com.harium.suneidesis.knowledge.linguistic.core.Parser;

public class BaseLanguageBox extends LanguageBox {

    public String input(String sentence, Instance instance) {
        // Remove Question Mark
        String clean = sentence.replaceAll("\\?", "").trim();

        String response = "";

        for (Parser parser: parsers) {
            if (parser.matches(clean)) {
                response = parser.parse(clean, instance);
                return response;
            }
        }

        return response;
    }

}
