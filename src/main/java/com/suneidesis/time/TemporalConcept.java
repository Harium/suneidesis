package com.suneidesis.time;

import com.suneidesis.concept.Concept;
import com.suneidesis.concept.ConceptType;

public class TemporalConcept extends Concept {

	private Time when;
	
	public TemporalConcept(String name, Time when) {
		super(name, ConceptType.TIME_UNIT);
		this.when = when;
	}

	public Time getWhen() {
		return when;
	}

	public void setWhen(Time when) {
		this.when = when;
	}
}
