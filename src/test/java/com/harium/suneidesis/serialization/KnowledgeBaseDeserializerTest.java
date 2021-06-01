package com.harium.suneidesis.serialization;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.concept.helper.Inspector;
import com.harium.suneidesis.repository.word.MemoryWordBase;
import com.harium.suneidesis.repository.word.WordKnowledgeBase;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.repository.nitrite.NitriteMemoryKnowledgeBase;
import com.harium.suneidesis.serialization.jackson.CustomKnowledgeBaseDeserializer;
import com.harium.suneidesis.serialization.jackson.KnowledgeBaseJacksonSerializer;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KnowledgeBaseDeserializerTest {

    private CustomKnowledgeBaseDeserializer deserializer;

    @Before
    public void setUp() {
        deserializer = new CustomKnowledgeBaseDeserializer();
    }

    @Test
    public void testSimple() throws IOException, URISyntaxException, JSONException {
        String json = loadFileAsString("database_simple.json");

        KnowledgeBase database = new NitriteMemoryKnowledgeBase();
        deserializer.deserialize(json, database);

        assertEquals("database", database.getName());
        assertEquals(2, database.getAll().size());

        Concept appleTree = database.get("0");
        assertEquals("apple tree", appleTree.getName());
        assertTrue(appleTree.hasKey("fruit"));

        Concept apple = database.get("1");
        assertEquals("apple", apple.getName());

        String serialized = new KnowledgeBaseJacksonSerializer().serialize(database);
        JSONAssert.assertEquals(json, serialized, false);
    }

    @Test
    public void testComplex() throws IOException, URISyntaxException, JSONException {
        String json = loadFileAsString("database_complex.json");

        KnowledgeBase database = new NitriteMemoryKnowledgeBase();
        deserializer.deserialize(json, database);

        assertEquals("database", database.getName());
        assertEquals(3, database.getAll().size());

        Concept appleTree = database.get("0");
        assertEquals("apple tree", appleTree.getName());
        assertTrue(appleTree.hasKey("fruit"));

        Concept apple = database.get("1");
        assertEquals("apple", apple.getName());

        Concept food = database.get("2");
        assertTrue(Inspector.does(apple).is(food));

        String serialized = new KnowledgeBaseJacksonSerializer().serialize(database);
        JSONAssert.assertEquals(json, serialized, false);
    }

    @Test
    public void testDictionary() throws IOException, URISyntaxException, JSONException {
        String json = loadFileAsString("dictionary_simple.json");

        KnowledgeBase database = new NitriteMemoryKnowledgeBase();
        deserializer.deserialize(json, database);

        WordKnowledgeBase wordDatabase = new MemoryWordBase("");
        wordDatabase.merge(database);

        assertEquals("dictionary", database.getName());
        assertEquals(4, database.getAll().size());

        List<Word> words = wordDatabase.getWords("cat");
        assertEquals("cat", words.get(0).getName());

        words = wordDatabase.getWords("duck");
        assertEquals("duck", words.get(0).getName());

        String serialized = new KnowledgeBaseJacksonSerializer().serialize(database);
        JSONAssert.assertEquals(json, serialized, false);
    }

    private String loadFileAsString(String filename) throws IOException, URISyntaxException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();

        return Files.lines(Paths.get(loader.getResource(filename).toURI()))
                .parallel()
                .collect(Collectors.joining());
    }

    private InputStream loadFileAsStream(String filename) {
        ClassLoader loader = ClassLoader.getSystemClassLoader();

        return loader.getResourceAsStream(filename);
    }

}
