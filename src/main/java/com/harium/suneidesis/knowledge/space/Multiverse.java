package com.harium.suneidesis.knowledge.space;

import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.storage.Storage;

public class Multiverse extends Concept {

    private Storage<Universe> universes;

    public Storage<Universe> getUniverses() {
        return universes;
    }

    public void setUniverses(Storage<Universe> universes) {
        this.universes = universes;
    }
}
