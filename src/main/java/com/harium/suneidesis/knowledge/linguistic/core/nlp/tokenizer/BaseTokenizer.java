package com.harium.suneidesis.knowledge.linguistic.core.nlp.tokenizer;

public class BaseTokenizer implements Tokenizer {

    public String[] tokenize(String query) {
        String text = handlePonctuation(query);
        // remove empty tokens
        String[] tokens = text.split("\\s+");
        return tokens;
    }

    public static String handlePonctuation(String text) {
        return text.replaceAll("\\.", " \\. ")
                .replaceAll(",", " , ")
                .replaceAll("!", " ! ")
                .replaceAll("\\?", " \\? ");
    }

}
