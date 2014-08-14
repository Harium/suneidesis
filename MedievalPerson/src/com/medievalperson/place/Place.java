package com.medievalperson.place;

import com.medievalperson.Concept;
import com.medievalperson.concept.ConceptType;

public class Place extends Concept {

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
