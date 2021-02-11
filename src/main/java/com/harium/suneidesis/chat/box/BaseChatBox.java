package com.harium.suneidesis.chat.box;

import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.output.Output;

import java.util.ArrayList;
import java.util.List;

public class BaseChatBox implements Parser {

    protected Parser currentParser = null;
    protected List<Parser> parsers = new ArrayList<>();

    @Override
    public boolean parse(InputContext input, Output output) {
        input.setCurrentParser(currentParser);

        // Remove Question Mark
        String clean = clearSentence(input.getSentence());
        input.setSentence(clean);

        return queryParsers(input, output);
    }

    protected String clearSentence(String sentence) {
        if (sentence == null) {
            return sentence;
        }
        return sentence.replaceAll("\\?", "").trim();
    }

    private boolean queryParsers(InputContext context, Output output) {
        if (currentParser != null) {
            if (currentParser.parse(context, output)) {
                return true;
            }
        }

        for (Parser parser : parsers) {
            if (parser != currentParser) {
                if (parser.parse(context, output)) {
                    currentParser = parser;
                    return true;
                }
            }
        }
        return false;
    }

    public void addParser(Parser parser) {
        parsers.add(parser);
    }

}
