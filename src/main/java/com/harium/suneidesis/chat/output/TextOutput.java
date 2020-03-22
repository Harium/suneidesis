package com.harium.suneidesis.chat.output;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TextOutput extends BaseOutput {

    private static final int BUFFER_SIZE = 1024;

    private PrintWriter out;

    public TextOutput() {
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FileDescriptor.out),
                StandardCharsets.UTF_8), BUFFER_SIZE));
    }

    @Override
    public void print(String sentence, OutputContext context) {
        // It should add a new line
        out.println(sentence);
        out.flush();
    }

    @Override
    public void produceFile(String path, String description) {
        out.println(description + ":" + path);
        out.flush();
    }
}
