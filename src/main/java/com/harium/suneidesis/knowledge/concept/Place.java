package com.harium.suneidesis.knowledge.concept;

import com.harium.suneidesis.knowledge.space.SpaceConcept;

public class Place extends Concept {

	// Where in the Universe and what Universe (usually Earth)
	private SpaceConcept space;

	// Place is recursive to represent place inside a place
	private Place place = null;

	public Place(String name) {
		super(name, ConceptType.PLACE);
	}
	
	public Place at(Place place) {
		this.place = place;
		
		return this;
	}
	
	public void setPlace(Place place) {
		this.place = place;
	}
	
	public Place getPlace() {
		return place;
	}
	
}
