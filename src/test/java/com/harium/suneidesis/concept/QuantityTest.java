package com.harium.suneidesis.concept;

import com.harium.suneidesis.concept.numeral.Quantity;
import org.junit.Test;

import static com.harium.suneidesis.inspector.Inspector.does;
import static org.junit.Assert.*;

public class QuantityTest {

    @Test
    public void testInit() {
        Quantity quantity = new Quantity("5", "m");
        assertEquals("5", quantity.getValueText());

        assertTrue(does(quantity.getValue()).is(new Concept("5")));
        assertTrue(does(quantity.getUnit()).is(new Concept("m")));
    }

    @Test
    public void testCompare_DifferentUnits() {
        Quantity centimeter = new Quantity("5", "cm");
        Quantity meter = new Quantity("5", "m");

        assertFalse(does(meter).is(centimeter));
    }

    @Test
    public void testCompare_DifferentValues() {
        Quantity measure = new Quantity("5", "m");
        Quantity anotherMeasure = new Quantity("6", "m");

        assertFalse(does(measure).is(anotherMeasure));
    }

}
