package com.harium.suneidesis.knowledge.linguistic.core.tokenization;

import com.harium.suneidesis.knowledge.linguistic.core.nlp.tokenizer.LowerCaseTokenizer;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.tokenizer.Tokenizer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LowerCaseTokenizerTest {

    Tokenizer tokenizer;

    @Before
    public void setUp() {
        tokenizer = new LowerCaseTokenizer();
    }

    @Test
    public void testSingleWord() {
        String[] tokens = tokenizer.tokenize("Hi");

        Assert.assertEquals(1, tokens.length);
        Assert.assertEquals("hi", tokens[0]);
    }

}
