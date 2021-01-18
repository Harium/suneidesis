package com.harium.suneidesis.linguistic.matcher;


import org.junit.Assert;
import org.junit.Test;

public class EqTest {

    @Test
    public void testEmpty() {
        Eq eq = new Eq("");
        Assert.assertFalse(eq.matches(new String[]{"Hello", "my", "friend."}));
    }

    @Test
    public void testAll() {
        Eq eq = new Eq("my");
        Assert.assertTrue(eq.matches(new String[]{"Hello", "my", "friend."}));
        Assert.assertTrue(eq.matches(new String[]{"Hello", "friend.", "my"}));
        Assert.assertTrue(eq.matches(new String[]{"friend.", "my", "Hello"}));
    }

}
