package com.harium.suneidesis.linguistic.matcher;


import org.junit.Assert;
import org.junit.Test;

public class RegexTest {

    @Test
    public void testEmpty() {
        Regex regex = new Regex("");
        Assert.assertFalse(regex.matches(new String[]{"Hello", "my", "friend."}));
    }

    @Test
    public void testRegex() {
        Regex regex = new Regex("\\d+");
        Assert.assertTrue(regex.matches(new String[]{"2"}));
        Assert.assertTrue(regex.matches(new String[]{"23"}));
        Assert.assertTrue(regex.matches(new String[]{"123"}));
    }

}
