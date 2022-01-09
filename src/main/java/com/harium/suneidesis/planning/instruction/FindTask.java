package com.harium.suneidesis.planning.instruction;

import com.harium.suneidesis.concept.Action;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.planning.ComplexTask;
import com.harium.suneidesis.planning.Inventory;
import com.harium.suneidesis.repository.KnowledgeBase;

import java.util.Iterator;

public class FindTask extends ComplexTask {

    public static final String ATTRIBUTE_TARGET = "target";

    public FindTask(String name, Concept target) {
        super(name);
        setTarget(target);
    }

    @Override
    public boolean start(KnowledgeBase environment) {
        boolean found = false;
        Iterator<Concept> iterator = environment.iterator();

        while (iterator.hasNext()) {
            Concept concept = iterator.next();
            Action fact = new Action(concept.getName()).wrap(concept);
            Concept factSubject = fact.getSubject();
            if (isInventory(factSubject)) {
                Inventory inventory = new Inventory().wrap(factSubject);

                Concept subject = subject();
                canAccess(subject, inventory);
                Iterator<Concept> inventoryIterator = inventory.getAttributes().iterator();
                while (inventoryIterator.hasNext()) {
                    Concept item = inventoryIterator.next();
                    Concept target = target();
                    if (target.getName().equals(item.getName())) {
                        found = true;
                        break;
                    }
                }
            }
        }

        if (!found) {
            return false;
        }

        // Execute subTasks
        return super.start(environment);
    }

    public Concept setTarget(Concept target) {
        return getAttributes().save(ATTRIBUTE_TARGET, target);
    }

    public Concept target() {
        return getAttributes().get(ATTRIBUTE_TARGET);
    }

    @Override
    public boolean canStart() {
        Concept target = target();
        return !target.isUnknown();
    }

    private boolean isInventory(Concept factSubject) {
        return "inventory".equals(factSubject.getName());
    }

    private boolean canAccess(Concept subject, Inventory inventory) {
        return inventory.getOwner().equals(subject);
    }

}
