package com.harium.suneidesis.behavior;

import com.harium.suneidesis.beign.Being;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class OrganicBehaviorTest {

    Being being;
    OrganicBehavior behavior;

    @Before
    public void setUp() {
        being = new Being("Being");

        behavior = new OrganicBehavior();
        being.setBehavior(behavior);
    }

    @Test
    public void testInit() {
        being.getStatus().has(OrganicBehavior.ATTR_HUNGRY);
        being.getStatus().has(OrganicBehavior.ATTR_THIRSTY);
    }

    @Test
    public void testBehavior() {
        float hungriness = behavior.getHungriness();
        float thirstiness = behavior.getThirstiness();

        being.behave();

        Assert.assertTrue(hungriness > behavior.getHungriness());
        Assert.assertTrue(thirstiness > behavior.getThirstiness());
    }

}
