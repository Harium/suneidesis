package com.harium.suneidesis.knowledge.linguistic.core.box;

import com.harium.suneidesis.instance.Instance;
import com.harium.suneidesis.knowledge.linguistic.core.Parser;
import com.harium.suneidesis.output.Output;

public class BaseLanguageBox extends LanguageBox {

    protected Parser currentParser = null;

    public void input(String sentence, Instance instance, Output output) {
        // Remove Question Mark
        String clean = sentence.replaceAll("\\?", "").trim();

        if (currentParser != null) {
            if (currentParser.matches(clean)) {
                currentParser.parse(clean, instance, output);
                return;
            }
        }

        for (Parser parser : parsers) {
            if (parser != currentParser) {
                if (parser.matches(clean)) {
                    currentParser = parser;
                    parser.parse(clean, instance, output);
                    break;
                }
            }
        }
    }

}
