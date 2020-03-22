package com.harium.suneidesis.chat.input;

import com.harium.suneidesis.chat.instance.LanguageBox;
import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.chat.output.Output;

import java.util.HashMap;
import java.util.Map;

public class InputContext {

    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String USER_USERNAME = "user_username";

    public static final String CHANNEL_ID = "channel_id";
    public static final String CHANNEL_NAME = "channel_name";

    private String sentence;
    private String originalSentence;
    private Parser currentParser;
    private LanguageBox instance;

    private Map<String, Object> properties = new HashMap<>();

    public InputContext() {
        super();
    }

    public InputContext(String sentence) {
        super();
        this.sentence = sentence;
        this.originalSentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getOriginalSentence() {
        return originalSentence;
    }

    public void setOriginalSentence(String originalSentence) {
        this.originalSentence = originalSentence;
    }

    public Parser getCurrentParser() {
        return currentParser;
    }

    public void setCurrentParser(Parser currentParser) {
        this.currentParser = currentParser;
    }

    public LanguageBox getInstance() {
        return instance;
    }

    public void setInstance(LanguageBox instance) {
        this.instance = instance;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

}
