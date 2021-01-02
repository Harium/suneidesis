package com.harium.suneidesis.knowledge.space;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.storage.Repository;

public class Universe extends Concept {

    private Repository<GalaxyGroup> galaxyGroups;

    public Repository<GalaxyGroup> getGalaxyGroups() {
        return galaxyGroups;
    }

    public void setGalaxyGroups(Repository<GalaxyGroup> galaxyGroups) {
        this.galaxyGroups = galaxyGroups;
    }
}
