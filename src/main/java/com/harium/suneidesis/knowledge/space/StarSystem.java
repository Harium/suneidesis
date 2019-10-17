package com.harium.suneidesis.knowledge.space;

import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.storage.Storage;

import java.util.List;
import java.util.stream.Collectors;

public class StarSystem extends Concept {

    private Galaxy galaxy;

    private Storage<CelestialBody> bodies;

    public Galaxy getGalaxy() {
        return galaxy;
    }

    public void setGalaxy(Galaxy galaxy) {
        this.galaxy = galaxy;
    }

    public List<CelestialBody> getPlanets() {
        return getByType(CelestialBodyType.PLANET);
    }

    public List<CelestialBody> getStars() {
        return getByType(CelestialBodyType.STAR);
    }

    public List<CelestialBody> getByType(CelestialBodyType type) {
        return bodies.getAll().stream()
                .filter(p -> type.equals(p.getCelestialBodyType())).collect(Collectors.toList());
    }

    public Storage<CelestialBody> getBodies() {
        return bodies;
    }

    public void setBodies(Storage<CelestialBody> bodies) {
        this.bodies = bodies;
    }
}
