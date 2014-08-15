package com.medievalperson.memory;

import java.util.List;

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

	protected Being actor;
	
	protected Being who;
	
	protected Place place;
	
	protected String action;
	
	protected String whereAction;
	
	protected String when;
	
	//Sintetize fact/improve explanation
	protected List<Fact> conclusions;

	public Fact() {
		super();
	}

	public Being getActor() {
		return actor;
	}

	public void setActor(Being actor) {
		this.actor = actor;
	}

	public Being getWho() {
		return who;
	}

	public void setWho(Being who) {
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

	public List<Fact> getConclusions() {
		return conclusions;
	}

	public void setConclusions(List<Fact> conclusions) {
		this.conclusions = conclusions;
	}
	
	public void copy(Fact fact) {
		
		this.actor = fact.actor;
		this.who = fact.who;
		this.place = fact.place;
		this.action = fact.action;
		this.whereAction = fact.whereAction;
		this.when = fact.when;
		this.conclusions = fact.conclusions;
	}
		
}
