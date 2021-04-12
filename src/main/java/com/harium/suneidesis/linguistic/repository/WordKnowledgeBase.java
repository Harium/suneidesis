package com.harium.suneidesis.linguistic.repository;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.concept.word.WordVerb;
import com.harium.suneidesis.concept.word.WordVerbConjugation;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.repository.KnowledgeBase;

public abstract class WordKnowledgeBase extends KnowledgeBase implements WordRepository {

    public WordKnowledgeBase(String name) {
        super(name);
    }

    @Override
    public void postSet(String key, Concept concept) {
        if (concept instanceof Word) {
            if (contains(key)) {
                index((Word) concept);
            }
        }
    }

    protected abstract String index(Word w);

    protected abstract String index(WordVerb verb);

    protected abstract String index(WordVerbConjugation verbConjugation);

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
}
