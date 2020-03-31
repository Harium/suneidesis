package com.harium.suneidesis.chat.input;

import com.harium.suneidesis.chat.box.BoxHandler;
import com.harium.suneidesis.chat.box.ChatBox;
import com.harium.suneidesis.chat.output.TextOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Terminal implements BoxHandler {

    private TextOutput output = new TextOutput();

    private List<ChatBox> instances = new ArrayList<>();

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

                        InputContext context = new InputContext();
                        context.setSentence(sentence);

                        // Custom Properties
                        context.getProperties().put(InputContext.USER_ID, "id");
                        context.getProperties().put(InputContext.USER_NAME, "Full Name");
                        context.getProperties().put(InputContext.USER_USERNAME, "user");
                        context.getProperties().put(InputContext.CHANNEL_ID, "cid");
                        context.getProperties().put(InputContext.CHANNEL_NAME, "console");

                        for (ChatBox box : instances) {
                            box.input(context, output);
                        }
                        sc.reset();
                    }
                }
            }
        }).start();
    }

    @Override
    public void addBox(ChatBox box) {
        instances.add(box);
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
