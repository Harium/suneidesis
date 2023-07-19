package com.harium.suneidesis.chat.interceptor;

import com.harium.suneidesis.chat.ContextMatcher;
import com.harium.suneidesis.chat.Interceptor;
import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.output.Output;

import java.util.ArrayList;
import java.util.List;

// This class is the top priority module
// Every time a parser needs a specific input to proceed, it should create a new action at this interceptor.
// A module that requires asynchronous interaction should get temporary priority.
public class ActionInterceptor implements Interceptor {

    private List<ChatAction> pendingActions = new ArrayList<>();

    @Override
    public void preParsing(InputContext input, Output output) {
        if (pendingActions.isEmpty()) {
            return;
        }

        ChatAction action = pendingActions.get(0);
        if (action.matcher.matches(input)) {
            action.parser.parse(input, output);
        }
    }

    @Override
    public void postParsing(InputContext input, Output output, Parser parser) {

    }

    public void addAction(Parser parser, ContextMatcher contextMatcher) {
        ChatAction action = new ChatAction();
        action.parser = parser;
        action.matcher = contextMatcher;

        pendingActions.add(action);
    }

    private static class ChatAction {
        Parser parser;
        ContextMatcher matcher;
    }

}
