package com.harium.suneidesis.repository.generator;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.repository.MemoryKnowledgeBase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseIdGeneratorTest {

    private BaseIdGenerator generator;

    @Before
    public void setUp() {
        generator = new BaseIdGenerator();
    }

    @Test
    public void testGenerateId() {
        assertEquals("0", generator.generateId(new Concept("concept1")));
        assertEquals("1", generator.generateId(new Concept("concept1")));
    }

}
