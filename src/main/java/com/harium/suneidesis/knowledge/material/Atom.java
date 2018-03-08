package com.harium.suneidesis.knowledge.material;

import com.harium.suneidesis.knowledge.concept.Concept;

public class Atom extends Concept {

	private int atomicNumber;

	private double massNumber;
	
	public Atom(String name){
		super(name);
	}

	public int getAtomicNumber() {
		return atomicNumber;
	}

	public void setAtomicNumber(int atomicNumber) {
		this.atomicNumber = atomicNumber;
	}

	public double getMassNumber() {
		return massNumber;
	}

	public void setMassNumber(double massNumber) {
		this.massNumber = massNumber;
	}
	
}
