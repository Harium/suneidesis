package com.harium.suneidesis.knowledge.linguistic.core.tokenization;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BaseTokenizerTest {

    Tokenizer tokenizer;

    @Before
    public void setUp() {
        tokenizer = new BaseTokenizer();
    }

    @Test
    public void testSingleWord() {
        String[] tokens = tokenizer.tokenize("Hi");

        Assert.assertEquals(1, tokens.length);
        Assert.assertEquals("Hi", tokens[0]);
    }

}
