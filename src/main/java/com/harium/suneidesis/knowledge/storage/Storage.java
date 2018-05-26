package com.harium.suneidesis.knowledge.storage;

import java.util.ArrayList;
import java.util.List;

public class Storage {

	protected List<Fact> facts = new ArrayList<Fact>();
	
	public Storage() {
		super();
	}

	public List<Fact> getFacts() {
		return facts;
	}

	public void setFacts(List<Fact> facts) {
		this.facts = facts;
	}	
	
}
