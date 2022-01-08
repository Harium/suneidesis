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

}
