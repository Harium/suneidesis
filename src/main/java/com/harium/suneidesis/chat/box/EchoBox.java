package com.harium.suneidesis.chat.box;

import com.harium.suneidesis.chat.instance.Instance;
import com.harium.suneidesis.chat.output.Output;

public class EchoBox extends LanguageBox {

    public void input(String sentence, Instance instance, Output output) {
        output.print(sentence);
    }

}
