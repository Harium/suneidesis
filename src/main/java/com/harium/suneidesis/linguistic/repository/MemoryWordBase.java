package com.harium.suneidesis.linguistic.repository;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.concept.word.WordVerb;
import com.harium.suneidesis.concept.word.WordVerbConjugation;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.repository.MemoryKnowledgeBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryWordBase extends WordKnowledgeBase implements WordRepository {

    // Delegate
    private MemoryKnowledgeBase base = new MemoryKnowledgeBase();

    // Key is the pure word
    protected Map<String, List<Word>> words = new HashMap<>();
    // Key is the fact id and value the word
    protected Map<String, Word> wordIds = new HashMap<>();
    protected Map<String, WordVerb> verbs = new HashMap<>();
    protected Map<String, WordVerbConjugation> verbConjugations = new HashMap<>();

    public MemoryWordBase(String name) {
        super(name);
    }

    @Override
    public void set(String key, Concept concept) {
        base.set(key, concept);
        postSet(key, concept);
    }

    @Override
    public void postSet(String key, Concept concept) {
        if (concept instanceof Word) {
            index((Word) concept);
        }
    }

    @Override
    public void merge(KnowledgeBase concepts) {
        base.merge(concepts);
    }

    @Override
    public Map<String, Concept> getAll() {
        return base.getAll();
    }

    @Override
    public Concept get(String key) {
        return base.get(key);
    }

    @Override
    public boolean contains(String key) {
        return base.contains(key);
    }

    public String addWord(String word, Tag tag) {
        Word w = new Word(word);
        w.setTag(tag.name());
        add(w);

        return index(w);
    }

    public String index(Word w) {
        //String factId = add(w);
        String factId = w.getIdText();
        w.setWordId(factId);
        List<Word> words = this.words.computeIfAbsent(w.getName(), k -> new ArrayList<>());
        words.add(w);
        wordIds.put(w.getWordId(), w);
        return factId;
    }

    @Override
    public String index(WordVerb verb) {
        String verbId = index((Word) verb);
        verbs.put(verb.getWordId(), verb);
        return verbId;
    }

    protected void addVerb(String word, String lemma, Tag tag) {
        // Add word to database
        addWord(word, tag);

        String lemmaId;
        if (!words.containsKey(lemma)) {
            lemmaId = addWord(lemma, Tag.VERB);
        } else {
            lemmaId = words.get(lemma).get(0).getWordId();
        }

        WordVerb v = new WordVerb(lemmaId);
        //save(v);
        verbs.put(word, v);
    }

    @Override
    public String index(WordVerbConjugation verbConjugation) {

        index((Word) verbConjugation);
        verbConjugations.put(verbConjugation.getWordId(), verbConjugation);
        return verbConjugation.getWordId();
    }

    @Override
    public List<Word> findAllWords(String word) {
        return words.get(word);
    }

    @Override
    public Word findWordById(String wordId) {
        return wordIds.get(wordId);
    }

    @Override
    public Word findModelByWordIdAndTag(String wordId, String tag) {
        Word w = wordIds.get(wordId);
        if (Tag.VERB.name().equals(w.getTagWord())) {
            return verbs.get(w.getName());
        }
        return null;
    }

    @Override
    public WordVerb findVerbByWordId(String wordId) {
        Word w = wordIds.get(wordId);
        if (w == null) {
            return null;
        }
        return verbs.get(w.getWordId());
    }

    @Override
    public WordVerbConjugation findVerbConjugationByWordId(String wordId) {
        Word w = wordIds.get(wordId);
        if (w == null) {
            return null;
        }
        return verbConjugations.get(w.getWordId());
    }

    public WordVerb addVerb(String verbWord, String prepositions, String transitivity) {
        WordVerb verb = new WordVerb(verbWord);
        verb.setLemma(verb);
        verb.setPrepositions(new Word(prepositions));
        verb.setTransitivity(new Word(transitivity));
        add(verb);
        index(verb);

        return verb;
    }

    public String addVerbConjugation(String word, WordVerb verb, Tag tag, String tense, String person) {
        //Word infinitive = verb;
        /*Word w = new Word(verbWord);
        w.setTag(tag.name());
        w.setLemma(new Word(infinitiveWordId));
        String wordId = save(w);*/
        WordVerbConjugation conjugation = new WordVerbConjugation(word);
        conjugation.setLemma(verb);
        conjugation.setTag(tag.name());
        conjugation.setTense(new Word(tense));
        conjugation.setPerson(new Word(person));
        add(conjugation);

        return index(conjugation);
    }

}
