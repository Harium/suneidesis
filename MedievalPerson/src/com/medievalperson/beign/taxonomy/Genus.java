package com.medievalperson.beign.taxonomy;

import com.medievalperson.Thing;

public class Genus extends Thing {

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
