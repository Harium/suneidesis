package com.harium.suneidesis.chat.output;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public interface Output {
    default void print(String sentence) {
        print(sentence, null);
    }

    void print(String sentence, OutputContext context);

    default void produceFile(String path, String description) throws IOException {
        byte[] content = Files.readAllBytes(Paths.get(path));
        produceFile(content, description);
    }

    void produceFile(byte[] data, String description);
}
