package com.harium.suneidesis.knowledge.space;

import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.storage.Storage;

public class GalaxyGroup extends Concept {

    private Storage<Galaxy> galaxies;

    public Storage<Galaxy> getGalaxies() {
        return galaxies;
    }

    public void setGalaxies(Storage<Galaxy> galaxies) {
        this.galaxies = galaxies;
    }
}
