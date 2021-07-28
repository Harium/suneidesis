package com.harium.suneidesis.repository.generator;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.repository.KnowledgeBase;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WordIdGeneratorTest {

    private KnowledgeBase knowledgeBase;
    private WordIdGenerator generator;

    @Before
    public void setUp() {
        knowledgeBase = mock(KnowledgeBase.class);
        generator = new WordIdGenerator(knowledgeBase);
    }

    @Test
    public void testGenerateId() {
        assertEquals("acai", generator.generateId("açaí"));
        assertEquals("casa-de-praia", generator.generateId("Casa de Praia"));
        assertEquals("ola", generator.generateId("Olá"));
        assertEquals("abacaxi-dot-abc", generator.generateId("abacaxi.abc"));
        assertEquals("abacaxi-dot-comma-abc", generator.generateId("abacaxi.,abc"));
    }

    @Test
    public void testGenerateId_MultipleTimes() {
        Concept concept = new Concept("açaí");

        // acai-1 is available
        when(knowledgeBase.findById("acai-1")).thenReturn(ConceptType.UNKNOWN);
        assertEquals("acai-1", generator.generateId(concept));

        // acai-1 was taken
        when(knowledgeBase.findById("acai-1")).thenReturn(concept);
        // acai-2 is available
        when(knowledgeBase.findById("acai-2")).thenReturn(ConceptType.UNKNOWN);
        assertEquals("acai-2", generator.generateId(concept));
    }

}
