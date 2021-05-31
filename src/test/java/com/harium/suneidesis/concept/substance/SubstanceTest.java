package com.harium.suneidesis.concept.substance;

import org.junit.Assert;
import org.junit.Test;

public class SubstanceTest {

    private static final Atom HYDROGEN = new Atom("Hydrogen", "H");
    private static final Atom CARBON = new Atom("Carbon", "C");

    @Test
    public void testAddAtom() {
        Molecule molecule = new Molecule("H");
        molecule.add(HYDROGEN);

        Assert.assertEquals("H", molecule.getFormula().getName());
    }

    @Test
    public void testAddBond() {
        Molecule molecule = new Molecule("Methane");
        molecule.add(CARBON);
        molecule.add(HYDROGEN);
        molecule.add(HYDROGEN);
        molecule.add(HYDROGEN);
        molecule.add(HYDROGEN);

        Assert.assertEquals("CHHHH", molecule.getFormula().getName());
    }

}
