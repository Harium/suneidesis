package com.harium.suneidesis.knowledge.linguistic.portuguese.nlp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.harium.suneidesis.knowledge.linguistic.core.nlp.POSTaggerReconstructor.*;

public class RuleBasedPOSTaggerTest {

    RuleBasedPOSTagger tagger;

    @Before
    public void setUp() {
        tagger = new RuleBasedPOSTagger();
    }

    @Test
    public void testSingleWord() {
        String[] answer = tagger.posTag(new String[]{"casa"});
        Assert.assertEquals(NOUN, answer[0]);
    }

    @Test
    public void testTagArticles() {
        String[] answer = tagger.posTag(new String[]{"a", "casa"});
        Assert.assertEquals(DETERMINER, answer[0]);
        Assert.assertEquals(NOUN, answer[1]);
    }

    @Test
    public void testTagPrepositions() {
        String[] answer = tagger.posTag(new String[]{"a", "casa", "de", "papel"});
        Assert.assertEquals(DETERMINER, answer[0]);
        Assert.assertEquals(NOUN, answer[1]);
        Assert.assertEquals(PREPOSITION, answer[2]);
        Assert.assertEquals(NOUN, answer[3]);
    }

    @Test
    public void testTagPronouns() {
        String[] answer = tagger.posTag(new String[]{"você", "é", "esperto"});
        Assert.assertEquals(PERSONAL_PRONOUN, answer[0]);
        Assert.assertEquals(VERB, answer[1]);
        Assert.assertEquals(ADJECTIVE, answer[2]);
    }

    @Test
    public void testTagConjunction() {
        String[] answer = tagger.posTag(new String[]{"você", "é", "chato", "e", "bobo"});
        Assert.assertEquals(PERSONAL_PRONOUN, answer[0]);
        Assert.assertEquals(VERB, answer[1]);
        Assert.assertEquals(ADJECTIVE, answer[2]);
        Assert.assertEquals(COORDINATING_CONJUCTION, answer[3]);
        Assert.assertEquals(ADJECTIVE, answer[4]);
    }

    @Test
    public void testTagMisc() {
        String[] answer = tagger.posTag(new String[]{"eu", "sou", "sempre", "muito", "chato"});
        Assert.assertEquals(PERSONAL_PRONOUN, answer[0]);
        Assert.assertEquals(VERB, answer[1]);
        Assert.assertEquals(ADVERB, answer[2]);
        Assert.assertEquals(ADVERB, answer[3]);
        Assert.assertEquals(ADJECTIVE, answer[4]);
    }

    @Test
    public void testUnknownVerbs() {
        String[] answer = tagger.posTag(new String[]{"ele", "vai", "voar"});
        Assert.assertEquals(PERSONAL_PRONOUN, answer[0]);
        Assert.assertEquals(VERB, answer[1]);
        Assert.assertEquals(VERB, answer[2]);

        answer = tagger.posTag(new String[]{"tomamos", "uma", "decisão"});
        Assert.assertEquals(VERB, answer[0]);
        Assert.assertEquals(DETERMINER, answer[1]);
        Assert.assertEquals(NOUN, answer[2]);

        answer = tagger.posTag(new String[]{"eles", "sairão", "hoje"});
        Assert.assertEquals(PERSONAL_PRONOUN, answer[0]);
        Assert.assertEquals(VERB, answer[1]);
        Assert.assertEquals(ADVERB, answer[2]);
    }

    @Test
    public void testNouns() {
        String[] answer = tagger.posTag(new String[]{"o", "farol", "do", "Fusca", "produz", "uma", "luz", "muito", "forte"});
        Assert.assertEquals(DETERMINER, answer[0]);
        Assert.assertEquals(NOUN, answer[1]);
        Assert.assertEquals(PREPOSITION, answer[2]);
        Assert.assertEquals(NOUN, answer[3]);
        Assert.assertEquals(VERB, answer[4]);
        Assert.assertEquals(DETERMINER, answer[5]);
        Assert.assertEquals(NOUN, answer[6]);
        Assert.assertEquals(ADVERB, answer[7]);
        Assert.assertEquals(ADJECTIVE, answer[8]);
    }

}
