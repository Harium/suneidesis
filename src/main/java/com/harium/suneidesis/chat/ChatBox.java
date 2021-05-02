package com.harium.suneidesis.chat;

import com.harium.suneidesis.chat.output.Output;

public interface ChatBox {

    void init();

    void addParser(Parser parser);

    void addInterceptor(Interceptor interceptor);

    void sendMessage(String channel, String message);

    void setOutput(Output output);

    Output getOutput();

}
