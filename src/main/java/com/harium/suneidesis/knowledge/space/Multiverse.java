package com.harium.suneidesis.knowledge.space;

import com.harium.suneidesis.knowledge.concept.Concept;

import java.util.Map;

public class Universe extends Concept {

    private Map<String, Galaxy> galaxies;

    public Map<String, Galaxy> getGalaxies() {
        return galaxies;
    }

    public void setGalaxies(Map<String, Galaxy> galaxies) {
        this.galaxies = galaxies;
    }
}
