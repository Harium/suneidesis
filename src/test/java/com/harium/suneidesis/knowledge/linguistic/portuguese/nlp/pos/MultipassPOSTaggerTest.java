package com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.pos;

import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.Tag;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.TagPair;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model.Verb;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.tokenizer.Tokenizer;
import com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.database.WordDatabase;
import com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.tokenization.RuleBasedTokenizer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MultipassPOSTaggerTest {

    Tokenizer tokenizer;
    MultipassPOSTagger tagger;
    WordDatabase database;

    @Before
    public void setUp() {
        database = mock(WordDatabase.class);
        tagger = new MultipassPOSTagger(database);
        tokenizer = new RuleBasedTokenizer();

        setUpVerbs();
    }

    private void setUpVerbs() {
        when(database.getTags("ir")).thenReturn(Collections.singletonList(Tag.VERB));
        when(database.getTags("fui")).thenReturn(Collections.singletonList(Tag.VERB_PAST_TENSE));
        when(database.getTags("foi")).thenReturn(Collections.singletonList(Tag.VERB_PAST_TENSE));

        Verb go = new Verb();
        go.setPrepositions("a|de|X");
        when(database.getVerb("fui")).thenReturn(go);
        when(database.getVerb("foi")).thenReturn(go);
    }

    @Test
    public void testSingleWord() {
        TagPair[] answer = tagger.posTag(tokenize("fui"));
        Assert.assertEquals(Tag.VERB, answer[0].getTag());
    }

    @Test
    public void testVerbPreposition() {
        when(database.getTags("de")).thenReturn(Arrays.asList(Tag.PREPOSITION));

        TagPair[] answer = tagger.posTag(tokenize("foi de carro"));
        Assert.assertEquals(Tag.VERB, answer[0].getTag());
        Assert.assertEquals(Tag.PREPOSITION, answer[1].getTag());
        Assert.assertEquals(Tag.NOUN, answer[2].getTag());
    }

    @Test
    public void testVerbPrepositionAndArticle() {
        when(database.getTags("a")).thenReturn(Arrays.asList(Tag.DETERMINER, Tag.PREPOSITION));

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
