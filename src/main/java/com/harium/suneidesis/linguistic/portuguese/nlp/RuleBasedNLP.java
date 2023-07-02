package com.harium.suneidesis.linguistic.portuguese.nlp;

import com.harium.suneidesis.linguistic.nlp.BaseNLP;
import com.harium.suneidesis.linguistic.portuguese.nlp.lemmatization.RuleBasedLemmatizer;
import com.harium.suneidesis.linguistic.portuguese.nlp.pos.RuleBasedPOSTagger;
import com.harium.suneidesis.linguistic.portuguese.nlp.tokenization.RuleBasedDatabaseTokenizer;
import com.harium.suneidesis.repository.word.WordKnowledgeBase;

public class RuleBasedNLP extends BaseNLP {

    public RuleBasedNLP(WordKnowledgeBase database) {
        tagger = new RuleBasedPOSTagger(database);
        tokenizer = new RuleBasedDatabaseTokenizer(database);
        lemmatizer = new RuleBasedLemmatizer(database);
    }
}
