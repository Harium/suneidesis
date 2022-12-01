package com.harium.suneidesis.math;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BasicMathOperationsTest {

    private BasicMathOperations operations;

    @Before
    public void setUp() {
        operations = new BasicMathOperations();
    }

    @Test
    public void testPlus() {
        assertEquals("10", operations.plus("1", "9"));
    }

    @Test
    public void testMinus() {
        assertEquals("-8", operations.minus("1", "9"));
    }

    @Test
    public void testTimes() {
        assertEquals("800", operations.times("100", "8"));
    }

    @Test
    public void testDivide() {
        assertEquals("30", operations.divide("90", "3"));
    }

    @Test
    public void testPercentage() {
        assertEquals("25", operations.percentOf("100", "25"));
    }

    @Test
    public void testPercentageOf() {
        assertEquals("0.625", operations.percentageOf("400000", "2500"));
    }
}
