package com.harium.suneidesis.knowledge.memory;

import java.util.ArrayList;
import java.util.List;

public class Mind {

	protected List<Fact> memories = new ArrayList<Fact>();
	
	public Mind() {
		super();
	}

	public List<Fact> getMemories() {
		return memories;
	}

	public void setMemories(List<Fact> memories) {
		this.memories = memories;
	}	
	
}
