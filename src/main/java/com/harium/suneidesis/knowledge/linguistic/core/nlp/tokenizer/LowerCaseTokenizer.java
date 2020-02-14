package com.harium.suneidesis.knowledge.linguistic.core.nlp.tokenizer;

import static com.harium.suneidesis.knowledge.linguistic.core.nlp.tokenizer.BaseTokenizer.clearPonctuation;

public class LowerCaseTokenizer implements Tokenizer {

    public String[] tokenize(String query) {
        String text = clearPonctuation(query).toLowerCase();
        String[] tokens = text.split(" ");
        return tokens;
    }

}
