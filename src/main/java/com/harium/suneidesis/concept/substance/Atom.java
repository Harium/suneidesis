package com.harium.suneidesis.concept.substance;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.measurement.Measurement;

public class Atom extends Substance {

    // Also called Z
    private static final String ATTRIBUTE_ATOMIC_NUMBER = "atomic number";
    // Total of Protons + Neutrons
    private static final String ATTRIBUTE_MASS_NUMBER = "mass number";

    public Atom(String name) {
        super(name);
    }

    public Atom(String name, int atomicNumber, int massNumber) {
        super(name);
        setAtomicNumber(atomicNumber);
        setMassNumber(massNumber);
    }

    public Atom(String name, String formula) {
        super(name);
        setFormula(formula);
    }

    public Concept getAtomicNumber() {
        return getAttributes().get(ATTRIBUTE_ATOMIC_NUMBER);
    }

    public String getAtomicNumberValue() {
        return getAttributes().get(ATTRIBUTE_ATOMIC_NUMBER).getName();
    }

    public void setAtomicNumber(int atomicNumber) {
        String text = Integer.toString(atomicNumber);
        this.getAttributes().save(ATTRIBUTE_ATOMIC_NUMBER, new Measurement().value(text));
    }

    public Concept getMassNumber() {
        return getAttributes().get(ATTRIBUTE_MASS_NUMBER);
    }

    public String getMassNumberValue() {
        return getAttributes().get(ATTRIBUTE_MASS_NUMBER).getName();
    }

    public void setMassNumber(int massNumber) {
        String text = Integer.toString(massNumber);
        this.has(ATTRIBUTE_ATOMIC_NUMBER, new Measurement().value(text));
    }

}