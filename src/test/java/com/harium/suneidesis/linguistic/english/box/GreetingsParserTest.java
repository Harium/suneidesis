package com.harium.suneidesis.linguistic.english.box;

import com.harium.suneidesis.chat.output.Output;
import com.harium.suneidesis.linguistic.english.box.GreetingsParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.harium.suneidesis.chat.box.BoxTextUtils.context;
import static org.mockito.Mockito.mock;

public class GreetingsParserTest {

    private GreetingsParser parser;

    @Before
    public void setUp() {
        parser = new GreetingsParser();
    }

    @Test
    public void testMatches() {
        Output output = mock(Output.class);

        Assert.assertTrue(parser.parse(context("hi"), output));
        Assert.assertTrue(parser.parse(context("hi!"), output));
        Assert.assertTrue(parser.parse(context("Hello"), output));
        Assert.assertTrue(parser.parse(context("Hello!!"), output));

        Assert.assertFalse(parser.parse(context("Hola!"), output));
        Assert.assertFalse(parser.parse(context("Aloha!"), output));
    }

}
