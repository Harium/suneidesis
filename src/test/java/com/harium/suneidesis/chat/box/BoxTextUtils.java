package com.harium.suneidesis.chat.box;

import com.harium.suneidesis.chat.input.InputContext;

public class BoxTextUtils {

    public static InputContext context(String sentence) {
        InputContext context = new InputContext();
        context.setSentence(sentence);
        return context;
    }

}
