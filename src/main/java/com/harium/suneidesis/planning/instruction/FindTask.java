package com.harium.suneidesis.planning.instruction;

import com.harium.suneidesis.behavior.Environment;
import com.harium.suneidesis.consciousness.Consciousness;
import com.harium.suneidesis.knowledge.Thing;
import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.planning.Storage;
import com.harium.suneidesis.planning.Task;

public class FindTask extends Task {

    public static final Concept SEARCH = new Concept();

    public FindTask(Concept object, Storage fridge) {
        instruction.setSubject(fridge);
        instruction.setObject(object);
        instruction.setPredicate(SEARCH);
    }

    @Override
    public boolean execute(Consciousness subject, Environment environment) {
        boolean found = false;
        for (Thing concept : environment.getAll()) {
            if (instruction.getSubject() == concept) {
                Storage storage = (Storage) concept;
                canAccess(subject, storage);
                for (Thing item : storage.getAll()) {
                    if (instruction.getObject() == item) {
                        found = true;
                    }
                }
            }
        }

        if (!found) {
            return false;
        }

        return super.execute(subject, environment);
    }

    // Private property
    private boolean canAccess(Consciousness subject, Storage storage) {
        return subject == storage.getOwner();
    }

}
