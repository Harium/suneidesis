package com.harium.suneidesis.concept;

import com.harium.suneidesis.knowledge.space.CelestialBody;
import com.harium.suneidesis.knowledge.space.SpaceConcept;

public class Place extends Concept {

	private static final String ATTRIBUTE_GALAXY = "place_galaxy";
	private static final String ATTRIBUTE_PLANET = "place_planet";
	private static final String ATTRIBUTE_LATITUDE = "place_latitude";
	private static final String ATTRIBUTE_LONGITUDE = "place_longitude";

	// Where in the Universe and what Universe (usually Earth)
	private SpaceConcept space;

	// Place is recursive to represent place inside a place
	private Place place = null;

	CelestialBody celestialBody;

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
