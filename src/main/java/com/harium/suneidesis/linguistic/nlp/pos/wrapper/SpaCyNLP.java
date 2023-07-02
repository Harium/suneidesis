package com.harium.suneidesis.linguistic.nlp.pos.wrapper;

import com.harium.aal.core.Processor;
import com.harium.suneidesis.linguistic.nlp.NLP;
import com.harium.suneidesis.linguistic.nlp.Token;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.linguistic.nlp.pos.converter.SpaCyUniversalTagConverter;
import com.harium.suneidesis.linguistic.nlp.pos.converter.StringToTagConverter;

import java.util.StringJoiner;

public class SpaCyNLP implements NLP {

    private final String languageModel;

    private final StringToTagConverter converter;

    public SpaCyNLP(String languageModel) {
        this(languageModel, new SpaCyUniversalTagConverter());
    }

    public SpaCyNLP(String languageModel, StringToTagConverter converter) {
        this.languageModel = languageModel;
        this.converter = converter;
    }


    @Override
    public Token[] nlp(String sentence) {
        String[] cmd = {"/bin/sh", "-c", "cd src/main/python/; python nlp.py " + languageModel + " '" + sentence + "'"};
        String output = Processor.runOutput(cmd);

        String[] lines = output.split("\n");
        Token[] result = new Token[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String[] tags = line.split(" ");

            String word = tags[0];
            String lemma = tags[1];
            Tag tag = converter.convert(tags[2]);

            result[i] = new Token(word, lemma, tag);
        }

        return result;
    }

}
