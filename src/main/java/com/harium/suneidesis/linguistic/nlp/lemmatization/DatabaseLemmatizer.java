package com.harium.suneidesis.linguistic.nlp.lemmatization;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.linguistic.nlp.Lemmatizer;
import com.harium.suneidesis.repository.word.WordKnowledgeBase;

import java.util.Iterator;

public class DatabaseLemmatizer implements Lemmatizer {

    protected WordKnowledgeBase database;

    public DatabaseLemmatizer(WordKnowledgeBase database) {
        this.database = database;
    }

    @Override
    public String lemmatize(String word) {
        Iterator<Word> w = database.getWords(word);

        if (!w.hasNext()) {
            return word;
        }
        Concept lemma = w.next().getLemmaConcept();
        return lemma.getName();
    }

}
