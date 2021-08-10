package com.harium.suneidesis.chat.box;

import com.harium.suneidesis.chat.ChatBox;
import com.harium.suneidesis.chat.Interceptor;
import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.output.Output;
import com.harium.suneidesis.chat.output.OutputContext;

import java.util.ArrayList;
import java.util.List;

import static com.harium.suneidesis.chat.input.InputContext.CHANNEL_ID;

public abstract class BaseChatBox implements ChatBox, Parser {

    protected Output output;

    protected boolean skipEmptySentences = true;
    protected List<Parser> parsers = new ArrayList<>();
    protected List<Interceptor> interceptors = new ArrayList<>();

    public boolean parse(InputContext input, Output output) {
        if (shouldSkipSentence(input)) {
           return false;
        }

        for (Interceptor interceptor : interceptors) {
            interceptor.preParsing(input, output);
        }

        Parser parser = runParsers(input, output);
        if (parser == null) {
            return false;
        }

        for (Interceptor interceptor : interceptors) {
            interceptor.postParsing(input, output, parser);
        }
        return true;
    }

    private boolean shouldSkipSentence(InputContext input) {
        if (!skipEmptySentences) {
            return false;
        }
        return input.getSentence() == null || input.getSentence().trim().isEmpty();
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

    @Override
    public void sendMessage(String channel, String message) {
        if (output == null) {
            return;
        }
        OutputContext context = new OutputContext();
        context.getProperties().put(CHANNEL_ID, channel);
        output.print(message);
    }

    @Override
    public Output getOutput() {
        return output;
    }

    @Override
    public void setOutput(Output output) {
        this.output = output;
    }
}
