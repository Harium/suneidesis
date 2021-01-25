package com.harium.suneidesis.serialization;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.repository.MemoryKnowledgeBase;
import com.harium.suneidesis.serialization.jackson.KnowledgeBaseJacksonSerializer;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class KnowledgeBaseSerializerTest {

    private KnowledgeBaseJacksonSerializer serializer;

    @Before
    public void setUp() {
        serializer = new KnowledgeBaseJacksonSerializer();
    }

    @Test
    public void testSimple() throws IOException {
        String result = serializer.serialize(buildSimpleKnowledgeBase());
        assertEquals("", result);
    }

    private KnowledgeBase buildSimpleKnowledgeBase() {
        Concept appleTree = new Concept("apple tree");
        Concept apple = new Concept("apple");
        appleTree.set("fruit", apple);
        KnowledgeBase base = new MemoryKnowledgeBase("database");
        base.add(appleTree);

        return base;
    }

}
