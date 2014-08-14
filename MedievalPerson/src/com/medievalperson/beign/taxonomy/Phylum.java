package com.medievalperson.beign.taxonomy;

import com.medievalperson.Concept;

public class Phylum extends Concept{

	private Kingdom kingdom;
	
	private Phylum superPhylum;

	public Phylum(String name) {
		super(name);	
	}

	public Kingdom getKingdom() {
		return kingdom;
	}

	public void setKingdom(Kingdom kingdom) {
		this.kingdom = kingdom;
	}

	public Phylum getSuperPhylum() {
		return superPhylum;
	}

	public void setSuperPhylum(Phylum superPhylum) {
		this.superPhylum = superPhylum;
	}
			
}
