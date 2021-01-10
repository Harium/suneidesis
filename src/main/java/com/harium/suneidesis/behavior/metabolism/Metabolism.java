package com.harium.suneidesis.behavior.metabolism;

import com.harium.suneidesis.behavior.Biome;
import com.harium.suneidesis.concept.substance.Molecule;

import java.util.ArrayList;
import java.util.List;

public class Metabolism extends Biome {

    float energy;
    float rate;
    List<Need> needs = new ArrayList<Need>();
    List<MetabolicProcess> processes = new ArrayList<MetabolicProcess>();

    public void tick() {
        for (MetabolicProcess process : processes) {
            process.process();
        }

        // Energy and quantity are based on rate
        for (Need need : needs) {
            energy -= need.energy;

            Molecule nutrient = need.nutrient;
            float quantity = resources.get(nutrient);
            quantity -= need.quantity;

            resources.put(nutrient, quantity);
        }
    }

    public void addNeed(String name, float quantity, float energy) {
        Molecule nutrient = new Molecule(name);
        Need need = new Need(nutrient);
        need.quantity = quantity;
        need.energy = energy;

        needs.add(need);
        resources.put(nutrient, 0f);
    }

    public void addProcess(MetabolicProcess process) {
        processes.add(process);
    }

    public void recover(float quantity) {
        energy += quantity;
    }

    public float getEnergy() {
        return energy;
    }

    public void setEnergy(float energy) {
        this.energy = energy;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
