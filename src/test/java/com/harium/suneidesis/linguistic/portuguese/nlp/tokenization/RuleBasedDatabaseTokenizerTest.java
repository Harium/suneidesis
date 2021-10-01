package com.harium.suneidesis.linguistic.portuguese.nlp.tokenization;

import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.concept.word.WordPunctuation;
import com.harium.suneidesis.concept.word.WordShort;
import com.harium.suneidesis.linguistic.nlp.Tokenizer;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.repository.MemoryKnowledgeBase;
import com.harium.suneidesis.repository.word.WordKnowledgeBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RuleBasedDatabaseTokenizerTest {

    Tokenizer tokenizer;

    @Before
    public void setUp() {
        KnowledgeBase knowledgeBase = new MemoryKnowledgeBase();
        WordKnowledgeBase database = new WordKnowledgeBase(knowledgeBase);
        database.addWord(new WordPunctuation(","));
        database.addWord(new WordPunctuation("."));

        Word voce = new Word("você");
        database.addWord(voce);
        Word vc = new WordShort("vc");
        vc.setLemma(voce);
        database.addWord(vc);

        tokenizer = new RuleBasedDatabaseTokenizer(database);
    }

    @Test
    public void testSingleWord() {
        String[] answer = tokenizer.tokenize("casa");
        Assert.assertArrayEquals(new String[]{"casa"}, answer);
    }

    @Test
    public void testAbbreviation() {
        String[] answer = tokenizer.tokenize("Vi vc na casa");
        Assert.assertArrayEquals(new String[]{"Vi", "você", "em", "a", "casa"}, answer);
    }

    @Test
    public void testPunctuation() {
        String[] answer = tokenizer.tokenize("a casa, a porta e o telhado.");
        Assert.assertArrayEquals(new String[]{"a", "casa", ",", "a", "porta", "e", "o", "telhado", "."}, answer);
    }

    @Test
    public void testSplitContractions() {
        String[] answer = tokenizer.tokenize("Pela janela do carro naquela estrada");
        Assert.assertArrayEquals(new String[]{"por", "a", "janela", "de", "o", "carro", "em", "aquela", "estrada"}, answer);
    }

    @Test
    public void testEndingContractions() {
        // Example from Mac Morpho (http://nilc.icmc.usp.br/macmorpho/)
        Assert.assertArrayEquals(new String[]{"acompanhar", "-lo"}, tokenizer.tokenize("acompanhá-lo"));
        Assert.assertArrayEquals(new String[]{"defender", "-lo"}, tokenizer.tokenize("defendê-lo"));
        Assert.assertArrayEquals(new String[]{"dissuadir", "-lo"}, tokenizer.tokenize("dissuadí-lo"));
        Assert.assertArrayEquals(new String[]{"fazer", "-lhe"}, tokenizer.tokenize("fazer-lhe"));
    }

}
