package com.harium.suneidesis.repository;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Primitive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PersistentKnowledgeBaseTest {

    private PersistentKnowledgeBase persistentKnowledgeBase;

    @Before
    public void setUp() {
        persistentKnowledgeBase = new MemoryKnowledgeBase();
    }

    @After
    public void tearDown() {
        persistentKnowledgeBase.clear();
    }

    @Test
    public void testInsert() {
        Concept appleTree = new Concept("apple tree").id("1");
        Concept apple = new Concept("apple").id("2");
        apple.set("kcal", new Primitive("77"));

        appleTree.set("fruit", apple);
        appleTree.set("intValue", new Primitive("1234"));

        persistentKnowledgeBase.add("randomKey1", appleTree);

        Concept result = persistentKnowledgeBase.get("1");
        assertEquals("1", result.getId());
        assertEquals(appleTree.getName(), result.getName());
        assertTrue(result.hasKey("fruit"));
        Concept fruit = result.get("fruit");
        assertEquals("2", fruit.getId());
        assertEquals("77", fruit.get("kcal").getValue());
    }

    @Test
    public void testGetInvalid() {
        Concept concept = persistentKnowledgeBase.get("randomKey");
        assertTrue(concept.isUnknown());
    }

    @Test
    public void testAddConceptTwice_NullId() {
        persistentKnowledgeBase.add("randomKey", new Concept("concept"));
        persistentKnowledgeBase.add("randomKey", new Concept("concept"));

        Concept concept = persistentKnowledgeBase.get("randomKey");
        assertFalse(concept.isUnknown());
    }

    @Test
    public void testMerge() {
        PersistentKnowledgeBase anotherDB = new PersistentKnowledgeBase();
        anotherDB.add("randomKey1", new Concept("concept1"));

        persistentKnowledgeBase.add("randomKey2", new Concept("concept2"));
        persistentKnowledgeBase.merge(anotherDB);

        Concept concept = persistentKnowledgeBase.get("randomKey1");
        assertFalse(concept.isUnknown());
        assertEquals("concept1", concept.getName());
    }

}