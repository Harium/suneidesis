package com.harium.suneidesis.linguistic.portuguese.nlp.lemmatization;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.linguistic.nlp.lemmatization.DatabaseLemmatizer;
import com.harium.suneidesis.repository.word.WordKnowledgeBase;

import java.util.Iterator;

/**
 * Rule base lemmatizer with a few rules
 */
public class RuleBasedLemmatizer extends DatabaseLemmatizer {

    public RuleBasedLemmatizer(WordKnowledgeBase database) {
        super(database);
    }

    @Override
    public String lemmatize(String word) {
        Iterator<Word> w = database.getWords(word);

        if (!w.hasNext()) {
            if (word.endsWith("s")) {
               return word.substring(0, word.length() - 1);
            }
            return word;
        }
        Concept lemma = w.next().getLemmaConcept();
        return lemma.getName();
    }

}
