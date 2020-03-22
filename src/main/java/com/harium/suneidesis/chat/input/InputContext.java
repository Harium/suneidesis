package com.harium.suneidesis.chat.input;

import com.harium.suneidesis.chat.instance.Instance;
import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.chat.output.Output;

import java.util.HashMap;
import java.util.Map;

public class InputContext {

    private String sentence;
    private String originalSentence;
    private Parser currentParser;
    private Instance instance;
    private Output output;

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

    public Instance getInstance() {
        return instance;
    }

    public void setInstance(Instance instance) {
        this.instance = instance;
    }

    public Output getOutput() {
        return output;
    }

    public void setOutput(Output output) {
        this.output = output;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public void print(String sentence) {
        output.print(sentence);
    }
}
