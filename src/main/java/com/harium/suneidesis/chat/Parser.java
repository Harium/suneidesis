package com.harium.suneidesis.chat;

import com.harium.suneidesis.chat.input.InputContext;

public interface Parser {

    boolean matches(InputContext context);

    void parse(InputContext context);

}
