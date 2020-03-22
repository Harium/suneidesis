package com.harium.suneidesis.chat.output;

public abstract class BaseOutput implements Output {

    @Override
    public void print(String sentence) {
        print(sentence, null);
    }

}
