package com.harium.suneidesis.planning;

import com.harium.suneidesis.concept.Being;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.helper.Provenance;
import com.harium.suneidesis.planning.instruction.FindTask;
import com.harium.suneidesis.repository.nitrite.NitriteMemoryKnowledgeBase;
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

        Concept task = new Concept("task");
        Provenance fact = new Provenance(task);
        fact.source(new Concept("sensors"));
        fact.subject(fridge);

        NitriteMemoryKnowledgeBase environment = new NitriteMemoryKnowledgeBase("environment");
        environment.add(task);

        BaseTask chopGarlic = new BaseTask("chop garlic");
        chopGarlic.addTask(new FindTask("find garlic", garlic));
        boolean executed = chopGarlic.execute(myself, environment);
        assertTrue(executed);
    }

    @Test
    public void testFindTask_EmptyStorage() {
        Being myself = new Being("Robot");

        Concept garlic = new Concept("garlic");
        Inventory fridge = new Inventory();
        fridge.owner(myself);
        //fridge.add(garlic);

        Concept task = new Concept("task");
        Provenance fact = new Provenance(task);
        fact.source(new Concept("sensors"));
        fact.subject(fridge);

        NitriteMemoryKnowledgeBase environment = new NitriteMemoryKnowledgeBase("environment");
        environment.add(task);

        BaseTask chopGarlic = new BaseTask("chop garlic");
        chopGarlic.addTask(new FindTask("find garlic", garlic));
        boolean executed = chopGarlic.execute(myself, environment);
        assertFalse(executed);
    }

}
