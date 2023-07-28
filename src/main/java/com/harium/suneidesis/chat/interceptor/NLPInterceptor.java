package com.harium.suneidesis.chat.interceptor;

import com.harium.suneidesis.chat.Interceptor;
import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.chat.input.InputContext;
import com.harium.suneidesis.chat.output.Output;
import com.harium.suneidesis.linguistic.nlp.NLP;
import com.harium.suneidesis.linguistic.nlp.Token;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;

import java.util.HashMap;
import java.util.Map;

public class NLPInterceptor implements Interceptor {

    public static final String PROPERTY_NLP = "nlp";
    private static final String DEFAULT_LANGUAGE = "default_lang";

    protected Map<String, NLP> nlpMap = new HashMap<>();

    public NLPInterceptor() {

    }

    public NLPInterceptor(NLP nlp) {
        this(DEFAULT_LANGUAGE, nlp);
    }

    public NLPInterceptor(String language, NLP nlp) {
        if (!DEFAULT_LANGUAGE.equals(language)) {
            nlpMap.put(DEFAULT_LANGUAGE, nlp);
        }
        registerNLP(language, nlp);
    }

    public void registerNLP(String language, NLP nlp) {
        if (language != null) {
            nlpMap.put(language, nlp);
        }
    }

    @Override
    public void preParsing(InputContext input, Output output) {
        String sentence = input.getOriginalSentence();
        String language = input.getLanguage();

        NLP nlp = getNLP(language);
        if (nlp == null) {
            return;
        }

        // Process Part Of Speech (POS) tags, lemma, etc.
        Token[] tokens = nlp.nlp(sentence);
        input.getProperties().put(PROPERTY_NLP, tokens);
    }

    protected NLP getNLP(String language) {
        NLP nlp = nlpMap.get(language);
        if (nlp == null) {
            return nlpMap.get(DEFAULT_LANGUAGE);
        }
        return nlp;
    }

    @Override
    public void postParsing(InputContext input, Output output, Parser parser) {

    }

    public static boolean tokensContains(Token[] tokens, String word, Tag tag) {
        if (tokens == null) {
            return false;
        }
        for (Token token : tokens) {
            if (word.equals(token.word) && tag.equals(token.tag)) {
                return true;
            }
        }
        return false;
    }

}