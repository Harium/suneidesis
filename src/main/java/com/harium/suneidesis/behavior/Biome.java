package com.harium.suneidesis.behavior;

import com.harium.suneidesis.concept.substance.Molecule;

import java.util.HashMap;
import java.util.Map;

public class Biome {

    protected Map<Molecule, Float> resources = new HashMap<Molecule, Float>();

    public float quantity(Molecule nutrient) {
        if (!resources.containsKey(nutrient)) {
            return 0;
        } else {
            return resources.get(nutrient);
        }
    }

    public void sum(Molecule nutrient, float quantity) {
        if (!resources.containsKey(nutrient)) {
            resources.put(nutrient, quantity);
        } else {
            float q = resources.get(nutrient);
            q += quantity;
            resources.put(nutrient, q);
        }
    }

    public Map<Molecule, Float> getResources() {
        return resources;
    }
}
