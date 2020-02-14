package com.harium.suneidesis.knowledge.linguistic.portuguese.nlp;

import com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.tokenization.RuleBasedTokenizer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RuleBasedTokenizerTest {

    RuleBasedTokenizer tokenizer;

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
    public void testPonctuation() {
        String[] answer = tokenizer.tokenize("a casa, a porta e o telhado.");
        Assert.assertArrayEquals(new String[]{"a", "casa", ",", "a", "porta", "e", "o", "telhado", "."}, answer);
    }

    @Test
    public void testSplitContractions() {
        String[] answer = tokenizer.tokenize("Pela janela do carro naquela estrada");
        Assert.assertArrayEquals(new String[]{"por", "a", "janela", "de", "o", "carro", "em", "aquela", "estrada"}, answer);
    }

}
