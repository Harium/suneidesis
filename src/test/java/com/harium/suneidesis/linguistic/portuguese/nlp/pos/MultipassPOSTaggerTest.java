package com.harium.suneidesis.linguistic.portuguese.nlp.pos;

import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.linguistic.nlp.pos.TagPair;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.repository.MemoryKnowledgeBase;
import com.harium.suneidesis.repository.word.WordKnowledgeBase;
import com.harium.suneidesis.linguistic.nlp.Tokenizer;
import com.harium.suneidesis.linguistic.portuguese.nlp.tokenization.RuleBasedTokenizer;
import com.harium.suneidesis.serialization.jackson.CustomKnowledgeBaseDeserializer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.harium.suneidesis.serialization.KnowledgeBaseDeserializerTest.loadFileAsString;

public class MultipassPOSTaggerTest {

    private Tokenizer tokenizer;
    private MultipassPOSTagger tagger;
    private WordKnowledgeBase database;

    @Before
    public void setUp() throws IOException, URISyntaxException {
        database = buildDatabase();
        tagger = new MultipassPOSTagger(database);
        tokenizer = new RuleBasedTokenizer();
    }

    private WordKnowledgeBase buildDatabase() throws IOException, URISyntaxException {
        CustomKnowledgeBaseDeserializer deserializer = new CustomKnowledgeBaseDeserializer();
        String json = loadFileAsString("dictionary_portuguese.json");

        KnowledgeBase database = new MemoryKnowledgeBase();
        deserializer.deserialize(json, database);

        return new WordKnowledgeBase(database);
    }

    @Test
    public void testSingleWord() {
        TagPair[] answer = tagger.posTag(tokenizer.tokenize("fui"));
        Assert.assertEquals(Tag.VERB, answer[0].getTag());
    }

    @Test
    public void testVerbPreposition() {
        TagPair[] answer = tagger.posTag(tokenizer.tokenize("foi de carro"));
        Assert.assertEquals(Tag.VERB, answer[0].getTag());
        Assert.assertEquals(Tag.PREPOSITION, answer[1].getTag());
        Assert.assertEquals(Tag.NOUN, answer[2].getTag());
    }

    @Test
    public void testVerbPrepositionAndArticle() {
        TagPair[] answer = tagger.posTag(tokenizer.tokenize("foi à casa"));
        Assert.assertEquals(Tag.VERB, answer[0].getTag());
        Assert.assertEquals(Tag.PREPOSITION, answer[1].getTag());
        Assert.assertEquals(Tag.DETERMINER, answer[2].getTag());
        Assert.assertEquals(Tag.NOUN, answer[3].getTag());
    }

}
