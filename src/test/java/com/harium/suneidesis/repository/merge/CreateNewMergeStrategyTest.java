package com.harium.suneidesis.repository.merge;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.helper.Inspector;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.repository.MemoryKnowledgeBase;
import com.harium.suneidesis.serialization.jackson.CustomKnowledgeBaseDeserializer;
import com.harium.suneidesis.serialization.jackson.KnowledgeBaseJacksonSerializer;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.harium.suneidesis.serialization.KnowledgeBaseDeserializerTest.loadFileAsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CreateNewMergeStrategyTest {

    private CustomKnowledgeBaseDeserializer deserializer;

    @Before
    public void setUp() {
        deserializer = new CustomKnowledgeBaseDeserializer(MergeStrategyType.CREATE_NEW);
    }

    @Test
    public void testMerge() throws IOException, URISyntaxException, JSONException {
        String json = loadFileAsString("database_complex.json");

        KnowledgeBase database = new MemoryKnowledgeBase();
        // Deserialize the same database twice
        deserializer.deserialize(json, database);
        assertEquals(3, database.getAll().size());

        deserializer.deserialize(json, database);
        assertEquals("database", database.getName());
        assertEquals(6, database.getAll().size());

        Concept appleTree = database.get("0");
        assertEquals("apple tree", appleTree.getName());
        assertTrue(appleTree.hasKey("fruit"));

        Concept apple = database.get("1");
        assertEquals("apple", apple.getName());

        Concept food = database.get("2");
        assertTrue(Inspector.does(apple).is(food));

        // Test duplicate entries
        appleTree = database.get("3");
        assertEquals("apple tree", appleTree.getName());
        assertTrue(appleTree.hasKey("fruit"));

        apple = database.get("4");
        assertEquals("apple", apple.getName());

        food = database.get("5");
        assertTrue(Inspector.does(apple).is(food));

        String serialized = new KnowledgeBaseJacksonSerializer().serialize(database);
        JSONAssert.assertEquals(json, serialized, false);
    }

}
