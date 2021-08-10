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
        // It adds a new line to the output to avoid mixing input and output
        out.println(sentence);
        out.flush();
    }

    @Override
    public void produceFile(byte[] data, String description) {
        String content = new String(data);
        out.println(description + ":" + content);
        out.flush();
    }
}
