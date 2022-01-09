package com.harium.suneidesis.repository;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.repository.generator.BaseIdGenerator;
import com.harium.suneidesis.repository.generator.IdGenerator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MemoryKnowledgeBaseTest {

    private KnowledgeBase knowledgeBase;
    private IdGenerator generator;

    @Before
    public void setUp() {
        knowledgeBase = new MemoryKnowledgeBase();
        generator = new BaseIdGenerator();
    }

    @Test
    public void testGenerateId_RefreshGenerator() {
        knowledgeBase.save(new Concept("concept1"));
        generator = new BaseIdGenerator();
        knowledgeBase.setIdGenerator(generator);
        knowledgeBase.save(new Concept("concept1"));
        assertEquals(2, knowledgeBase.count());

        assertFalse(knowledgeBase.findById("0").isUnknown());
        assertFalse(knowledgeBase.findById("1").isUnknown());
    }

    @Test
    public void testDeleteConcept() {
        Concept concept1 = new Concept("concept1");
        Concept concept2 = new Concept("concept1");

        knowledgeBase.save(concept1);
        knowledgeBase.save(concept2);
        assertEquals(2, knowledgeBase.count());

        knowledgeBase.delete(concept1.getId());
        assertEquals(1, knowledgeBase.count());
        knowledgeBase.delete(concept2.getId());
        assertEquals(0, knowledgeBase.count());

        knowledgeBase.save(concept1);
        assertEquals(1, knowledgeBase.count());
    }

}
