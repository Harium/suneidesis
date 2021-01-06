package com.harium.suneidesis.knowledge.space;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Place;

public class CelestialBody extends Place {

    private static final String ATTRIBUTE_TYPE = "celestial_body_type";

    public CelestialBody(String name) {
        super(name);
    }

    public CelestialBody setCelestialBodyType(Concept type) {
        set(ATTRIBUTE_TYPE, type);
        return this;
    }

    public Concept getCelestialBodyType() {
        return get(ATTRIBUTE_TYPE);
    }

}
