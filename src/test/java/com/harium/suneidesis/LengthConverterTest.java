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
        assertEquals("1.553427975", lengthConverter.convert("2500", LengthConverter.METER, LengthConverter.MILE));
        assertEquals("8202.10000", lengthConverter.convert("2500", LengthConverter.METER, LengthConverter.FOOT));
        assertEquals("98425.2500", lengthConverter.convert("2500", LengthConverter.METER, LengthConverter.INCH));

        assertEquals("1000", lengthConverter.convert("1", LengthConverter.KILOMETER, LengthConverter.METER));
        assertEquals("0.62137119", lengthConverter.convert("1", LengthConverter.KILOMETER, LengthConverter.MILE));
        assertEquals("4.828032", lengthConverter.convert("3", LengthConverter.MILE, LengthConverter.KILOMETER));
    }

}
