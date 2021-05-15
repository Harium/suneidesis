package com.harium.suneidesis;

import com.harium.suneidesis.math.converter.LengthConverter;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LengthConverterTest {

    private LengthConverter lengthConverter;

    @Before
    public void setUp() {
        lengthConverter = new LengthConverter();
    }

    @Test
    public void testConversion() {
        assertEquals("2.5", lengthConverter.convert("2500", LengthConverter.METER, LengthConverter.KILOMETER));
        assertEquals("1000", lengthConverter.convert("1", LengthConverter.KILOMETER, LengthConverter.METER));
        assertEquals("0.6213711899", lengthConverter.convert("1", LengthConverter.KILOMETER, LengthConverter.MILE).substring(0,12));
        assertEquals("4.828032", lengthConverter.convert("3", LengthConverter.MILE, LengthConverter.KILOMETER).substring(0,8));
    }

}
