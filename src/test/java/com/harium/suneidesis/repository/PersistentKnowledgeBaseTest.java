package com.harium.suneidesis.repository;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Primitive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersistentKnowledgeBaseTest {

    private PersistentKnowledgeBase persistentKnowledgeBase;

    @Before
    public void setUp() {
        persistentKnowledgeBase = new PersistentKnowledgeBase();
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

        persistentKnowledgeBase.insert("randomKey1", appleTree);

        Concept result = persistentKnowledgeBase.get("1");
        assertEquals("1", result.getIdText());
        assertEquals(appleTree.getName(), result.getName());
        assertTrue(result.hasKey("fruit"));
        Concept fruit = result.get("fruit");
        assertEquals("2", fruit.getIdText());
        assertEquals("77", fruit.get("kcal").getValue());
    }

}