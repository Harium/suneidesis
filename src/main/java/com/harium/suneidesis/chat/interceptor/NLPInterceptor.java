package com.harium.suneidesis.chat.interceptor;

import com.harium.suneidesis.chat.Interceptor;
import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.output.Output;
import com.harium.suneidesis.linguistic.nlp.NLP;
import com.harium.suneidesis.linguistic.nlp.pos.TagPair;

public class NLPInterceptor implements Interceptor {

    protected NLP nlp;

    public NLPInterceptor(NLP nlp) {
        this.nlp = nlp;
    }

    @Override
    public void preParsing(InputContext input, Output output) {
        String sentence = input.getOriginalSentence();

        // POSTag
        TagPair[] tags = nlp.posTag(sentence);
        // Replace words by lemma
        for (TagPair tagPair : tags) {
            String lemma = nlp.lemmatize(tagPair.getWord());
            tagPair.setWord(lemma);
        }
    }

    @Override
    public void postParsing(InputContext input, Output output, Parser parser) {

    }
}
