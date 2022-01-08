package com.harium.suneidesis.repository.word;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.concept.Language;
import com.harium.suneidesis.concept.attribute.Attributes;
import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.concept.word.WordVerb;
import com.harium.suneidesis.concept.word.WordVerbConjugation;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.repository.KnowledgeBaseRepository;
import com.harium.suneidesis.repository.RepositoryCursor;
import com.harium.suneidesis.repository.nitrite.RepositoryConceptCursorToWordMapper;
import org.dizitart.no2.Filter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.dizitart.no2.filters.Filters.and;
import static org.dizitart.no2.filters.Filters.eq;
import static org.dizitart.no2.filters.Filters.or;

public class WordKnowledgeBase implements KnowledgeBaseRepository<Concept> {

    protected final KnowledgeBase knowledgeBase;

    public WordKnowledgeBase(KnowledgeBase knowledgeBase) {
        this.knowledgeBase = knowledgeBase;
    }

    public Word addWord(Word word) {
        knowledgeBase.save(word);
        return word;
    }

    public Word addWord(String word, String tag) {
        Word w = new Word(word, tag);
        knowledgeBase.save(w);
        return w;
    }

    public Word addWord(String word, String lemma, String tag) {
        Word w = new Word(word, tag);
        w.setLemma(new Word(lemma));

        knowledgeBase.save(w);
        return w;
    }

    public WordVerb addVerb(String verb, String prepositions, String transitivity) {
        WordVerb wordVerb = new WordVerb(verb);
        wordVerb.setLemma(new Word(verb));
        wordVerb.setPrepositions(new Word(prepositions));
        wordVerb.setTransitivity(new Word(transitivity));
        knowledgeBase.save(wordVerb);
        return wordVerb;
    }

    public void addVerbConjugation(String word, WordVerb verb, Tag tag, String tense, String person) {
        addVerbConjugation(word, verb, tag.name(), tense, person);
    }

    public void addVerbConjugation(String word, Word verbLemma, String tag, String tense, String person) {
        WordVerbConjugation verbConjugation = new WordVerbConjugation(word);
        verbConjugation.setLemma(verbLemma);
        verbConjugation.setTag(tag);
        verbConjugation.setTense(new Word(tense));
        verbConjugation.setPerson(new Word(person));
        knowledgeBase.save(verbConjugation);
    }

    public void addVerbConjugation(String word, Word verbLemma, String tag, String tense, String person, String mood) {
        WordVerbConjugation verbConjugation = new WordVerbConjugation(word);
        verbConjugation.setLemma(verbLemma);
        verbConjugation.setTag(tag);
        verbConjugation.setTense(new Word(tense));
        verbConjugation.setPerson(new Word(person));
        verbConjugation.setMood(new Word(mood));
        knowledgeBase.save(verbConjugation);
    }

    public Iterator<Word> getWords(String name) {
        RepositoryCursor<Concept> cursor = knowledgeBase.find(filterName(name));
        return new RepositoryConceptCursorToWordMapper(cursor).iterator();
    }

    @Override
    public Map<String, Concept> getAll() {
        return knowledgeBase.getAll();
    }

    @Override
    public Iterator<Concept> iterator() {
        return knowledgeBase.iterator();
    }

    @Override
    public Concept save(String key, Concept concept) {
        return knowledgeBase.save(key, concept);
    }

    @Override
    public String save(Concept concept) {
        return knowledgeBase.save(concept);
    }

    @Override
    public Word get(String key) {
        Concept concept = knowledgeBase.get(key);
        return new Word(concept.getName()).wrap(concept);
    }

    @Override
    public boolean contains(String key) {
        return knowledgeBase.contains(key);
    }

    @Override
    public long count() {
        return knowledgeBase.count();
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

    public KnowledgeBase getKnowledgeBase() {
        return knowledgeBase;
    }

    @Override
    public RepositoryCursor<Concept> findAll() {
        return knowledgeBase.findAll();
    }

    @Override
    public RepositoryCursor<Concept> find(Filter filter) {
        return knowledgeBase.find(filter);
    }

    public Word findById(String id) {
        Concept concept = knowledgeBase.findById(id);
        if (concept == null) {
            return null;
        }

        return new Word(concept.getName()).wrap(concept);
    }

    public WordVerb findVerb(String name) {
        Iterator<Concept> result = knowledgeBase.find(and(filterName(name),
                                                          filterTag(Tag.VERB.name()))).iterator();

        if (result.hasNext()) {
            Concept concept = result.next();
            return new WordVerb(concept.getName()).wrap(concept);
        }

        return null;
    }

    public Concept findVerbOrConjugation(String name) {
        Iterator<Concept> result = knowledgeBase.find(and(filterName(name),
                                                          filterTags(Tag.VERB, Tag.VERB_CONJUGATION))).iterator();

        if (result.hasNext()) {
            return result.next();
        }

        return ConceptType.UNKNOWN;
    }

    public List<Word> findByTag(Tag tag) {
        return findAsListWords(filterTag(tag.name()));
    }

    public List<Word> findByTags(Tag ... tags) {
        return findAsListWords(filterTags(tags));
    }

    public List<Word> findByName(String name) {
        return findAsListWords(filterName(name));
    }

    public List<Word> findByNameAndTag(String name, Tag tag) {
        Filter filter = and(filterName(name), filterTag(tag.name()));
        return findAsListWords(filter);
    }

    public Concept findLanguageByCode(String languageCode) {
        Iterator<Concept> result = knowledgeBase.find(and(eq(Concept.ATTRIBUTE_TYPE, ConceptType.LANGUAGE),
                                                          eq(Language.ATTRIBUTE_CODE, languageCode))).iterator();

        if (result.hasNext()) {
            Concept concept = result.next();
            return new Language(concept.getName()).wrap(concept);
        }

        return ConceptType.UNKNOWN;
    }

    private Filter filterName(String name) {
        return eq(Attributes.ATTRIBUTE_NAME, name);
    }

    private Filter filterTag(String tag) {
        return eq(Word.ATTRIBUTE_TAG, tag);
    }

    private Filter filterTags(Tag ... tags) {
        String[] tagNames = new String[tags.length];

        for (int i = 0; i < tags.length; i++) {
            tagNames[i] = tags[i].name();
        }

        return filterTags(tagNames);
    }

    private Filter filterTags(String ... tags) {
        Filter[] filters = new Filter[tags.length];

        for (int i = 0; i < tags.length; i++) {
            filters[i] = eq(Word.ATTRIBUTE_TAG, tags[i]);
        }

        return or(filters);
    }

    private List<Word> findAsListWords(Filter filter) {
        Iterator<Concept> result = knowledgeBase.find(filter).iterator();

        List<Word> words = new ArrayList<>();
        while (result.hasNext()) {
            Concept concept = result.next();
            words.add(new Word(concept.getName()).wrap(concept));
        }

        return words;
    }
}
