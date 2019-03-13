package com.harium.suneidesis.knowledge.linguistic.core.box;

import com.harium.suneidesis.instance.Instance;

public interface Chatbox {

    void addInstance(Instance instance);

    void sendMessage(String channel, String message);

}
