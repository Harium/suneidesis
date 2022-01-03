package com.harium.suneidesis.chat.interceptor;

import com.harium.suneidesis.chat.Interceptor;
import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.output.Output;

public class IdleInterceptor implements Interceptor {

    private long lastMessageTime;

    @Override
    public void preParsing(InputContext input, Output output) {
        lastMessageTime = getTimeNow();
    }

    @Override
    public void postParsing(InputContext input, Output output, Parser parser) {

    }

    public long getLastMessageTime() {
        return lastMessageTime;
    }

    /**
     * Method to check if chatbot is idle for more than (or equal to) interval (milliseconds)
     * @param interval - milliseconds
     * @return if is idle
     */
    public boolean isIdle(long interval) {
        long now = getTimeNow();
        return now - lastMessageTime >= interval;
    }

    protected long getTimeNow() {
        return System.currentTimeMillis();
    }
}
