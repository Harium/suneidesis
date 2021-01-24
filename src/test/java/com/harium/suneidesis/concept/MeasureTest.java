package com.harium.suneidesis.concept;

import com.harium.suneidesis.concept.numeral.Measure;
import org.junit.Test;

import static com.harium.suneidesis.inspector.Inspector.does;
import static org.junit.Assert.*;

public class MeasureTest {

    @Test
    public void testInit() {
        Measure measure = new Measure("5", "m");
        assertEquals("5", measure.getValueText());

        assertTrue(does(measure.getValue()).is(new Concept("5")));
        assertTrue(does(measure.getUnit()).is(new Concept("m")));
    }

    @Test
    public void testCompare_DifferentUnits() {
        Measure centimeter = new Measure("5", "cm");
        Measure meter = new Measure("5", "m");

        assertFalse(does(meter).is(centimeter));
    }

    @Test
    public void testCompare_DifferentValues() {
        Measure measure = new Measure("5", "m");
        Measure anotherMeasure = new Measure("6", "m");

        assertFalse(does(measure).is(anotherMeasure));
    }

}
