package com.harium.suneidesis.output;

public abstract class BaseOutput implements Output {

    @Override
    public void print(String sentence) {
        print(sentence, null);
    }

}
