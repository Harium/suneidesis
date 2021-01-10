package com.harium.suneidesis.behavior.metabolism;

import com.harium.suneidesis.concept.substance.Molecule;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MetabolismTest {

    private Metabolism metabolism;

    @Before
    public void setUp() {
        metabolism = new Metabolism();
    }

    @Test
    public void testEnergyConsumption() {
        metabolism.energy = 100;
        metabolism.addNeed("Food", 0, 1);

        Assert.assertEquals(100, metabolism.energy, 0);
        metabolism.tick();
        Assert.assertEquals(99, metabolism.energy, 0);
    }

    @Test
    public void testEnergyConsumptionWithMultipleNeeds() {
        metabolism.energy = 100;
        metabolism.addNeed("Food", 0, 1);
        metabolism.addNeed("Water", 0, 1);

        Assert.assertEquals(100, metabolism.energy, 0);
        metabolism.tick();
        Assert.assertEquals(98, metabolism.energy, 0);
    }

    @Test
    public void testAbsorb() {
        Molecule water = new Molecule("Water");

        Assert.assertEquals(0, metabolism.quantity(water), 0);
        metabolism.sum(water, 1);
        Assert.assertEquals(0, metabolism.quantity(water), 1);

    }

    @Test
    public void testRecover() {
        metabolism.energy = 0;
        Assert.assertEquals(0, metabolism.energy, 0);

        metabolism.recover(1);
        Assert.assertEquals(1, metabolism.energy, 0);
    }

}
