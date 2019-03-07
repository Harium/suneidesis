package com.harium.suneidesis.knowledge.linguistic.core.box;

import com.harium.suneidesis.instance.Instance;
import com.harium.suneidesis.output.Output;

public class EchoBox extends LanguageBox {

    public void input(String sentence, Instance instance, Output output) {
        output.print(sentence);
    }

}
