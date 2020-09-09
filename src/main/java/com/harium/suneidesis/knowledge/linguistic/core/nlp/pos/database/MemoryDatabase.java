package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.database;

import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.Tag;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model.Verb;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model.VerbConjugation;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model.Word;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model.WordModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryDatabase implements WordDatabase {

    // Key is the pure word
    Map<String, List<Word>> words = new HashMap<>();
    // Key is the id and value the word
    Map<String, Word> wordIds = new HashMap<>();
    Map<String, Verb> verbs = new HashMap<>();
    Map<String, VerbConjugation> verbConjugations = new HashMap<>();

    private long id = 0;

    public MemoryDatabase() {
        super();
    }

    protected void addVerb(String word, String lemma, Tag tag) {
        // Add word to database
        add(word, tag);

        String lemmaId;
        if (!words.containsKey(lemma)) {
            lemmaId = add(lemma, Tag.VERB);
        } else {
            lemmaId = words.get(lemma).get(0).getWordId();
        }

        Verb v = new Verb(lemmaId);
        verbs.put(word, v);
    }

    protected String add(String word, Tag tag) {
        Word w = new Word();
        w.setWord(word);
        w.setTag(tag.name());

        return save(w);
    }

    private String generateId() {
        id++;
        return Long.toString(id);
    }

    @Override
    public String save(Word w) {
        String id = generateId();
        w.setWordId(id);
        List<Word> words = this.words.computeIfAbsent(w.getWord(), k -> new ArrayList<>());
        words.add(w);

        wordIds.put(id, w);
        return id;
    }

    @Override
    public String save(Verb verb) {
        verbs.put(verb.getWordId(), verb);
        return verb.getWordId();
    }

    @Override
    public String save(VerbConjugation verbConjugation) {
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
    public WordModel findModelByWordIdAndTag(String wordId, String tag) {
        Word w = wordIds.get(wordId);
        if (Tag.VERB.name().equals(w.getTag())) {
            return verbs.get(w.getWord());
        }
        return null;
    }

    @Override
    public Verb findVerbByWordId(String wordId) {
        Word w = wordIds.get(wordId);
        if (w == null) {
            return null;
        }
        return verbs.get(w.getWordId());
    }

    @Override
    public VerbConjugation findVerbConjugationByWordId(String wordId) {
        Word w = wordIds.get(wordId);
        if (w == null) {
            return null;
        }
        return verbConjugations.get(w.getWordId());
    }

    public String addVerb(String verbWord, String prepositions, String transitivity) {
        // Save on the index database
        Word word = new Word();
        word.setTag(Tag.VERB.name());
        word.setWord(verbWord);
        String wordId = save(word);

        Verb verb = new Verb();
        verb.setWordId(wordId);
        verb.setPrepositions(prepositions);
        verb.setTransitivity(transitivity);

        return save(verb);
    }

    public String addVerbConjugation(String verbWord, String infinitiveWordId, Tag tag, String tense, String person) {
        Word w = new Word();
        w.setTag(tag.name());
        w.setWord(verbWord);
        w.setLemmaId(infinitiveWordId);
        String wordId = save(w);

        VerbConjugation conjugation = new VerbConjugation();
        conjugation.setWordId(wordId);
        conjugation.setTense(tense);
        conjugation.setPerson(person);

        return save(conjugation);
    }
}
