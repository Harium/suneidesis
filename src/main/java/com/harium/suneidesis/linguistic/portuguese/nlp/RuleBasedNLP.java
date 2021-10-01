package com.harium.suneidesis.linguistic.portuguese.nlp;

import com.harium.suneidesis.linguistic.nlp.Lemmatizer;
import com.harium.suneidesis.linguistic.nlp.NLP;
import com.harium.suneidesis.linguistic.nlp.POSTagger;
import com.harium.suneidesis.linguistic.nlp.Tokenizer;
import com.harium.suneidesis.linguistic.nlp.pos.TagPair;
import com.harium.suneidesis.linguistic.portuguese.nlp.lemmatization.RuleBasedLemmatizer;
import com.harium.suneidesis.linguistic.portuguese.nlp.pos.RuleBasedPOSTagger;
import com.harium.suneidesis.linguistic.portuguese.nlp.tokenization.RuleBasedDatabaseTokenizer;
import com.harium.suneidesis.repository.word.WordKnowledgeBase;

public class RuleBasedNLP implements NLP {

    private Tokenizer tokenizer;
    private POSTagger tagger;
    private Lemmatizer lemmatizer;

    public RuleBasedNLP(WordKnowledgeBase database) {
        tagger = new RuleBasedPOSTagger(database);
        tokenizer = new RuleBasedDatabaseTokenizer(database);
        lemmatizer = new RuleBasedLemmatizer(database);
    }

    public TagPair[] posTag(String sentence) {
        return tagger.posTag(tokenizer.tokenize(sentence));
    }

    @Override
    public String lemmatize(String word) {
        return lemmatizer.lemmatize(word);
    }

}
