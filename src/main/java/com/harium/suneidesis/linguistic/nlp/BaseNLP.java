package com.harium.suneidesis.linguistic.nlp;

import com.harium.suneidesis.linguistic.nlp.pos.TagPair;

public class BaseNLP implements NLP {

    protected Tokenizer tokenizer;
    protected POSTagger tagger;
    protected Lemmatizer lemmatizer;

    @Override
    public Token[] nlp(String sentence) {

        String[] tokens = tokenizer.tokenize(sentence);

        Token[] result = new Token[tokens.length];

        TagPair[] tags = tagger.posTag(tokens);

        for (int i = 0; i < tags.length; i++) {
            String word = tokens[i];
            TagPair pair = tags[i];
            String lemma = lemmatizer.lemmatize(word);
            result[i] = new Token(word, lemma, pair.getTag());
        }

        return result;
    }
}
