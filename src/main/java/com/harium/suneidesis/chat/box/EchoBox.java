package com.harium.suneidesis.chat.box;

import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.output.Output;

public class EchoBox implements ChatBox {

    @Override
    public void input(InputContext input, Output output) {
        output.print(input.getSentence());
    }
}
