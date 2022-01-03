package com.harium.suneidesis.repository.word;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.repository.MemoryKnowledgeBase;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordKnowledgeBaseTest {

    private WordKnowledgeBase wordKnowledgeBase;

    @Before
    public void setUp() {
        wordKnowledgeBase = new WordKnowledgeBase(new MemoryKnowledgeBase());
    }

    @Test
    public void testFindByName() {
        Word concept = new Word("myName");
        wordKnowledgeBase.addWord(concept);

        List<Word> words = wordKnowledgeBase.findByName(concept.getName());
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

}
