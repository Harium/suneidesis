package com.harium.suneidesis.knowledge.space;

import com.harium.suneidesis.concept.Concept;

public class CelestialBody extends Concept {

    CelestialBodyType celestialBodyType = CelestialBodyType.UNKNOWN;
    StarSystem starSystem;

    public CelestialBodyType getCelestialBodyType() {
        return celestialBodyType;
    }

    public void setCelestialBodyType(CelestialBodyType celestialBodyType) {
        this.celestialBodyType = celestialBodyType;
    }

    public StarSystem getStarSystem() {
        return starSystem;
    }

    public void setStarSystem(StarSystem starSystem) {
        this.starSystem = starSystem;
    }
}
