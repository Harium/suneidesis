package com.medievalperson.beign.taxonomy;

import com.medievalperson.Thing;

public class Specie extends Thing{

	private Genus genus;
	
	private Specie superSpecie;
	
	public Specie(String name) {
		super(name);
	}

	public Genus getGenus() {
		return genus;
	}

	public void setGenus(Genus genus) {
		this.genus = genus;
	}

	public Specie getSuperSpecie() {
		return superSpecie;
	}

	public void setSuperSpecie(Specie superSpecie) {
		this.superSpecie = superSpecie;
	}
			
}
