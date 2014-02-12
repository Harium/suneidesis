package com.medievalperson.material;

import com.medievalperson.Thing;

public class Atom extends Thing {

	private int atomicNumber;
	
	private double atomicMass;
	
	public Atom(String name){
		super(name);
	}

	public int getAtomicNumber() {
		return atomicNumber;
	}

	public void setAtomicNumber(int atomicNumber) {
		this.atomicNumber = atomicNumber;
	}

	public double getAtomicMass() {
		return atomicMass;
	}

	public void setAtomicMass(double atomicMass) {
		this.atomicMass = atomicMass;
	}
	
}
