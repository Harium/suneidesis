package com.harium.suneidesis.linguistic.portuguese.nlp;

import com.harium.suneidesis.linguistic.nlp.NLP;
import com.harium.suneidesis.linguistic.nlp.lemmatization.DatabaseLemmatizer;
import com.harium.suneidesis.linguistic.nlp.pos.TagPair;
import com.harium.suneidesis.linguistic.portuguese.nlp.lemmatization.RuleBasedLemmatizer;
import com.harium.suneidesis.linguistic.portuguese.nlp.pos.RuleBasedPOSTagger;
import com.harium.suneidesis.linguistic.portuguese.nlp.tokenization.RuleBasedTokenizer;
import com.harium.suneidesis.repository.word.WordKnowledgeBase;

public class RuleBasedNLP implements NLP {

    private RuleBasedTokenizer tokenizer = new RuleBasedTokenizer();
    private RuleBasedPOSTagger tagger;
    private DatabaseLemmatizer lemmatizer;

    public RuleBasedNLP(WordKnowledgeBase database) {
        tagger = new RuleBasedPOSTagger(database);
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
