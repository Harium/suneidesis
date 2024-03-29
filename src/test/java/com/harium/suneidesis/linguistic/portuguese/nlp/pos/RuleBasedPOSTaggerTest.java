package com.harium.suneidesis.linguistic.portuguese.nlp.pos;

import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.linguistic.nlp.pos.TagPair;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.repository.MemoryKnowledgeBase;
import com.harium.suneidesis.repository.word.WordKnowledgeBase;
import com.harium.suneidesis.serialization.jackson.CustomKnowledgeBaseDeserializer;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static com.harium.suneidesis.serialization.KnowledgeBaseDeserializerTest.loadFileAsString;

public class RuleBasedPOSTaggerTest {

    private static RuleBasedPOSTagger tagger;

    @BeforeClass
    public static void setUp() throws IOException, URISyntaxException {
        CustomKnowledgeBaseDeserializer deserializer = new CustomKnowledgeBaseDeserializer();
        String json = loadFileAsString("dictionary_portuguese.json");

        KnowledgeBase database = new MemoryKnowledgeBase();
        deserializer.deserialize(json, database);
        WordKnowledgeBase wordKnowledgeBase = new WordKnowledgeBase(database);

        tagger = new RuleBasedPOSTagger(wordKnowledgeBase);
    }

    @Test
    public void testSingleWord() {
        TagPair[] answer = tagger.posTag(new String[]{"casa"});
        Assert.assertEquals(Tag.NOUN, answer[0].getTag());
    }

    @Test
    public void testSingleWord_Unknown() {
        TagPair[] answer = tagger.posTag(new String[]{"xiforínfola"});
        Assert.assertEquals(Tag.UNKNOWN, answer[0].getTag());
    }

    @Test
    public void testTagArticles() {
        TagPair[] answer = tagger.posTag(new String[]{"a", "casa"});
        Assert.assertEquals(Tag.DETERMINER, answer[0].getTag());
        Assert.assertEquals(Tag.NOUN, answer[1].getTag());
    }

    @Test
    public void testTagAdjectiveInBetween() {
        TagPair[] answer = tagger.posTag(new String[]{"a", "grande", "casa"});
        Assert.assertEquals(Tag.DETERMINER, answer[0].getTag());
        Assert.assertEquals(Tag.ADJECTIVE, answer[1].getTag());
        Assert.assertEquals(Tag.NOUN, answer[2].getTag());
    }

    @Test
    public void testTagPrepositions() {
        TagPair[] answer = tagger.posTag(new String[]{"a", "casa", "de", "papel"});
        Assert.assertEquals(Tag.DETERMINER, answer[0].getTag());
        Assert.assertEquals(Tag.NOUN, answer[1].getTag());
        Assert.assertEquals(Tag.PREPOSITION, answer[2].getTag());
        Assert.assertEquals(Tag.NOUN, answer[3].getTag());
    }

    @Ignore
    @Test
    public void testTagPronouns() {
        TagPair[] answer = tagger.posTag(new String[]{"você", "é", "esperto"});
        Assert.assertEquals(Tag.PERSONAL_PRONOUN, answer[0].getTag());
        Assert.assertEquals(Tag.VERB_CONJUGATION, answer[1].getTag());
        Assert.assertEquals(Tag.ADJECTIVE, answer[2].getTag());
    }

    @Ignore
    @Test
    public void testTagConjunction() {
        TagPair[] answer = tagger.posTag(new String[]{"você", "é", "chato", "e", "bobo"});
        Assert.assertEquals(Tag.PERSONAL_PRONOUN, answer[0].getTag());
        Assert.assertEquals(Tag.VERB, answer[1].getTag());
        Assert.assertEquals(Tag.ADJECTIVE, answer[2].getTag());
        Assert.assertEquals(Tag.COORDINATING_CONJUCTION, answer[3].getTag());
        Assert.assertEquals(Tag.ADJECTIVE, answer[4].getTag());
    }

    @Test
    public void testTagMisc() {
        TagPair[] answer = tagger.posTag(new String[]{"eu", "sou", "sempre", "muito", "chato"});
        Assert.assertEquals(Tag.PERSONAL_PRONOUN, answer[0].getTag());
        Assert.assertEquals(Tag.VERB_CONJUGATION, answer[1].getTag());
        Assert.assertEquals(Tag.ADVERB, answer[2].getTag());
        Assert.assertEquals(Tag.ADVERB, answer[3].getTag());
        Assert.assertEquals(Tag.ADJECTIVE, answer[4].getTag());
    }

    @Test
    public void testUnknownVerbs() {
        TagPair[] answer = tagger.posTag(new String[]{"ele", "vai", "voar"});
        Assert.assertEquals(Tag.PERSONAL_PRONOUN, answer[0].getTag());
        Assert.assertEquals(Tag.VERB, answer[1].getTag());
        Assert.assertEquals(Tag.VERB, answer[2].getTag());

        answer = tagger.posTag(new String[]{"tomamos", "uma", "decisão"});
        Assert.assertEquals(Tag.VERB, answer[0].getTag());
        Assert.assertEquals(Tag.DETERMINER, answer[1].getTag());
        Assert.assertEquals(Tag.NOUN, answer[2].getTag());

        answer = tagger.posTag(new String[]{"eles", "sairão", "hoje"});
        Assert.assertEquals(Tag.PERSONAL_PRONOUN, answer[0].getTag());
        Assert.assertEquals(Tag.VERB, answer[1].getTag());
        Assert.assertEquals(Tag.ADVERB, answer[2].getTag());
    }

    @Test
    public void testRegularVerbs() {
        TagPair[] answer = tagger.posTag(new String[]{"quem", "com", "ferro", "fere", "com", "ferro", "será", "ferido"});
        Assert.assertEquals(Tag.WH_PRONOUN, answer[0].getTag());
        Assert.assertEquals(Tag.PREPOSITION, answer[1].getTag());
        Assert.assertEquals(Tag.NOUN, answer[2].getTag());
        Assert.assertEquals(Tag.VERB_CONJUGATION, answer[3].getTag());
        Assert.assertEquals(Tag.PREPOSITION, answer[4].getTag());
        Assert.assertEquals(Tag.NOUN, answer[5].getTag());
        Assert.assertEquals(Tag.VERB_CONJUGATION, answer[6].getTag());
        // This is a verb, not adjective.
        Assert.assertEquals(Tag.ADJECTIVE, answer[7].getTag());
    }

    @Test
    public void testNouns() {
        // Tokenized sentence
        TagPair[] answer = tagger.posTag(new String[]{"o", "farol", "de", "o", "Fusca", "produz", "uma", "luz", "muito", "forte"});
        Assert.assertEquals(Tag.DETERMINER, answer[0].getTag());
        Assert.assertEquals(Tag.NOUN, answer[1].getTag());
        Assert.assertEquals(Tag.PREPOSITION, answer[2].getTag());
        Assert.assertEquals(Tag.DETERMINER, answer[3].getTag());
        Assert.assertEquals(Tag.NOUN_PROPER, answer[4].getTag());
        Assert.assertEquals(Tag.VERB, answer[5].getTag());
        Assert.assertEquals(Tag.DETERMINER, answer[6].getTag());
        Assert.assertEquals(Tag.NOUN, answer[7].getTag());
        Assert.assertEquals(Tag.ADVERB, answer[8].getTag());
        Assert.assertEquals(Tag.ADJECTIVE, answer[9].getTag());
    }

}
