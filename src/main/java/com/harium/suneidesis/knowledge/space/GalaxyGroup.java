package com.harium.suneidesis.knowledge.space;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.storage.Repository;

public class GalaxyGroup extends Concept {

    private Repository<Galaxy> galaxies;

    public Repository<Galaxy> getGalaxies() {
        return galaxies;
    }

    public void setGalaxies(Repository<Galaxy> galaxies) {
        this.galaxies = galaxies;
    }
}
