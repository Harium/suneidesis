package com.harium.suneidesis.linguistic.matcher;


import org.junit.Assert;
import org.junit.Test;

public class SequenceTest {

    @Test
    public void testEmpty() {
        Sequence sequence = new Sequence();
        Assert.assertTrue(sequence.matches(new String[]{"Hello", "my", "friend."}));
    }

    @Test
    public void testAll() {
        Sequence sequence = new Sequence("Hello", "my");
        Assert.assertTrue(sequence.matches(new String[]{"Hello", "my", "friend."}));
        Assert.assertTrue(sequence.matches(new String[]{"Hello", "friend.", "my"}));
        Assert.assertFalse(sequence.matches(new String[]{"friend.", "my", "Hello"}));
    }
}
