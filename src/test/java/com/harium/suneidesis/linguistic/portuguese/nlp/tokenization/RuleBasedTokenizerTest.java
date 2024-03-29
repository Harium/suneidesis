package com.harium.suneidesis.linguistic.portuguese.nlp.tokenization;

import com.harium.suneidesis.linguistic.nlp.Tokenizer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RuleBasedTokenizerTest {

    Tokenizer tokenizer;

    @Before
    public void setUp() {
        tokenizer = new RuleBasedTokenizer();
    }

    @Test
    public void testSingleWord() {
        String[] answer = tokenizer.tokenize("casa");
        Assert.assertArrayEquals(new String[]{"casa"}, answer);
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
