package com.harium.suneidesis.chat.interceptor;

import com.harium.suneidesis.chat.Interceptor;
import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.output.Output;

public class QuestionMarkRemoverInterceptor implements Interceptor {

    @Override
    public void intercept(InputContext input, Output output) {
        // Remove Question Mark
        String clean = clearSentence(input.getSentence());
        input.setSentence(clean);
    }

    private String clearSentence(String sentence) {
        if (sentence == null) {
            return sentence;
        }
        return sentence.replaceAll("\\?", "").trim();
    }

}
