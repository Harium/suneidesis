package com.harium.suneidesis.chat.box;

import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.instance.Instance;
import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.chat.output.Output;

public class BaseLanguageBox extends LanguageBox {

    protected Parser currentParser = null;

    public void input(String sentence, Instance instance, Output output) {
        InputContext context = new InputContext();
        context.setInstance(instance);
        context.setOutput(output);
        context.setOriginalSentence(sentence);
        context.setCurrentParser(currentParser);

        // Remove Question Mark
        String clean = clearSentence(sentence);
        context.setSentence(clean);

        queryParsers(context);
    }

    protected String clearSentence(String sentence) {
        return sentence.replaceAll("\\?", "").trim();
    }

    private void queryParsers(InputContext context) {
        if (currentParser != null) {
            if (currentParser.matches(context)) {
                currentParser.parse(context);
                return;
            }
        }

        for (Parser parser : parsers) {
            if (parser != currentParser) {
                if (parser.matches(context)) {
                    currentParser = parser;
                    parser.parse(context);
                    break;
                }
            }
        }
    }

}
