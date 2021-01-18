package com.harium.suneidesis.linguistic.matcher;


import org.junit.Assert;
import org.junit.Test;

public class StartsTest {

    @Test
    public void testEmpty() {
        Starts sequence = new Starts();
        Assert.assertTrue(sequence.matches(new String[]{"Hello", "my", "friend."}));
    }

    @Test
    public void testAll() {
        Starts sequence = new Starts("Hello", "my");
        Assert.assertTrue(sequence.matches(new String[]{"Hello", "my", "friend."}));
        Assert.assertFalse(sequence.matches(new String[]{"Hello", "friend.", "my"}));
        Assert.assertFalse(sequence.matches(new String[]{"friend.", "my", "Hello"}));
    }
}
