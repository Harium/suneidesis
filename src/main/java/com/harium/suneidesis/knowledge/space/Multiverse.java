package com.harium.suneidesis.knowledge.space;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.storage.Repository;

public class Multiverse extends Concept {

    private Repository<Universe> universes;

    public Repository<Universe> getUniverses() {
        return universes;
    }

    public void setUniverses(Repository<Universe> universes) {
        this.universes = universes;
    }
}
