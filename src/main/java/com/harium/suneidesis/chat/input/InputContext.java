package com.harium.suneidesis.chat.input;

import com.harium.suneidesis.chat.Parser;

import java.util.HashMap;
import java.util.Map;

public class InputContext {

    public static final String USER_ID = "user_id";
    public static final String USER_NAME = "user_name";
    public static final String USER_USERNAME = "user_username";

    public static final String CHANNEL_ID = "channel_id";
    public static final String CHANNEL_NAME = "channel_name";

    public static final String LANGUAGE = "lang";

    // The original sentence from the input
    public static final String ORIGINAL_SENTENCE = "sentence";

    // Output/Parser would try to answer as a robot
    public static final String HINT_ROBOT_MODE = "robot";

    // Output/Parser would try to not answer when possible
    public static final String HINT_SILENT_MODE = "silent";

    // Output/Parser would try to treat all input as secret
    public static final String HINT_SECRET_MODE = "secret";

    // Output/Parser would try to answer based on the prosody param
    public static final String HINT_PROSODY = "prosody";

    private String sentence;
    private Parser currentParser;

    private Map<String, Object> properties = new HashMap<>();

    public InputContext() {
        super();
    }

    public InputContext(String sentence) {
        super();
        this.sentence = sentence;
        setOriginalSentence(sentence);
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public Parser getCurrentParser() {
        return currentParser;
    }

    public void setCurrentParser(Parser currentParser) {
        this.currentParser = currentParser;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public String getOriginalSentence() {
        return (String) properties.getOrDefault(ORIGINAL_SENTENCE, "");
    }

    public void setOriginalSentence(String sentence) {
        properties.put(ORIGINAL_SENTENCE, sentence);
    }

    // If not assigned, robot mode returns true
    public boolean isRobotMode() {
        return (boolean) properties.getOrDefault(HINT_ROBOT_MODE, true);
    }

    public void setRobotMode(boolean robotMode) {
        properties.put(HINT_ROBOT_MODE, robotMode);
    }

    // If not assigned, secret mode returns false
    public boolean isSecretMode() {
        return (boolean) properties.getOrDefault(HINT_SECRET_MODE, false);
    }

    public void setSecretMode(boolean robotMode) {
        properties.put(HINT_SECRET_MODE, robotMode);
    }
}
