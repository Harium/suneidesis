package com.harium.suneidesis.chat.box;

import com.harium.suneidesis.chat.instance.Instance;

public interface Chatbox {

    void addInstance(Instance instance);

    void sendMessage(String channel, String message);

}
