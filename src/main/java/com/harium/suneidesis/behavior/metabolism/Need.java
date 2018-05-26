package com.harium.suneidesis.behavior.metabolism;

import com.harium.suneidesis.knowledge.material.Molecule;

public class Need {
    float energy = 0;
    float quantity = 0;
    Molecule nutrient;

    public Need(Molecule nutrient) {
        this.nutrient = nutrient;
    }

    public Need(float energy, float quantity, Molecule nutrient) {
        this.energy = energy;
        this.quantity = quantity;
        this.nutrient = nutrient;
    }

    public float getEnergy() {
        return energy;
    }

    public void setEnergy(float energy) {
        this.energy = energy;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Molecule getNutrient() {
        return nutrient;
    }

    public void setNutrient(Molecule nutrient) {
        this.nutrient = nutrient;
    }
}
