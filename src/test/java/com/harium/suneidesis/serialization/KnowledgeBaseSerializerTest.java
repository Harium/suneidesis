package com.harium.suneidesis.serialization;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.word.WordVerb;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.linguistic.storage.MemoryWordBase;
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
        //System.out.println(result);

        String expected = "{name:\"database\", \"concepts\":{"
                + "\"0\":{\"name\":\"apple tree\",\"fruit\":\"1\"},"
                + "\"1\":{\"name\":\"apple\"}"
                +"}}";
        JSONAssert.assertEquals(expected, result, false);
    }

    @Test
    public void testWordDatabase() throws IOException, JSONException {
        String result = serializer.serialize(buildWordDatabase());
        System.out.println(result);

        String expected = "{name:\"dictionary\", \"concepts\":{"
                + "\"0\":{\"name\":\"cat\", \"tag\":\"NOUN\"},"
                + "\"1\":{\"name\":\"duck\", \"tag\":\"NOUN\"},"
                // TODO UNIFY TAGS
                + "\"2\":{\"name\":\"go\", \"tag\":\"verb\", \"lemma\":\"go\", \"prepositions\":\"on|through\"},"
                + "\"3\":{\"name\":\"went\", \"tag\":\"VERB_PAST_TENSE\", \"lemma\":\"go\"}"
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

    private KnowledgeBase buildWordDatabase() {
        MemoryWordBase database = new MemoryWordBase("dictionary");
        database.addWord("cat", Tag.NOUN);
        database.addWord("duck", Tag.NOUN);

        WordVerb go = database.addVerb("go", "on|through", "");
        database.addVerbConjugation("went", go, Tag.VERB_PAST_TENSE, "PAST", "");

        return database;
    }

}
