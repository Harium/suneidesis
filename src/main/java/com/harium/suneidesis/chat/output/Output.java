package com.harium.suneidesis.chat.output;

import java.io.IOException;

public interface Output {
    void print(String sentence);

    void print(String sentence, OutputContext context);

    void produceFile(String path, String description) throws IOException;

    void produceFile(byte[] data, String description);
}
