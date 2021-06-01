package com.harium.suneidesis.repository.word;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.repository.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.dizitart.no2.filters.Filters.eq;

public class WordKnowledgeBase implements Repository<Concept> {

    protected final KnowledgeBase knowledgeBase;

    public WordKnowledgeBase(KnowledgeBase knowledgeBase) {
        this.knowledgeBase = knowledgeBase;
    }

    public void addWord(String word, String tag) {
        knowledgeBase.save(new Word(word, tag));
    }

    public void addWord(String word, String lemma, String tag) {
        Word w = new Word(word, tag);
        w.setLemma(new Word(lemma));

        knowledgeBase.save(w);
    }

    public List<Word> getWords(String name) {
        return Collections.emptyList();
        //knowledgeBase.find(eq(Attributes.ATTRIBUTE_NAME, name));
    }

    @Override
    public Map<String, Concept> getAll() {
        return knowledgeBase.getAll();
    }

    @Override
    public Collection<Concept> getValues() {
        return knowledgeBase.getValues();
    }

    @Override
    public Concept insert(String key, Concept concept) {
        return knowledgeBase.insert(key, concept);
    }

    @Override
    public void save(Concept concept) {
        knowledgeBase.save(concept);
    }

    @Override
    public Concept get(String key) {
        return knowledgeBase.get(key);
    }

    @Override
    public boolean contains(String key) {
        return knowledgeBase.contains(key);
    }

    @Override
    public void clear() {
        knowledgeBase.clear();
    }

    @Override
    public void close() {
        knowledgeBase.close();
    }

    @Override
    public boolean isClosed() {
        return knowledgeBase.isClosed();
    }
}
