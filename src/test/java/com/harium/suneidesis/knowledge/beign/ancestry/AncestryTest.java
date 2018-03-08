package com.harium.suneidesis.knowledge.beign.ancestry;

import com.harium.suneidesis.knowledge.beign.Being;
import org.junit.Assert;
import org.junit.Test;

public class AncestryTest {

    @Test
    public void testHeteroSexualCoupleAncestry() {
        Being mother = new Being("Mary");
        Being father = new Being("John");

        HeteroSexualCouple couple = new HeteroSexualCouple(father, mother);

        Assert.assertEquals(father, couple.getFather());
        Assert.assertEquals(mother, couple.getMother());
    }

    @Test
    public void testSingleAncestor() {
        Being dolly = new Being("Dolly");

        SingleAncestor ancestor = new SingleAncestor(dolly);
        dolly.setAncestry(ancestor);

        Assert.assertEquals(dolly, ancestor.getSource());
    }

}
