package com.harium.suneidesis.knowledge.linguistic.core.tokenization;

import static com.harium.suneidesis.knowledge.linguistic.core.tokenization.BaseTokenizer.clearPonctuation;

public class LowerCaseTokenizer implements Tokenizer {

    public String[] tokenize(String query) {
        String text = clearPonctuation(query).toLowerCase();
        String[] tokens = text.split(" ");
        return tokens;
    }

}
