package com.medievalperson.beign.taxonomy;

import com.medievalperson.Concept;

public class Classification extends Concept {
	
	private Classification superClass;
	
	public Classification(String name) {
		super(name);
	}

	public Classification getSuperClass() {
		return superClass;
	}

	public void setSuperClass(Classification superClass) {
		this.superClass = superClass;
	}
		
}
