package com.harium.suneidesis.chat;

import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.output.Output;

public interface Parser {

    /**
     * Method that handles messages
     * @param context - the context when receiving messages
     * @param output - the output
     * @return if the message was properly handled or another parser can try to handle it
     */
    boolean parse(InputContext context, Output output);

}
