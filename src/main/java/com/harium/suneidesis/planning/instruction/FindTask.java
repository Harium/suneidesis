package com.harium.suneidesis.planning.instruction;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.helper.Provenance;
import com.harium.suneidesis.planning.BaseTask;
import com.harium.suneidesis.planning.Inventory;
import com.harium.suneidesis.repository.KnowledgeBase;

public class FindTask extends BaseTask {

    private Concept target;

    public FindTask(String name, Concept target) {
        super(name);
        this.target = target;
    }

    @Override
    public boolean execute(Concept subject, KnowledgeBase environment) {
        boolean found = false;
        for (Concept concept : environment.getValues()) {
            Provenance fact = new Provenance(concept);
            Concept factSubject = fact.getSubject();
            if (factSubject instanceof Inventory) {
                Inventory inventory = (Inventory) factSubject;
                canAccess(subject, inventory);
                for (Concept item : inventory.getAttributes().getValues()) {
                    if (target == item) {
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

    private boolean canAccess(Concept subject, Inventory inventory) {
        return inventory.getOwner().equals(subject);
    }

}
