package com.harium.suneidesis.chat.box;

import com.harium.suneidesis.chat.ChatBox;
import com.harium.suneidesis.chat.Interceptor;
import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.output.Output;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseChatBox implements ChatBox {

    protected List<Parser> parsers = new ArrayList<>();
    protected List<Interceptor> interceptors = new ArrayList<>();

    protected void parseInput(InputContext input, Output output) {
        for (Interceptor interceptor : interceptors) {
            interceptor.preParsing(input, output);
        }

        Parser parser = runParsers(input, output);

        for (Interceptor interceptor : interceptors) {
            interceptor.postParsing(input, output, parser);
        }
    }

    private Parser runParsers(InputContext context, Output output) {
        for (Parser parser : parsers) {
            if (parser.parse(context, output)) {
                return parser;
            }
        }
        return null;
    }

    public void addInterceptor(Interceptor interceptor) {
        interceptors.add(interceptor);
    }

    public void addParser(Parser parser) {
        parsers.add(parser);
    }

}
