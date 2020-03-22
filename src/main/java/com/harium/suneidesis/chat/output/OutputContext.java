package com.harium.suneidesis.chat.output;

import com.harium.suneidesis.chat.instance.LanguageBox;

import java.util.HashMap;
import java.util.Map;

public class OutputContext {

    private String sentence;
    private LanguageBox instance;

    private Map<String, Object> properties = new HashMap<>();

    public OutputContext() {
        super();
    }

    public OutputContext(String sentence) {
        super();
        this.sentence = sentence;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
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
