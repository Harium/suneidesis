package com.harium.suneidesis.knowledge.space;

import com.harium.suneidesis.concept.Concept;

public class CelestialBodyType {

    public static final CelestialBody ASTEROID = celestialBody("asteroid");
    public static final CelestialBody ASTEROID_BELT = celestialBody("asteroid belt");
    public static final CelestialBody MOON = celestialBody("moon");
    public static final CelestialBody SATELLITE = celestialBody("satellite");
    public static final CelestialBody STAR = celestialBody("star");
    public static final CelestialBody PLANET = celestialBody("planet");

    private static CelestialBody celestialBody(String name) {
        CelestialBody body = new CelestialBody(name);
        body.setCelestialBodyType(new Concept(name));
        return body;
    }
}
