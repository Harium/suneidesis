package com.harium.suneidesis.linguistic.english.math;

import com.harium.suneidesis.linguistic.math.NumberToWord;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberToWordTest {

    private NumberToWord converter;

    @Before
    public void setUp() {
        converter = new SimpleNumberToWord();
    }

    @Test
    public void testLessThanTen() {
        assertEquals("zero", converter.toWord(0));
        assertEquals("one", converter.toWord(1));
        assertEquals("two", converter.toWord(2));
        assertEquals("three", converter.toWord(3));
        assertEquals("four", converter.toWord(4));
        assertEquals("five", converter.toWord(5));
        assertEquals("six", converter.toWord(6));
        assertEquals("seven", converter.toWord(7));
        assertEquals("eight", converter.toWord(8));
        assertEquals("nine", converter.toWord(9));
    }

    @Test
    public void testTeens() {
        assertEquals("ten", converter.toWord(10));
        assertEquals("eleven", converter.toWord(11));
        assertEquals("twelve", converter.toWord(12));
        assertEquals("thirteen", converter.toWord(13));
        assertEquals("fourteen", converter.toWord(14));
        assertEquals("fifteen", converter.toWord(15));
        assertEquals("sixteen", converter.toWord(16));
        assertEquals("seventeen", converter.toWord(17));
        assertEquals("eighteen", converter.toWord(18));
        assertEquals("nineteen", converter.toWord(19));
    }

    @Test
    public void testGreaterThanTwenty() {
        assertEquals("twenty one", converter.toWord(21));
        assertEquals("thirty two", converter.toWord(32));
        assertEquals("forty three", converter.toWord(43));
        assertEquals("fifty four", converter.toWord(54));
        assertEquals("sixty five", converter.toWord(65));
        assertEquals("seventy six", converter.toWord(76));
        assertEquals("eighty seven", converter.toWord(87));
        assertEquals("ninety eight", converter.toWord(98));
        assertEquals("one hundred", converter.toWord(100));
    }

    @Test
    public void testGreaterThanOneHundred() {
        assertEquals("one hundred one", converter.toWord(101));
    }

}
