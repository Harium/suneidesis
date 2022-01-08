package com.harium.suneidesis.repository.word;

import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.concept.word.WordVerb;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.repository.MemoryKnowledgeBase;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class WordKnowledgeBaseTest {

    private WordKnowledgeBase wordKnowledgeBase;

    @Before
    public void setUp() {
        wordKnowledgeBase = new WordKnowledgeBase(new MemoryKnowledgeBase());
    }

    @Test
    public void testFindByName() {
        Word concept = new Word("word");
        wordKnowledgeBase.addWord(concept);

        List<Word> words = wordKnowledgeBase.findByName(concept.getName());
        assertEquals(1, words.size());
    }

    @Test
    public void testFindByName_WordAsText() {
        String wordName = "word";
        wordKnowledgeBase.addWord(wordName, Tag.NOUN.name());

        List<Word> words = wordKnowledgeBase.findByName(wordName);
        assertEquals(1, words.size());
    }

    @Test
    public void testFindByName_MultipleNames() {
        Word concept1 = new Word("name", Tag.NOUN);
        Word concept2 = new Word("name", Tag.ADJECTIVE);
        wordKnowledgeBase.addWord(concept1);
        wordKnowledgeBase.addWord(concept2);

        List<Word> words = wordKnowledgeBase.findByName(concept1.getName());
        assertEquals(2, words.size());
    }

    @Test
    public void testFindByNameAndTag() {
        Word concept1 = new Word("name", Tag.NOUN);
        Word concept2 = new Word("name", Tag.ADJECTIVE);
        wordKnowledgeBase.addWord(concept1);
        wordKnowledgeBase.addWord(concept2);

        List<Word> words = wordKnowledgeBase.findByNameAndTag(concept1.getName(), Tag.ADJECTIVE);
        assertEquals(1, words.size());
    }

    @Test
    public void testGetWords() {
        String wordName = "word";
        wordKnowledgeBase.addWord(wordName, Tag.NOUN.name());

        Iterator<Word> iterator = wordKnowledgeBase.getWords(wordName);
        assertTrue(iterator.hasNext());

        Word word = iterator.next();
        assertEquals(wordName, word.getName());
    }

    @Test
    public void testFindVerb() {
        Word conceptNotAVerb = new Word("word", Tag.NOUN);
        wordKnowledgeBase.addWord(conceptNotAVerb);

        Word concept = new Word("word", Tag.VERB);
        wordKnowledgeBase.addWord(concept);

        WordVerb verb = wordKnowledgeBase.findVerb(concept.getName());
        assertEquals("word", verb.getName());
    }

    @Test
    public void testFindByTags() {
        Word noun = new Word("noun", Tag.NOUN);
        wordKnowledgeBase.addWord(noun);

        Word verb = new Word("verb", Tag.VERB);
        wordKnowledgeBase.addWord(verb);

        List<Word> words = wordKnowledgeBase.findByTags(Tag.NOUN, Tag.VERB);
        assertEquals(noun.getName(), words.get(0).getName());
        assertEquals(verb.getName(), words.get(1).getName());
    }

}
