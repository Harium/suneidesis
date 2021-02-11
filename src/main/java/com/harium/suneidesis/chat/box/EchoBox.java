package com.harium.suneidesis.chat.box;

import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.output.Output;

public class EchoBox implements Parser {

    @Override
    public boolean parse(InputContext input, Output output) {
        output.print(input.getSentence());
        return true;
    }
}
