package com.harium.suneidesis.knowledge.linguistic.core.nlp.tokenizer;

public class BaseTokenizer implements Tokenizer {

    public String[] tokenize(String query) {
        String text = clearPonctuation(query);
        String[] tokens = text.split(" ");

        return tokens;
    }

    public static String clearPonctuation(String text) {
        return text.replaceAll("\\.", "")
                .replaceAll(",", "")
                .replaceAll("!", "")
                .replaceAll("\\?", "");
    }

}
