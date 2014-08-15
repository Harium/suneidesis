package com.medievalperson.memory;

import com.medievalperson.Concept;
import com.medievalperson.beign.Being;
import com.medievalperson.place.Place;

/**
 * 
 * Memory is a model to represent actions from the being perspective
 * 
 * the same fact(action) can be achieve in a different way from observers and/or actors
 *
 */

public class Fact {

	private Being actor;
	
	private Being target;
	
	private Place place;
	
	private Concept action;
	
	private Concept whereInTarget;
	
	private Concept when;

	public Fact() {
		super();
	}

	public Being getActor() {
		return actor;
	}

	public void setActor(Being actor) {
		this.actor = actor;
	}

	public Being getTarget() {
		return target;
	}

	public void setTarget(Being target) {
		this.target = target;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Concept getAction() {
		return action;
	}

	public void setAction(Concept action) {
		this.action = action;
	}

	public Concept getWhereInTarget() {
		return whereInTarget;
	}

	public void setWhereInTarget(Concept whereAction) {
		this.whereInTarget = whereAction;
	}

	public Concept getWhen() {
		return when;
	}

	public void setWhen(Concept when) {
		this.when = when;
	}
		
}
