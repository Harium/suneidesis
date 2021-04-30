package com.harium.suneidesis.chat.input;

import com.harium.suneidesis.chat.Interceptor;
import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.chat.box.BoxHandler;
import com.harium.suneidesis.chat.output.TextOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Terminal implements BoxHandler {

    private TextOutput output = new TextOutput();

    private List<Parser> parsers = new ArrayList<>();
    private List<Interceptor> interceptors = new ArrayList<>();

    public Terminal() {
        super();
        initInput();
    }

    private void initInput() {
        Scanner sc = new Scanner(System.in);
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (sc.hasNextLine()) {
                        String sentence = sc.nextLine();
                        input(sentence);
                        sc.reset();
                    }
                }
            }
        }).start();
    }

    protected void input(String sentence) {
        InputContext context = new InputContext();
        context.setSentence(sentence);
        enhanceInputContext(context);

        for (Interceptor interceptor : interceptors) {
            interceptor.intercept(context, output);
        }
        for (Parser parser : parsers) {
            if (parser.parse(context, output)) {
                break;
            }
        }
    }

    protected void enhanceInputContext(InputContext context) {
        // Custom Properties
        context.getProperties().put(InputContext.USER_USERNAME, getUsername());
        context.getProperties().put(InputContext.USER_ID, "");
        context.getProperties().put(InputContext.USER_NAME, "");
        context.getProperties().put(InputContext.CHANNEL_ID, "");
        context.getProperties().put(InputContext.CHANNEL_NAME, "");
        context.getProperties().put(InputContext.LANGUAGE, getLanguage());
    }

    protected String getUsername() {
        return getSystemProperty("user.name");
    }

    protected String getLanguage() {
        return getSystemProperty("user.language");
    }

    private String getSystemProperty(String property) {
        String value = System.getProperty(property);
        if (value == null || value.trim().isEmpty()) {
            return "";
        }
        return value;
    }

    @Override
    public void addParser(Parser box) {
        parsers.add(box);
    }

    @Override
    public void sendMessage(String channel, String message) {
        output.print(message);
    }

    public TextOutput getOutput() {
        return output;
    }

    public void setOutput(TextOutput output) {
        this.output = output;
    }
}
