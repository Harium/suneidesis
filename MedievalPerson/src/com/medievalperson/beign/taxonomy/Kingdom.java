package com.medievalperson.beign.taxonomy;

import com.medievalperson.Concept;

public class Kingdom extends Concept {

	private Kingdom domain;
	
	public Kingdom(String name) {
		super(name);
	}

	public Kingdom getDomain() {
		return domain;
	}

	public void setDomain(Kingdom domain) {
		this.domain = domain;
	}
	
}
