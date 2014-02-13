package com.medievalperson.action;

import com.medievalperson.beign.Beign;
import com.medievalperson.place.Place;

public class Action {

	private Beign actor;
	
	private Beign who;
	
	private Place place;
	
	private String action;
	
	private String whereAction;
	
	private String when;

	public Action() {
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
