package com.harium.suneidesis.concept;

public class Place extends Concept {

	private static final String ATTRIBUTE_AT = "place_at";
	private static final String ATTRIBUTE_UNIVERSE = "place_universe";
	private static final String ATTRIBUTE_GALAXY = "place_galaxy";
	private static final String ATTRIBUTE_STAR_SYSTEM = "place_start_system";
	private static final String ATTRIBUTE_PLANET = "place_planet";

	private static final String ATTRIBUTE_LATITUDE = "place_latitude";
	private static final String ATTRIBUTE_LONGITUDE = "place_longitude";

	public Place(String name) {
		super(name, ConceptType.PLACE);
	}
	
	public Place at(Place place) {
		has(ATTRIBUTE_AT, place);
		return this;
	}

	public Place getPlace() {
		return (Place) get(ATTRIBUTE_AT);
	}
	
}
