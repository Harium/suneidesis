package com.harium.suneidesis.material;

import com.harium.suneidesis.knowledge.material.Atom;
import com.harium.suneidesis.knowledge.material.Molecule;
import org.junit.Assert;
import org.junit.Test;

public class MaterialTest {

    private static final Atom HYDROGEN = createProtium();
    private static final Atom CARBON = new Atom("Carbon", 6, 12);

    @Test
    public void testAddAtom() {
        Molecule molecule = new Molecule();
        molecule.add(HYDROGEN);

        Assert.assertEquals(1, molecule.size());
        Assert.assertNotNull(molecule.bonds(HYDROGEN));
    }

    @Test
    public void testAddBond() {
        Molecule molecule = new Molecule();
        molecule.add(CARBON);

        Atom h1 = createProtium();
        Atom h2 = createProtium();
        Atom h3 = createProtium();
        Atom h4 = createProtium();
        molecule.add(h1, h2, h3, h4);

        molecule.bond(CARBON, h1);
        molecule.bond(CARBON, h2);
        molecule.bond(CARBON, h3);
        molecule.bond(CARBON, h4);

        Assert.assertEquals(5, molecule.size());
        Assert.assertEquals(4, molecule.bonds(CARBON).size());

        Assert.assertEquals(1, molecule.bonds(h1).size());
        Assert.assertEquals(1, molecule.bonds(h2).size());
        Assert.assertEquals(1, molecule.bonds(h3).size());
        Assert.assertEquals(1, molecule.bonds(h4).size());
    }

    private static Atom createProtium() {
        return new Atom("Protium", 1, 1);
    }

}
