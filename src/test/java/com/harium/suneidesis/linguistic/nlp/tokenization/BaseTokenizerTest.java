package com.harium.suneidesis.linguistic.nlp.tokenization;

import com.harium.suneidesis.linguistic.nlp.Tokenizer;
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

    @Test
    public void testEmptyToken() {
        String[] tokens = tokenizer.tokenize("Hello  World");

        Assert.assertEquals(2, tokens.length);
        Assert.assertEquals("Hello", tokens[0]);
        Assert.assertEquals("World", tokens[1]);
    }

    @Test
    public void testPunctuation() {
        String[] tokens = tokenizer.tokenize("Hello  World!");

        Assert.assertEquals(3, tokens.length);
        Assert.assertEquals("Hello", tokens[0]);
        Assert.assertEquals("World", tokens[1]);
        Assert.assertEquals("!", tokens[2]);
    }

}
