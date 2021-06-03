package com.harium.suneidesis.planning.instruction;

import com.harium.suneidesis.concept.Action;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.planning.BaseTask;
import com.harium.suneidesis.planning.Inventory;
import com.harium.suneidesis.repository.KnowledgeBase;

import java.util.Iterator;

public class FindTask extends BaseTask {

    private Concept target;

    public FindTask(String name, Concept target) {
        super(name);
        this.target = target;
    }

    @Override
    public boolean execute(Concept subject, KnowledgeBase environment) {
        boolean found = false;
        Iterator<Concept> iterator = environment.iterator();
        while (iterator.hasNext()) {
            Concept concept = iterator.next();
            Action fact = new Action(concept.getName()).wrap(concept);
            Concept factSubject = fact.getSubject();
            if (isInventory(factSubject)) {
                Inventory inventory = new Inventory().wrap(factSubject);
                canAccess(subject, inventory);
                Iterator<Concept> inventoryIterator = inventory.getAttributes().iterator();
                while (inventoryIterator.hasNext()) {
                    Concept item = inventoryIterator.next();

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

        return super.execute(subject, environment);
    }

    private boolean isInventory(Concept factSubject) {
        return "inventory".equals(factSubject.getName());
    }

    private boolean canAccess(Concept subject, Inventory inventory) {
        return inventory.getOwner().equals(subject);
    }

}
