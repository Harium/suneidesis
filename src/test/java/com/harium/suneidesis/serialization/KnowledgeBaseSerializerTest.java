package com.harium.suneidesis.serialization;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.word.WordNoun;
import com.harium.suneidesis.concept.word.WordVerb;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.repository.MemoryKnowledgeBase;
import com.harium.suneidesis.repository.word.WordKnowledgeBase;
import com.harium.suneidesis.serialization.jackson.KnowledgeBaseJacksonSerializer;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.IOException;

public class KnowledgeBaseSerializerTest {

    private static final boolean PRINT_RESULT = false;

    private KnowledgeBaseJacksonSerializer serializer;

    @Before
    public void setUp() {
        serializer = new KnowledgeBaseJacksonSerializer();
    }

    @Test
    public void testSimple() throws IOException, JSONException {
        String result = serializer.serialize(buildSimpleKnowledgeBase());
        print(result);

        String expected = "{name:\"database\", \"concepts\":{"
                + "\"0\":{\"name\":\"apple tree\",\"fruit\":{\"id\":\"1\"}},"
                + "\"1\":{\"name\":\"apple\"}"
                +"}}";
        JSONAssert.assertEquals(expected, result, false);
    }

    @Test
    public void testComplex() throws IOException, JSONException {
        String result = serializer.serialize(buildComplexKnowledgeBase());
        print(result);

        String expected = "{name:\"database\", \"concepts\":{"
                + "\"0\":{\"name\":\"apple tree\",\"fruit\":{\"id\":\"1\"}},"
                + "\"1\":{\"name\":\"apple\",\"_inheritance\":[\"2\"], \"tree\":\"0\"},"
                + "\"2\":{\"name\":\"food\"}"
                +"}}";
        JSONAssert.assertEquals(expected, result, false);
    }

    @Test
    public void testWordDatabase() throws IOException, JSONException {
        String result = serializer.serialize(buildWordDatabase());
        print(result);

        String expected = "{name:\"dictionary\", \"concepts\":{"
                + "\"0\":{\"name\":\"cat\", \"tag\":\"" + Tag.NOUN +"\"},"
                + "\"1\":{\"name\":\"duck\", \"tag\":\"" + Tag.NOUN +"\"},"
                + "\"2\":{\"name\":\"go\", \"tag\":\"" + Tag.VERB + "\", \"lemma\":\"go\", \"prepositions\":\"on|through\"},"
                + "\"3\":{\"name\":\"went\", \"tag\":\"" + Tag.VERB_CONJUGATION + "\", \"lemma\":\"go\"}"
                +"}}";

        JSONAssert.assertEquals(expected, result, false);
    }

    private KnowledgeBase buildSimpleKnowledgeBase() {
        Concept appleTree = new Concept("apple tree");
        appleTree.id("0");

        Concept apple = new Concept("apple");
        apple.id("1");

        appleTree.set("fruit", apple);
        KnowledgeBase base = new MemoryKnowledgeBase("database");
        base.save(appleTree);

        return base;
    }

    private KnowledgeBase buildComplexKnowledgeBase() {
        Concept appleTree = new Concept("apple tree");
        appleTree.id("0");
        Concept apple = new Concept("apple");
        apple.id("1");
        apple.set("tree", appleTree);

        Concept food = new Concept("food");
        food.id("2");
        apple.is(food);

        appleTree.set("fruit", apple);
        MemoryKnowledgeBase base = new MemoryKnowledgeBase("database");
        base.save(appleTree);

        return base;
    }

    private MemoryKnowledgeBase buildWordDatabase() {
        MemoryKnowledgeBase db = new MemoryKnowledgeBase("dictionary");
        WordKnowledgeBase database = new WordKnowledgeBase(db);
        database.addWord("cat", Tag.NOUN.name());

        WordNoun duck = new WordNoun("duck");
        database.save(duck);

        WordVerb go = database.addVerb("go", "on|through", "");
        database.addVerbConjugation("went", go, Tag.VERB_CONJUGATION, "PAST", "");

        return db;
    }

    private void print(String result) {
        if (!PRINT_RESULT) {
            return;
        }
        System.out.println(result);
    }

}
