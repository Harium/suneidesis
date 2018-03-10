package com.harium.suneidesis.knowledge.taxonomy;

import com.harium.suneidesis.knowledge.concept.Concept;

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
