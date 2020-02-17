package com.harium.suneidesis.knowledge.linguistic.portuguese.nlp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.harium.suneidesis.knowledge.linguistic.core.nlp.tagger.POSTaggerReconstructor.*;

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
    public void testTagAdjectiveInBetween() {
        String[] answer = tagger.posTag(new String[]{"a", "grande", "casa"});
        Assert.assertEquals(DETERMINER, answer[0]);
        Assert.assertEquals(ADJECTIVE, answer[1]);
        Assert.assertEquals(NOUN, answer[2]);
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
    public void testRegularVerbs() {
        String[] answer = tagger.posTag(new String[]{"quem", "com", "ferro", "fere", "com", "ferro", "será", "ferido"});
        Assert.assertEquals(WH_PRONOUN, answer[0]);
        Assert.assertEquals(PREPOSITION, answer[1]);
        Assert.assertEquals(NOUN, answer[2]);
        Assert.assertEquals(VERB, answer[3]);
        Assert.assertEquals(PREPOSITION, answer[4]);
        Assert.assertEquals(NOUN, answer[5]);
        Assert.assertEquals(VERB, answer[6]);
        Assert.assertEquals(VERB, answer[7]);
    }

    @Test
    public void testNouns() {
        // Tokenized sentence
        String[] answer = tagger.posTag(new String[]{"o", "farol", "de", "o", "Fusca", "produz", "uma", "luz", "muito", "forte"});
        Assert.assertEquals(DETERMINER, answer[0]);
        Assert.assertEquals(NOUN, answer[1]);
        Assert.assertEquals(PREPOSITION, answer[2]);
        Assert.assertEquals(DETERMINER, answer[3]);
        Assert.assertEquals(NOUN, answer[4]);
        Assert.assertEquals(VERB, answer[5]);
        Assert.assertEquals(DETERMINER, answer[6]);
        Assert.assertEquals(NOUN, answer[7]);
        Assert.assertEquals(ADVERB, answer[8]);
        Assert.assertEquals(ADJECTIVE, answer[9]);
    }

}
