package com.harium.suneidesis.knowledge.linguistic.core.storage;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Fact;
import com.harium.suneidesis.knowledge.MemoryRepository;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.Tag;
import com.harium.suneidesis.concept.word.WordVerb;
import com.harium.suneidesis.concept.word.WordVerbConjugation;
import com.harium.suneidesis.concept.word.Word;

import java.util.*;

import static com.harium.suneidesis.knowledge.linguistic.core.storage.Source.*;

public class MemoryWordRepository extends MemoryRepository implements WordRepository {

    // Key is the pure word
    Map<String, List<Word>> words = new HashMap<>();
    // Key is the fact id and value the word
    Map<String, Word> wordIds = new HashMap<>();
    Map<String, WordVerb> verbs = new HashMap<>();
    Map<String, WordVerbConjugation> verbConjugations = new HashMap<>();

    public MemoryWordRepository(String name) {
        super(name);
    }

    protected String add(String word, Tag tag) {
        Word w = new Word(word);
        w.setTag(tag.name());

        return save(w);
    }

    @Override
    public String save(Word w) {
        String factId = add(w);
        w.setId(factId);
        List<Word> words = this.words.computeIfAbsent(w.getName(), k -> new ArrayList<>());
        words.add(w);
        wordIds.put(w.getId(), w);
        return factId;
    }

    @Override
    protected Fact wrap(Concept info) {
        Fact wrap = super.wrap(info);
        wrap.acquisitionMedium(MEDIUM_TEXT);
        wrap.acquisitionMethod(METHOD_INPUT);
        return wrap;
    }

    @Override
    public String save(WordVerb verb) {
        String verbId = save((Word)verb);
        verbs.put(verbId, verb);
        return verbId;
    }

    protected void addVerb(String word, String lemma, Tag tag) {
        // Add word to database
        add(word, tag);

        String lemmaId;
        if (!words.containsKey(lemma)) {
            lemmaId = add(lemma, Tag.VERB);
        } else {
            lemmaId = words.get(lemma).get(0).getId();
        }

        WordVerb v = new WordVerb(lemmaId);
        verbs.put(word, v);
    }

    @Override
    public String save(WordVerbConjugation verbConjugation) {
        save((Word)verbConjugation);
        verbConjugations.put(verbConjugation.getId(), verbConjugation);
        return verbConjugation.getId();
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
        return verbs.get(w.getId());
    }

    @Override
    public WordVerbConjugation findVerbConjugationByWordId(String wordId) {
        Word w = wordIds.get(wordId);
        if (w == null) {
            return null;
        }
        return verbConjugations.get(w.getId());
    }

    public WordVerb addVerb(String verbWord, String prepositions, String transitivity) {
        WordVerb verb = new WordVerb(verbWord);
        verb.setLemma(verb);
        verb.setPrepositions(new Word(prepositions));
        verb.setTransitivity(new Word(transitivity));
        save(verb);

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

        return save(conjugation);
    }

}
