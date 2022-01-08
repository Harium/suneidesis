package com.harium.suneidesis.linguistic.english.math;

import com.harium.suneidesis.linguistic.math.WordToNumber;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordToNumberTest {

    private WordToNumber converter;

    @Before
    public void setUp() {
        converter = new SimpleWordToNumber();
    }

    @Test
    public void testLessThanTen() {
        assertEquals(0, converter.toNumber("zero").intValue());
        assertEquals(1, converter.toNumber("one").intValue());
        assertEquals(2, converter.toNumber("two").intValue());
        assertEquals(3, converter.toNumber("three").intValue());
        assertEquals(4, converter.toNumber("four").intValue());
        assertEquals(5, converter.toNumber("five").intValue());
        assertEquals(6, converter.toNumber("six").intValue());
        assertEquals(7, converter.toNumber("seven").intValue());
        assertEquals(8, converter.toNumber("eight").intValue());
        assertEquals(9, converter.toNumber("nine").intValue());
    }

    @Test
    public void testTeens() {
        assertEquals(10, converter.toNumber("ten").intValue());
        assertEquals(11, converter.toNumber("eleven").intValue());
        assertEquals(12, converter.toNumber("twelve").intValue());
        assertEquals(13, converter.toNumber("thirteen").intValue());
        assertEquals(14, converter.toNumber("fourteen").intValue());
        assertEquals(15, converter.toNumber("fifteen").intValue());
        assertEquals(16, converter.toNumber("sixteen").intValue());
        assertEquals(17, converter.toNumber("seventeen").intValue());
        assertEquals(18, converter.toNumber("eighteen").intValue());
        assertEquals(19, converter.toNumber("nineteen").intValue());
    }

    @Test
    public void testGreaterThanTwenty() {
        assertEquals(21, converter.toNumber("twenty one").intValue());
        assertEquals(32, converter.toNumber("thirty two").intValue());
        assertEquals(43, converter.toNumber("forty three").intValue());
        assertEquals(54, converter.toNumber("fifty four").intValue());
        assertEquals(65, converter.toNumber("sixty five").intValue());
        assertEquals(76, converter.toNumber("seventy six").intValue());
        assertEquals(87, converter.toNumber("eighty seven").intValue());
        assertEquals(98, converter.toNumber("ninety eight").intValue());
        assertEquals(100, converter.toNumber("one hundred").intValue());
    }

    @Test
    public void testGreaterThanOneHundred() {
        assertEquals(101, converter.toNumber("one hundred one").intValue());
        assertEquals(2000000000, converter.toNumber("two billion").intValue());
        //assertEquals(2000000000, converter.toNumber("two billions").intValue());
    }

}
