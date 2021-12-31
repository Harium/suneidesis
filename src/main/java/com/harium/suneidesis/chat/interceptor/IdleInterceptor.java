package com.harium.suneidesis.chat.interceptor;

import com.harium.suneidesis.chat.Interceptor;
import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.output.Output;

public class IdleInterceptor implements Interceptor {

    private long lastMessageTime;

    @Override
    public void preParsing(InputContext input, Output output) {
        lastMessageTime = System.currentTimeMillis();
    }

    @Override
    public void postParsing(InputContext input, Output output, Parser parser) {

    }

    public long getLastMessageTime() {
        return lastMessageTime;
    }
}
