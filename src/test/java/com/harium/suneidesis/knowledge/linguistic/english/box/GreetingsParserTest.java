package com.harium.suneidesis.knowledge.linguistic.english.box;

import com.harium.suneidesis.input.InputContext;
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
        InputContext context = new InputContext();

        Assert.assertTrue(parser.matches(new InputContext("hi")));
        Assert.assertTrue(parser.matches(new InputContext("hi!")));
        Assert.assertTrue(parser.matches(new InputContext("Hello")));
        Assert.assertTrue(parser.matches(new InputContext("Hello!!")));

        Assert.assertFalse(parser.matches(new InputContext("Hola!")));
        Assert.assertFalse(parser.matches(new InputContext("Aloha!")));
    }

}
