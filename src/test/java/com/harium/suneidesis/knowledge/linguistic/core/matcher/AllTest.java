package com.harium.suneidesis.knowledge.linguistic.core.matcher;


import org.junit.Assert;
import org.junit.Test;

public class AllTest {

    @Test
    public void testEmpty() {
        All all = new All();
        Assert.assertTrue(all.matches(new String[]{"Hello", "my", "friend."}));
    }

    @Test
    public void testAll() {
        All all = new All("Hello", "my");
        Assert.assertTrue(all.matches(new String[]{"Hello", "my", "friend."}));
        Assert.assertTrue(all.matches(new String[]{"Hello", "friend.", "my"}));
        Assert.assertTrue(all.matches(new String[]{"friend.", "my", "Hello"}));
    }

}
