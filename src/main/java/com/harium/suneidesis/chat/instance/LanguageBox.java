package com.harium.suneidesis.chat.instance;

import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.output.TextOutput;

public interface LanguageBox {
    void input(InputContext context, TextOutput output);
}
