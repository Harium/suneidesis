package com.harium.suneidesis.behavior.metabolism;

import com.harium.suneidesis.concept.substance.Molecule;
import org.junit.Assert;
import org.junit.Test;

public class MetabolicProcessTest {

    private static final Molecule CARBON_MONOXIDE = new Molecule();
    private static final Molecule CARBON_DIOXIDE = new Molecule();
    private static final Molecule HYDROGEN = new Molecule();
    private static final Molecule WATER = new Molecule();

    Metabolism metabolism;

    @Test
    public void testMetabolicProcess() {
        metabolism = new Metabolism();
        metabolism.sum(CARBON_MONOXIDE, 10);
        metabolism.sum(CARBON_DIOXIDE, 10);
        metabolism.sum(HYDROGEN, 10);
        metabolism.sum(WATER, 10);

        metabolism.processes.add(new CarbonElectrocatalysis(metabolism));
        metabolism.tick();

        Assert.assertEquals(11, metabolism.quantity(CARBON_MONOXIDE), 0);
        Assert.assertEquals(9, metabolism.quantity(CARBON_DIOXIDE), 0);
        Assert.assertEquals(8, metabolism.quantity(HYDROGEN), 0);
        Assert.assertEquals(11, metabolism.quantity(WATER), 0);
    }

    class CarbonElectrocatalysis implements MetabolicProcess {
        Metabolism metabolism = null;

        public CarbonElectrocatalysis(Metabolism metabolism) {
            this.metabolism = metabolism;
        }

        @Override
        public void process() {
            if (metabolism.getResources().containsKey(CARBON_DIOXIDE)) {
                // Spend 1 molecule
                this.metabolism.sum(CARBON_DIOXIDE, -1);
                this.metabolism.sum(HYDROGEN, -2);
                this.metabolism.sum(CARBON_MONOXIDE, 1);
                this.metabolism.sum(WATER, 1);
            }
        }
    }


}
