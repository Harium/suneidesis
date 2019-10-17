package com.harium.suneidesis.knowledge.space;

import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.storage.Storage;

public class Universe extends Concept {

    private Storage<GalaxyGroup> galaxyGroups;

    public Storage<GalaxyGroup> getGalaxyGroups() {
        return galaxyGroups;
    }

    public void setGalaxyGroups(Storage<GalaxyGroup> galaxyGroups) {
        this.galaxyGroups = galaxyGroups;
    }
}
