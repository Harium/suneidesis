package com.harium.suneidesis.chat.output;

public class TextOutput extends BaseOutput {

    @Override
    public void print(String sentence, OutputContext context) {
        System.out.println(sentence);
    }

    @Override
    public void produceFile(String path, String description) {
        System.out.println(description + ":" + path);
    }
}
