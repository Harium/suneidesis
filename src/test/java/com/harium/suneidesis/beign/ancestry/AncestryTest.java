package com.harium.suneidesis.beign.ancestry;

import com.harium.suneidesis.beign.Being;
import com.harium.suneidesis.beign.Creature;
import org.junit.Assert;
import org.junit.Test;

public class AncestryTest {

    @Test
    public void testHeteroSexualCoupleAncestry() {
        Being mother = new Being("Mary");
        Being father = new Being("John");

        BeingCouple couple = new BeingCouple(father, mother);

        Assert.assertEquals(father, couple.getFather());
        Assert.assertEquals(mother, couple.getMother());
    }

    @Test
    public void testInterspeciesCoupleAncestry() {
        Being mother = new Being("Mary");
        Creature father = new Creature("Spirit");

        GenericAncestry ancestry = new GenericAncestry(mother, father);

        Assert.assertEquals(2, ancestry.getProgenitors().size());
        Assert.assertEquals(mother, ancestry.getProgenitors().get(0));
        Assert.assertEquals(father, ancestry.getProgenitors().get(1));
    }

    @Test
    public void testSingleAncestor() {
        Being dolly = new Being("Dolly");

        SingleAncestor ancestor = new SingleAncestor(dolly);
        dolly.setAncestry(ancestor);

        Assert.assertEquals(dolly, ancestor.getSource());
    }

}
