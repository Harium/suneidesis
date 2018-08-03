package com.harium.suneidesis.knowledge.linguistic.english.box;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GreetingsParserTest {

    private GreetingsParser parser;

    @Before
    public void setUp() {
        parser = new GreetingsParser();
    }

    @Test
    public void testMatches() {
        Assert.assertTrue(parser.matches("hi"));
        Assert.assertTrue(parser.matches("hi!"));
        Assert.assertTrue(parser.matches("Hello"));
        Assert.assertTrue(parser.matches("Hello!!"));

        Assert.assertFalse(parser.matches("Hola!"));
        Assert.assertFalse(parser.matches("Aloha!"));
    }

}
