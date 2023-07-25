package com.harium.suneidesis.linguistic.nlp.pos.wrapper;

import com.harium.aal.core.Processor;
import com.harium.suneidesis.linguistic.nlp.POSTagger;
import com.harium.suneidesis.linguistic.nlp.pos.TagPair;
import com.harium.suneidesis.linguistic.nlp.pos.converter.SpaCyUniversalTagConverter;
import com.harium.suneidesis.linguistic.nlp.pos.converter.StringToTagConverter;

import java.util.StringJoiner;

public class SpaCyPOSTagger implements POSTagger {

    private final String languageModel;

    private final StringToTagConverter converter;

    public SpaCyPOSTagger(String languageModel) {
        this(languageModel, new SpaCyUniversalTagConverter());
    }

    public SpaCyPOSTagger(String languageModel, StringToTagConverter converter) {
        this.languageModel = languageModel;
        this.converter = converter;
    }

    @Override
    public TagPair[] posTag(String[] tokens) {
        String sentence = joinTokens(tokens);
        String[] cmd = {"/bin/sh", "-c", "cd src/main/python/; python nlp.py " + languageModel + " '" + sentence + "'"};
        String output = Processor.runOutput(cmd);

        String[] lines = output.split("\n");
        TagPair[] result = new TagPair[lines.length];

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String[] tags = line.split(" ");
            result[i] = new TagPair(tags[0], converter.convert(tags[2]));
        }

        return result;
    }

    private String joinTokens(String[] tokens) {
        StringJoiner joiner = new StringJoiner(" ");
        for (String token : tokens) {
            joiner.add(token);
        }
        return joiner.toString();
    }

}
