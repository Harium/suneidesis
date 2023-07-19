package com.harium.suneidesis.chat;

import com.harium.suneidesis.chat.input.InputContext;

public interface ContextMatcher {

    boolean matches(InputContext context);

}
