package com.harium.suneidesis.knowledge.linguistic.core.matcher;


import org.junit.Assert;
import org.junit.Test;

public class AnyTest {

    @Test
    public void testEmpty() {
        Any any = new Any();
        Assert.assertTrue(any.matches(new String[]{"Hello", "my", "friend."}));
    }

    @Test
    public void testAll() {
        Any any = new Any("Hello", "my", "friend.");
        Assert.assertTrue(any.matches(new String[]{"Hello", "my", "friend."}));
        Assert.assertTrue(any.matches(new String[]{"Hello", "folks!"}));
        Assert.assertTrue(any.matches(new String[]{"I", "forgot", "my", "keys"}));
        Assert.assertTrue(any.matches(new String[]{"I", "need", "an", "easy", "friend."}));
    }

}
