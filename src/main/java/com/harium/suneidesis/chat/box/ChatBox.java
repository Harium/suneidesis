package com.harium.suneidesis.chat.box;

import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.chat.output.Output;

public interface ChatBox {

    void init();

    void addParser(Parser instance);

    void sendMessage(String channel, String message);

    void setOutput(Output output);

    Output getOutput();

}
