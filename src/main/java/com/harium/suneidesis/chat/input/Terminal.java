package com.harium.suneidesis.chat.input;

import com.harium.suneidesis.chat.box.BaseChatBox;
import com.harium.suneidesis.chat.output.TextOutput;

import java.util.Scanner;

public class Terminal extends BaseChatBox {

    private String language = "";
    private String userName = "";
    private String channelId = "";
    private String channelName = "";

    public Terminal() {
        super();
        output = new TextOutput();
    }

    public void init() {
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

        parse(context, output);
    }

    protected void enhanceInputContext(InputContext context) {
        // Custom Properties
        context.getProperties().put(InputContext.USER_USERNAME, getUsername());
        context.getProperties().put(InputContext.USER_ID, getUserId());
        context.getProperties().put(InputContext.USER_NAME, getUserName());
        context.getProperties().put(InputContext.CHANNEL_ID, getChannelId());
        context.getProperties().put(InputContext.CHANNEL_NAME, getChannelName());
        context.getProperties().put(InputContext.LANGUAGE, getLanguage());
    }

    protected String getUsername() {
        return getSystemProperty("user.name");
    }

    protected String getUserId() {
        // Fill with the same data until we find a better way to get user's id
        return getUsername();
    }

    protected String getLanguage() {
        if (language != null && !language.isEmpty()) {
            return language;
        }
        return getSystemProperty("user.language");
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    private String getSystemProperty(String property) {
        String value = System.getProperty(property);
        if (value == null || value.trim().isEmpty()) {
            return "";
        }
        return value;
    }

    protected String getChannelId() {
        return getOrEmpty(channelId);
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    protected String getChannelName() {
        return getOrEmpty(channelName);
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    protected String getUserName() {
        return getOrEmpty(userName);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private String getOrEmpty(String value) {
        if (value != null && !value.isEmpty()) {
            return value;
        }
        return "";
    }

}
