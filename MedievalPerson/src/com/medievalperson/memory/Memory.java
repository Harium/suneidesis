package com.medievalperson.memory;

import com.medievalperson.beign.Beign;
import com.medievalperson.place.Place;

/**
 * 
 * Memory is a model to represent actions from the beign perspective
 * 
 * the same fact(action) can be achieve in a different way from observers and/or actors
 *
 */

public class Memory {

	private Beign actor;
	
	private Beign who;
	
	private Place place;
	
	private String action;
	
	private String whereAction;
	
	private String when;

	public Memory() {
		super();
	}

	public Beign getActor() {
		return actor;
	}

	public void setActor(Beign actor) {
		this.actor = actor;
	}

	public Beign getWho() {
		return who;
	}

	public void setWho(Beign who) {
		this.who = who;
	}

	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getWhereAction() {
		return whereAction;
	}

	public void setWhereAction(String whereAction) {
		this.whereAction = whereAction;
	}

	public String getWhen() {
		return when;
	}

	public void setWhen(String when) {
		this.when = when;
	}
		
}
