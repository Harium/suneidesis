package com.harium.suneidesis.chat.box;

public interface BoxHandler {

    void addBox(ChatBox instance);

    void sendMessage(String channel, String message);

}
