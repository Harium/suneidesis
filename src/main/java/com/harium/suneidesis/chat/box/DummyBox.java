package com.harium.suneidesis.chat.box;

import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.output.Output;

public class DummyBox implements Parser {

    @Override
    public boolean parse(InputContext input, Output output) {
        return true;
    }
}
