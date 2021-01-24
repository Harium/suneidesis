package com.harium.suneidesis.planning.instruction;

import com.harium.suneidesis.concept.Fact;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.planning.Inventory;
import com.harium.suneidesis.planning.BaseTask;

public class FindTask extends BaseTask {

    private Concept target;

    public FindTask(Concept target) {
        this.target = target;
    }

    @Override
    public boolean execute(Concept subject, KnowledgeBase environment) {
        boolean found = false;
        for (Fact fact : environment.getValues()) {
            if (fact.getSubject() instanceof Fact) {
                Fact subfact = (Fact) fact.getSubject();
                Concept concept = subfact.getSubject();
                if (concept instanceof Inventory) {
                    Inventory inventory = (Inventory) concept;
                    canAccess(subject, inventory);
                    for (Concept item : inventory.getAttributes().getValues()) {
                        if (target == item) {
                            found = true;
                            break;
                        }
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
