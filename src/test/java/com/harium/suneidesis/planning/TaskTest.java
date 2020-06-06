package com.harium.suneidesis.planning;

import com.harium.suneidesis.behavior.Environment;
import com.harium.suneidesis.beign.Being;
import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.planning.instruction.FindTask;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TaskTest {

    @Test
    public void testFindTask() {
        Being myself = new Being("Robot");

        Concept garlic = new Concept();
        Storage fridge = new Storage();
        fridge.setOwner(myself);
        fridge.add(garlic);

        Environment environment = new Environment();
        environment.add(fridge);

        Task chopGarlic = new Task();
        chopGarlic.addTask(new FindTask(garlic));
        boolean executed = chopGarlic.execute(myself, environment);
        assertTrue(executed);
    }

    @Test
    public void testFindTask_EmptyStorage() {
        Being myself = new Being("Robot");

        Concept garlic = new Concept();
        Storage fridge = new Storage();
        fridge.setOwner(myself);
        //fridge.add(garlic);

        Environment environment = new Environment();
        environment.add(fridge);

        Task chopGarlic = new Task();
        chopGarlic.addTask(new FindTask(garlic));
        boolean executed = chopGarlic.execute(myself, environment);
        assertFalse(executed);
    }

}
