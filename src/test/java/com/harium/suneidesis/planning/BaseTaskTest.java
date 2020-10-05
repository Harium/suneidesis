package com.harium.suneidesis.planning;

import com.harium.suneidesis.behavior.Environment;
import com.harium.suneidesis.beign.Being;
import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.planning.instruction.FindTask;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BaseTaskTest {

    @Test
    public void testFindTask() {
        Being myself = new Being("Robot");

        Concept garlic = new Concept();
        Inventory fridge = new Inventory();
        fridge.setOwner(myself);
        fridge.add(garlic);

        Environment environment = new Environment();
        environment.add(fridge);

        BaseTask chopGarlic = new BaseTask();
        chopGarlic.addTask(new FindTask(garlic));
        boolean executed = chopGarlic.execute(myself, environment);
        assertTrue(executed);
    }

    @Test
    public void testFindTask_EmptyStorage() {
        Being myself = new Being("Robot");

        Concept garlic = new Concept();
        Inventory fridge = new Inventory();
        fridge.setOwner(myself);
        //fridge.add(garlic);

        Environment environment = new Environment();
        environment.add(fridge);

        BaseTask chopGarlic = new BaseTask();
        chopGarlic.addTask(new FindTask(garlic));
        boolean executed = chopGarlic.execute(myself, environment);
        assertFalse(executed);
    }

}
