package com.harium.suneidesis.linguistic.repository;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.concept.word.WordVerb;
import com.harium.suneidesis.concept.word.WordVerbConjugation;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.repository.listener.RepositoryListener;

import java.util.List;

public abstract class WordKnowledgeBase extends KnowledgeBase implements WordRepository, RepositoryListener {

    public WordKnowledgeBase(String name) {
        super(name);
        listeners.add(this);
    }

    protected abstract String index(Word w);

    protected abstract String index(WordVerb verb);

    protected abstract String index(WordVerbConjugation verbConjugation);

    public abstract List<Word> getWords(String key);

    protected abstract void addVerb(String word, String tag);

    public WordVerb addVerb(String verbWord, String prepositions, String transitivity) {
        WordVerb verb = new WordVerb(verbWord);
        verb.setLemma(verb);
        verb.setPrepositions(new Word(prepositions));
        verb.setTransitivity(new Word(transitivity));
        index(verb);

        return verb;
    }

    public String addVerbConjugation(String word, WordVerb verb, Tag tag, String tense, String person) {
        Word infinitive = verb;
        /*Word w = new Word(verbWord);
        w.setTag(tag.name());
        w.setLemma(new Word(infinitiveWordId));
        String wordId = save(w);*/

        WordVerbConjugation conjugation = new WordVerbConjugation(word);
        conjugation.setLemma(verb);
        conjugation.setTag(tag.name());
        conjugation.setTense(new Word(tense));
        conjugation.setPerson(new Word(person));

        return index(conjugation);
    }

    @Override
    public void onInsert(String key, Concept concept) {
        if (concept instanceof WordVerb) {
            index((WordVerb)concept);
        } else if (concept instanceof WordVerbConjugation) {
            index((WordVerbConjugation)concept);
        } else if (concept instanceof Word) {
            index((Word)concept);
        } else if (ConceptType.WORD.getName().equals(concept.getType().getName())) {
            //if (contains(key)) {
                Word word = WordFactory.buildWord(concept);
                onInsert(key, word);
            //}
        }
    }
}
