package com.harium.suneidesis.task;

import com.harium.suneidesis.concept.Action;
import com.harium.suneidesis.concept.Being;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.repository.MemoryKnowledgeBase;
import com.harium.suneidesis.task.planning.ComplexKnowledgeTask;
import com.harium.suneidesis.task.planning.FindTask;
import com.harium.suneidesis.task.planning.Inventory;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BaseTaskTest {

    @Test
    public void testFindTask() {
        Being myself = new Being("Robot");

        Concept garlic = new Concept("garlic");
        Inventory fridge = new Inventory();
        fridge.owner(myself);
        fridge.add(garlic);

        Action task = new Action("task");
        //task.source(new Concept("sensors"));
        task.subject(fridge);

        MemoryKnowledgeBase environment = new MemoryKnowledgeBase("environment");
        environment.save(task);

        ComplexKnowledgeTask chopGarlic = new ComplexKnowledgeTask("chop garlic", environment);
        chopGarlic.setSubject(myself);
        chopGarlic.addSubTask(new FindTask("find garlic", garlic, environment));

        boolean executed = chopGarlic.start();
        assertTrue(executed);
    }

    @Test
    public void testFindTask_EmptyStorage() {
        Being myself = new Being("Robot");

        Concept garlic = new Concept("garlic");
        Inventory fridge = new Inventory();
        fridge.owner(myself);
        //fridge.add(garlic);

        Action task = new Action("task");
        //task.source(new Concept("sensors"));
        task.subject(fridge);

        MemoryKnowledgeBase environment = new MemoryKnowledgeBase("environment");
        environment.save(task);

        ComplexKnowledgeTask chopGarlic = new ComplexKnowledgeTask("chop garlic", environment);
        chopGarlic.setSubject(myself);
        chopGarlic.addSubTask(new FindTask("find garlic", garlic, environment));

        boolean executed = chopGarlic.start();
        assertFalse(executed);
    }

}
