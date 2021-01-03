package com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.pos;

import com.harium.suneidesis.concept.word.WordVerb;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.Tag;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.TagPair;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.database.WordDatabase;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.tokenizer.Tokenizer;
import com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.database.MemoryDatabase;
import com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.tokenization.RuleBasedTokenizer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MultipassPOSTaggerTest {

    private static final String FIRST_PERSON_SINGULAR = "eu";
    private static final String THIRD_PERSON_SINGULAR = "ele";

    Tokenizer tokenizer;
    MultipassPOSTagger tagger;
    WordDatabase database;

    @Before
    public void setUp() {
        database = buildDatabase();
        tagger = new MultipassPOSTagger(database);
        tokenizer = new RuleBasedTokenizer();
    }

    private WordDatabase buildDatabase() {
        MemoryDatabase database = new MemoryDatabase();

        WordVerb go = database.addVerb("ir", "a|de|X", "");

        database.addVerbConjugation("fui", go, Tag.VERB_PAST_TENSE, Tag.VERB_PAST_TENSE.name(), FIRST_PERSON_SINGULAR);
        database.addVerbConjugation("foi", go, Tag.VERB_PAST_TENSE, Tag.VERB_PAST_TENSE.name(), THIRD_PERSON_SINGULAR);

        return database;
    }

    @Test
    public void testSingleWord() {
        TagPair[] answer = tagger.posTag(tokenize("fui"));
        Assert.assertEquals(Tag.VERB, answer[0].getTag());
    }

    @Test
    public void testVerbPreposition() {
        TagPair[] answer = tagger.posTag(tokenize("foi de carro"));
        Assert.assertEquals(Tag.VERB, answer[0].getTag());
        Assert.assertEquals(Tag.PREPOSITION, answer[1].getTag());
        Assert.assertEquals(Tag.NOUN, answer[2].getTag());
    }

    @Test
    public void testVerbPrepositionAndArticle() {
        TagPair[] answer = tagger.posTag(tokenize("foi à casa"));
        Assert.assertEquals(Tag.VERB, answer[0].getTag());
        Assert.assertEquals(Tag.PREPOSITION, answer[1].getTag());
        Assert.assertEquals(Tag.DETERMINER, answer[2].getTag());
        Assert.assertEquals(Tag.NOUN, answer[3].getTag());
    }

    private String[] tokenize(String sentence) {
        return tokenizer.tokenize(sentence);
    }

}
