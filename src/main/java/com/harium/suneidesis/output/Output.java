package com.harium.suneidesis.output;

public interface Output {
    default void print(String sentence) {
        print(sentence, null);
    }

    void print(String sentence, OutputContext context);

    void produceFile(String path, String description);
}
