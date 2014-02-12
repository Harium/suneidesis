package com.medievalperson.beign.taxonomy;

import com.medievalperson.Thing;

public class Kingdom extends Thing {

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
