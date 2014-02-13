package com.medievalperson.beign;

import java.util.List;

import com.medievalperson.Thing;
import com.medievalperson.action.Action;

public class Beign extends Thing {
	
	private List<Action> actions;

	private Beign biologicalFather = null;
	
	private Beign biologicalMother = null;
		
	protected Feeling feeling = new Feeling();
	
	protected Gender gender = Gender.UNKNOWN;
		
	public Beign(String name) {
		super(name);
	}
	
	public Beign(String name, Gender gender) {
		this(name);
		
		this.gender = gender;
	}
	
	public Feeling getFeeling() {
		return feeling;
	}

	public Gender getGender() {
		return gender;
	}

	public Beign getBiologicalFather() {
		return biologicalFather;
	}

	public void setBiologicalFather(Beign biologicalFather) {
		
		if(biologicalFather.gender==Gender.MALE){		
			this.biologicalFather = biologicalFather;
		}
		
	}

	public Beign getBiologicalMother() {
		return biologicalMother;
	}

	public void setBiologicalMother(Beign biologicalMother) {
		
		if(biologicalFather.gender==Gender.FEMALE){
			this.biologicalMother = biologicalMother;
		}
		
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}
	
}
