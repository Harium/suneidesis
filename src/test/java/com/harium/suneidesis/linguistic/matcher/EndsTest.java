package com.harium.suneidesis.linguistic.matcher;


import org.junit.Assert;
import org.junit.Test;

public class EndsTest {

    @Test
    public void testEmpty() {
        Ends sequence = new Ends();
        Assert.assertTrue(sequence.matches(new String[]{"Hello", "my", "friend."}));
    }

    @Test
    public void testAll() {
        Ends sequence = new Ends("my", "friend.");
        Assert.assertTrue(sequence.matches(new String[]{"Hello", "my", "friend."}));
        Assert.assertFalse(sequence.matches(new String[]{"Hello", "friend.", "my"}));
        Assert.assertFalse(sequence.matches(new String[]{"friend.", "my", "Hello"}));
    }
}
