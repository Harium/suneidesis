package com.harium.suneidesis.knowledge.material;

import java.util.*;

public class Molecule {
    Map<Atom, Set<Atom>> bonds;

    public Molecule() {
        bonds = new LinkedHashMap<Atom, Set<Atom>>();
    }

    public void add(Atom atom) {
        bonds.put(atom, new HashSet<Atom>());
    }

    public void add(Atom ... atoms) {
        for (Atom atom:atoms) {
            add(atom);
        }
    }

    public void bond(Atom atom, Atom otherAtom) {
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
