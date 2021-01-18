package com.harium.suneidesis.linguistic.english.math;

import com.harium.suneidesis.linguistic.english.math.SimpleNumberToWord;
import com.harium.suneidesis.linguistic.math.NumberToWord;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumberToWordTest {

    private NumberToWord converter;

    @Before
    public void setUp() {
        converter = new SimpleNumberToWord();
    }

    @Test
    public void testLessThanTen() {
        Assert.assertEquals("zero", converter.toWord(0));
        Assert.assertEquals("one", converter.toWord(1));
        Assert.assertEquals("two", converter.toWord(2));
        Assert.assertEquals("three", converter.toWord(3));
        Assert.assertEquals("four", converter.toWord(4));
        Assert.assertEquals("five", converter.toWord(5));
        Assert.assertEquals("six", converter.toWord(6));
        Assert.assertEquals("seven", converter.toWord(7));
        Assert.assertEquals("eight", converter.toWord(8));
        Assert.assertEquals("nine", converter.toWord(9));
    }

    @Test
    public void testTens() {
        Assert.assertEquals("ten", converter.toWord(10));
        Assert.assertEquals("eleven", converter.toWord(11));
        Assert.assertEquals("twelve", converter.toWord(12));
        Assert.assertEquals("thirteen", converter.toWord(13));
        Assert.assertEquals("fourteen", converter.toWord(14));
        Assert.assertEquals("fifteen", converter.toWord(15));
        Assert.assertEquals("sixteen", converter.toWord(16));
        Assert.assertEquals("seventeen", converter.toWord(17));
        Assert.assertEquals("eighteen", converter.toWord(18));
        Assert.assertEquals("nineteen", converter.toWord(19));
    }

    @Test
    public void testGreaterThanTwenty() {
        Assert.assertEquals("twenty one", converter.toWord(21));
        Assert.assertEquals("thirty two", converter.toWord(32));
        Assert.assertEquals("forty three", converter.toWord(43));
        Assert.assertEquals("fifty four", converter.toWord(54));
        Assert.assertEquals("sixty five", converter.toWord(65));
        Assert.assertEquals("seventy six", converter.toWord(76));
        Assert.assertEquals("eighty seven", converter.toWord(87));
        Assert.assertEquals("ninety eight", converter.toWord(98));
        Assert.assertEquals("one hundred", converter.toWord(100));
    }

    @Test
    public void testGreaterThanOneHundred() {
        Assert.assertEquals("one hundred one", converter.toWord(101));
    }

}
