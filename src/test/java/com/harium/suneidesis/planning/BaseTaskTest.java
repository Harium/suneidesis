package com.harium.suneidesis.planning;

import com.harium.suneidesis.concept.Being;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Fact;
import com.harium.suneidesis.repository.MemoryKnowledgeBase;
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
        fridge.owner(myself);
        fridge.add(garlic);

        Fact fact = new Fact();
        fact.source(new Concept("sensors"));
        fact.subject(fridge);

        MemoryKnowledgeBase environment = new MemoryKnowledgeBase("environment");
        environment.add(fact);

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
        fridge.owner(myself);
        //fridge.add(garlic);

        Fact fact = new Fact();
        fact.source(new Concept("sensors"));
        fact.subject(fridge);

        MemoryKnowledgeBase environment = new MemoryKnowledgeBase("environment");
        environment.add(fact);

        BaseTask chopGarlic = new BaseTask();
        chopGarlic.addTask(new FindTask(garlic));
        boolean executed = chopGarlic.execute(myself, environment);
        assertFalse(executed);
    }

}
