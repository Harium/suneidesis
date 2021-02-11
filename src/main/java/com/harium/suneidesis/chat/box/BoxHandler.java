package com.harium.suneidesis.chat.box;

import com.harium.suneidesis.chat.Parser;

public interface BoxHandler {

    void addParser(Parser instance);

    void sendMessage(String channel, String message);

}
