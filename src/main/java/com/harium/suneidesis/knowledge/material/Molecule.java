package com.harium.suneidesis.knowledge.material;

import com.harium.suneidesis.concept.Concept;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Molecule extends Concept {
    protected Map<Atom, Set<Atom>> bonds;

    public Molecule() {
    }

    public Molecule(String name) {
        super(name);
    }

    public void add(Atom atom) {
        init();
        bonds.put(atom, new HashSet<Atom>());
    }

    private void init() {
        if (bonds == null) {
            bonds = new LinkedHashMap<>();
        }
    }

    public void add(Atom... atoms) {
        for (Atom atom : atoms) {
            add(atom);
        }
    }

    public void bond(Atom atom, Atom otherAtom) {
        init();
        if (!this.bonds.containsKey(atom)) {
            throw new RuntimeException("Atom is Missing: " + atom);
        } else if (!this.bonds.containsKey(otherAtom)) {
            throw new RuntimeException("Atom is Missing: " + otherAtom);
        }

        Set<Atom> originBonds = this.bonds(atom);
        originBonds.add(otherAtom);

        Set<Atom> destinationBonds = this.bonds(otherAtom);
        destinationBonds.add(atom);
    }

    public int size() {
        return bonds.size();
    }

    public Set<Atom> bonds(Atom atom) {
        return this.bonds.get(atom);
    }
}
