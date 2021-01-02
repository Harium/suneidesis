package com.harium.suneidesis.planning.instruction;

import com.harium.suneidesis.behavior.Environment;
import com.harium.suneidesis.consciousness.Consciousness;
import com.harium.suneidesis.concept.Thing;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.planning.Inventory;
import com.harium.suneidesis.planning.BaseTask;

public class FindTask extends BaseTask {

    private Concept target;
    public static final Concept SEARCH = new Concept();

    public FindTask(Concept target) {
        this.target = target;
    }

    @Override
    public boolean execute(Consciousness subject, Environment environment) {
        boolean found = false;
        for (Thing concept : environment.getAll()) {
            if (concept instanceof Inventory) {
                Inventory inventory = (Inventory) concept;
                canAccess(subject, inventory);
                for (Thing item : inventory.getAll()) {
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

    private boolean canAccess(Consciousness subject, Inventory inventory) {
        return inventory.canAccess(subject);
    }

}
