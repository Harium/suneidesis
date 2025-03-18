package com.harium.suneidesis.chat.interceptor;

import com.harium.suneidesis.chat.Interceptor;
import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.output.Output;
import com.harium.suneidesis.chat.Parser;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class SpellingInterceptor implements Interceptor {

    private static final Map<String, String> spellingMap = new HashMap<>();

    static {
        spellingMap.put("dot", ".");
        spellingMap.put("com", "com");
        spellingMap.put("see", "C");
        spellingMap.put("bee", "B");
        spellingMap.put("are", "R");
        spellingMap.put("at", "@");
        spellingMap.put("plus", "+");
        spellingMap.put("hashtag", "#");
    }

    public static void addSpellingRule(String key, String value) {
        spellingMap.put(key.toLowerCase(), value);
    }

    @Override
    public void preParsing(InputContext input, Output output) {
        String sentence = input.getSentence();
        if (sentence != null) {
            input.setSentence(intercept(sentence));
        }
    }

    @Override
    public void postParsing(InputContext input, Output output, Parser parser) {
        // No post-processing needed for now
    }

    public String intercept(String input) {
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b");
        Matcher matcher = pattern.matcher(input);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            String word = matcher.group(1).toLowerCase();
            String replacement = spellingMap.getOrDefault(word, matcher.group(1));
            matcher.appendReplacement(result, replacement);
        }
        matcher.appendTail(result);
        return result.toString();
    }
}
