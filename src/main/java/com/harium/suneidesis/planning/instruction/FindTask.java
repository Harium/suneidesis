package com.harium.suneidesis.planning.instruction;

import com.harium.suneidesis.behavior.Environment;
import com.harium.suneidesis.consciousness.Consciousness;
import com.harium.suneidesis.knowledge.Thing;
import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.planning.Storage;
import com.harium.suneidesis.planning.Task;

public class FindTask extends Task {

    private Concept target;
    public static final Concept SEARCH = new Concept();

    public FindTask(Concept target) {
        this.target = target;
    }

    @Override
    public boolean execute(Consciousness subject, Environment environment) {
        boolean found = false;
        for (Thing concept : environment.getAll()) {
            if (concept instanceof Storage) {
                Storage storage = (Storage) concept;
                canAccess(subject, storage);
                for (Thing item : storage.getAll()) {
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

    private boolean canAccess(Consciousness subject, Storage storage) {
        return storage.canAccess(subject);
    }

}
