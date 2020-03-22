package com.harium.suneidesis.chat.input;

import com.harium.suneidesis.chat.box.Chatbox;
import com.harium.suneidesis.chat.instance.Instance;
import com.harium.suneidesis.chat.output.TextOutput;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Terminal implements Chatbox {

    private TextOutput output = new TextOutput();

    private List<Instance> instances = new ArrayList<>();

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
                        String input = sc.nextLine();
                        for (Instance instance : instances) {
                            instance.input(input, output);
                        }
                        sc.reset();
                    }
                }
            }
        }).start();
    }

    @Override
    public void addInstance(Instance instance) {
        instances.add(instance);
    }

    @Override
    public void sendMessage(String channel, String message) {
        output.print(message);
    }
}
