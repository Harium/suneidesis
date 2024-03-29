package com.harium.suneidesis.concept.measurement;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.measurement.Measurement;
import org.junit.Test;

import static com.harium.suneidesis.concept.helper.Inspector.does;
import static org.junit.Assert.*;

public class MeasurementTest {

    @Test
    public void testInit() {
        Measurement measurement = new Measurement("5", "m");
        assertEquals("5", measurement.getValue());

        // False because concepts are not compared fairly
        // assertTrue(does(measurement.getUnitConcept()).is(new Concept("m")));
        assertTrue(does(measurement.getValueConcept()).is(new Concept("5")));

        Measurement toCompare = new Measurement("5", "m");
        assertTrue(measurement.equals(toCompare));
    }

    @Test
    public void testCompare_DifferentUnits() {
        Measurement centimeter = new Measurement("5", "cm");
        Measurement meter = new Measurement("5", "m");

        assertFalse(does(meter).is(centimeter));
        assertFalse(meter.equals(centimeter));
    }

    @Test
    public void testCompare_DifferentValues() {
        Measurement measurement = new Measurement("5", "m");
        Measurement anotherMeasurement = new Measurement("6", "m");

        assertFalse(does(measurement).is(anotherMeasurement));
        assertFalse(measurement.equals(anotherMeasurement));
    }

    @Test
    public void testIncrement() {
        Measurement measurement = new Measurement("5.0", "m");
        measurement.increment(1);
        assertEquals("6.0", measurement.getValue());

        measurement.increment(-1.2);
        assertEquals("4.8", measurement.getValue());
    }
}
