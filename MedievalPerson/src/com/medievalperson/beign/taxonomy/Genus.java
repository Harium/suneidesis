package com.medievalperson.beign.taxonomy;

import com.medievalperson.Concept;

public class Genus extends Concept {

	private Family family;

	private Genus superGenus;
	
	public Genus(String name) {
		super(name);
	}

	public Family getFamily() {
		return family;
	}

	public void setFamily(Family family) {
		this.family = family;
	}

	public Genus getSuperGenus() {
		return superGenus;
	}

	public void setSuperGenus(Genus superGenus) {
		this.superGenus = superGenus;
	}

}
