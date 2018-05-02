package com.harium.suneidesis.output;

public class TextOutput implements Output {
    @Override
    public void print(String sentence) {
        System.out.println(sentence);
    }
}
