package com.harium.suneidesis.chat.box;

import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.output.Output;

/**
 * Class to represent instance's responses based on input
 */

public interface ChatBox {
    void input(InputContext input, Output output);
}
