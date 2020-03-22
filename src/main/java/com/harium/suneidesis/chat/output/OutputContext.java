package com.harium.suneidesis.chat.output;

import com.harium.suneidesis.chat.instance.Instance;

import java.util.HashMap;
import java.util.Map;

public class OutputContext {

    private String sentence;
    private Instance instance;

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

    public Instance getInstance() {
        return instance;
    }

    public void setInstance(Instance instance) {
        this.instance = instance;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
}
