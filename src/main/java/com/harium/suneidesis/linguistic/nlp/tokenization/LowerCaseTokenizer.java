package com.harium.suneidesis.linguistic.nlp.tokenization;

import com.harium.suneidesis.linguistic.nlp.Tokenizer;

import static com.harium.suneidesis.linguistic.nlp.tokenization.BaseTokenizer.handlePunctuation;

public class LowerCaseTokenizer implements Tokenizer {

    public String[] tokenize(String query) {
        String text = handlePunctuation(query).toLowerCase();
        String[] tokens = text.split(" ");
        return tokens;
    }

}
