package com.harium.suneidesis.linguistic.nlp.lemmatization;

import com.harium.suneidesis.concept.word.WordNoun;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.repository.MemoryKnowledgeBase;
import com.harium.suneidesis.repository.word.WordKnowledgeBase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DatabaseLemmatizerTest {

    private DatabaseLemmatizer lemmatizer;

    @Before
    public void setUp() {
        KnowledgeBase database = new MemoryKnowledgeBase();
        WordKnowledgeBase wordKnowledgeBase = new WordKnowledgeBase(database);
        wordKnowledgeBase.addWord("apples", "apple", Tag.NOUN.name());

        WordNoun dog = new WordNoun("dog");
        dog.setLemma(dog);
        WordNoun dogs = new WordNoun("dogs");
        dogs.setLemma(dog);

        wordKnowledgeBase.addWord(dog);
        wordKnowledgeBase.addWord(dogs);

        lemmatizer = new DatabaseLemmatizer(wordKnowledgeBase);
    }

    @Test
    public void testWordInDatabase() {
        assertEquals("apple", lemmatizer.lemmatize("apples"));
        assertEquals("dog", lemmatizer.lemmatize("dogs"));
        assertEquals("dog", lemmatizer.lemmatize("dog"));
    }

}
