package com.harium.suneidesis.serialization;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.repository.MemoryKnowledgeBase;
import com.harium.suneidesis.serialization.jackson.CustomKnowledgeBaseDeserializer;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
    public void testSimple() throws IOException, URISyntaxException {
        String json = loadFileAsString("database_simple.json");

        KnowledgeBase database = new MemoryKnowledgeBase();
        deserializer.deserialize(json, database);

        assertEquals("database", database.getName());
        assertEquals(2, database.getAll().size());

        Concept appleTree = database.get("0");
        assertEquals("apple tree", appleTree.getName());
        assertTrue(appleTree.hasKey("fruit"));

        Concept apple = database.get("1");
        assertEquals("apple", apple.getName());
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
