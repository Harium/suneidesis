package com.harium.suneidesis.knowledge.linguistic.core.box;

import com.harium.suneidesis.instance.Instance;
import com.harium.suneidesis.knowledge.linguistic.core.Parser;
import com.harium.suneidesis.output.Output;

public class BaseLanguageBox extends LanguageBox {

    public void input(String sentence, Instance instance, Output output) {
        // Remove Question Mark
        String clean = sentence.replaceAll("\\?", "").trim();

        for (Parser parser : parsers) {
            if (parser.matches(clean)) {
                parser.parse(clean, instance, output);
                break;
            }
        }
    }

}
