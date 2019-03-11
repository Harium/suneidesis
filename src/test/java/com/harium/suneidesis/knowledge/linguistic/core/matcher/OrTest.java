package com.harium.suneidesis.knowledge.linguistic.core.matcher;


import org.junit.Assert;
import org.junit.Test;

public class OrTest {

    @Test
    public void testEmpty() {
        Or or = new Or();
        Assert.assertTrue(or.matches(new String[]{"Hello", "my", "friend."}));
    }

    @Test
    public void testOr() {
        Or or = new Or(new Eq("Hi"), new Eq("Hello"));
        Assert.assertTrue(or.matches(new String[]{"Hello", "my", "friend."}));
        Assert.assertTrue(or.matches(new String[]{"Hello", "friend.", "my"}));
        Assert.assertTrue(or.matches(new String[]{"friend.", "my", "Hello"}));
    }

}
