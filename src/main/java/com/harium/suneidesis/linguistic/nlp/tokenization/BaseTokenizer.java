package com.harium.suneidesis.linguistic.nlp.tokenization;

import com.harium.suneidesis.linguistic.nlp.Tokenizer;

public class BaseTokenizer implements Tokenizer {

    public String[] tokenize(String query) {
        String text = handlePunctuation(query);
        // remove empty tokens
        String[] tokens = text.split("\\s+");
        return tokens;
    }

    public static String handlePunctuation(String text) {
        return text.replaceAll("\\.", " \\. ")
                .replaceAll(",", " , ")
                .replaceAll("!", " ! ")
                .replaceAll("\\?", " \\? ");
    }

}
