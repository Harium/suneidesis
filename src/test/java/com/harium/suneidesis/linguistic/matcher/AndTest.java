package com.harium.suneidesis.linguistic.matcher;


import org.junit.Assert;
import org.junit.Test;

public class AndTest {

    @Test
    public void testEmpty() {
        And all = new And();
        Assert.assertTrue(all.matches(new String[]{"Hello", "my", "friend."}));
    }

    @Test
    public void testAll() {
        And all = new And(new Eq("Hello"), new Eq("my"));
        Assert.assertTrue(all.matches(new String[]{"Hello", "my", "friend."}));
        Assert.assertTrue(all.matches(new String[]{"Hello", "friend.", "my"}));
        Assert.assertTrue(all.matches(new String[]{"friend.", "my", "Hello"}));
    }

}
