package com.harium.suneidesis.linguistic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class StringUtilsTest {

    @Test
    public void testCapitalize() {
        assertEquals("Apple", StringUtils.capitalize("apple"));
        assertEquals("Orange", StringUtils.capitalize("orange"));
        assertEquals("Banana", StringUtils.capitalize("Banana"));
        assertEquals("123", StringUtils.capitalize("123"));
    }

    @Test
    public void testJoin() {
        assertEquals("", StringUtils.join(",", new ArrayList<>()));
        assertEquals("apple", StringUtils.join(",", Collections.singletonList("apple")));
        assertEquals("apple,orange", StringUtils.join(",", Arrays.asList("apple", "orange")));
        assertEquals("apple,orange,banana", StringUtils.join(",", Arrays.asList("apple", "orange", "banana")));
        assertEquals("apple, orange and banana", StringUtils.join(", "," and ", Arrays.asList("apple", "orange", "banana")));
    }

}
