package com.harium.suneidesis.serialization;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.repository.MemoryKnowledgeBase;
import com.harium.suneidesis.serialization.jackson.KnowledgeBaseJacksonSerializer;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;

public class KnowledgeBaseSerializerTest {

    private KnowledgeBaseJacksonSerializer serializer;

    @Before
    public void setUp() {
        serializer = new KnowledgeBaseJacksonSerializer();
    }

    @Test
    public void testSimple() throws IOException, JSONException {
        String result = serializer.serialize(buildSimpleKnowledgeBase());
        System.out.println(result);

        String expected = "{name:\"database\", \"concepts\":{"
                + "\"0\":{\"name\":\"apple tree\",\"fruit\":\"1\"},"
                + "\"1\":{\"name\":\"apple\"}"
                +"}}";
        JSONAssert.assertEquals(expected, result, false);
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
