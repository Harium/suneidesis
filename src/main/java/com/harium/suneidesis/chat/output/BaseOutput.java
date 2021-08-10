package com.harium.suneidesis.chat.output;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class BaseOutput implements Output {

    @Override
    public void print(String sentence) {
        print(sentence, null);
    }

    @Override
    public void produceFile(String path, String description) throws IOException {
        byte[] content = Files.readAllBytes(Paths.get(path));
        produceFile(content, description);
    }

}
