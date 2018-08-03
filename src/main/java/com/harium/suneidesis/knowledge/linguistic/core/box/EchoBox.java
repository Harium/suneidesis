package com.harium.suneidesis.knowledge.linguistic.core.box;

import com.harium.suneidesis.instance.Instance;

public class EchoBox extends LanguageBox {

    public String input(String sentence, Instance instance) {
        return sentence;
    }

}
