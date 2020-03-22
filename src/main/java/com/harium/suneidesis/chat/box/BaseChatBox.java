package com.harium.suneidesis.chat.box;

import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.output.Output;

import java.util.ArrayList;
import java.util.List;

public class BaseChatBox implements ChatBox {

    protected Parser currentParser = null;
    protected List<Parser> parsers = new ArrayList<>();

    @Override
    public void input(InputContext input, Output output) {
        InputContext context = new InputContext();
        context.setOutput(output);
        context.setCurrentParser(currentParser);

        // Remove Question Mark
        String clean = clearSentence(context.getSentence());
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
