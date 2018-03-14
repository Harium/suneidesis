package com.harium.suneidesis.knowledge.material;

import com.harium.suneidesis.knowledge.concept.Concept;

public class Atom extends Concept {

	/**
	 * Also called Z
	 */
	private int atomicNumber;

	/**
	 * Total of Protons + Neutrons
	 */
	private int massNumber;
	
	public Atom(String name){
		super(name);
	}

	public Atom(int atomicNumber, int massNumber) {
		super();
		this.atomicNumber = atomicNumber;
		this.massNumber = massNumber;
	}

	public Atom(String name, int atomicNumber, int massNumber) {

	}

	public int getAtomicNumber() {
		return atomicNumber;
	}

	public void setAtomicNumber(int atomicNumber) {
		this.atomicNumber = atomicNumber;
	}

	public int getMassNumber() {
		return massNumber;
	}

	public void setMassNumber(int massNumber) {
		this.massNumber = massNumber;
	}
	
}
