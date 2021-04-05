package com.harium.suneidesis.chat;

import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.output.Output;

public interface Interceptor {

    void intercept(InputContext input, Output output);

}
