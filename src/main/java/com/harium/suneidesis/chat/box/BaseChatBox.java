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
        input.setCurrentParser(currentParser);

        // Remove Question Mark
        String clean = clearSentence(input.getSentence());
        input.setSentence(clean);

        queryParsers(input, output);
    }

    protected String clearSentence(String sentence) {
        if (sentence == null) {
            return sentence;
        }
        return sentence.replaceAll("\\?", "").trim();
    }

    private void queryParsers(InputContext context, Output output) {
        if (currentParser != null) {
            if (currentParser.parse(context, output)) {
                return;
            }
        }

        for (Parser parser : parsers) {
            if (parser != currentParser) {
                if (parser.parse(context, output)) {
                    currentParser = parser;
                    break;
                }
            }
        }
    }

    public void addParser(Parser parser) {
        parsers.add(parser);
    }

}
