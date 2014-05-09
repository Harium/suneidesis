package com.medievalperson.beign;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.medievalperson.Thing;
import com.medievalperson.adjectives.Adjective;
import com.medievalperson.memory.Memory;

public class Beign extends Thing {
	
	private List<Memory> memories;

	private Beign biologicalFather = null;
	
	private Beign biologicalMother = null;
		
	protected Feeling feeling = new Feeling();
	
	protected Gender gender = Gender.UNKNOWN;
		
	protected Set<Adjective> adjectives;
	
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

	public List<Memory> getMemories() {
		return memories;
	}

	public void setMemories(List<Memory> memories) {
		this.memories = memories;
	}
	
	public Set<Adjective> getAdjectives() {
		return adjectives;
	}
	
	public void addAdjective(Adjective adjective) {
		
		if(adjectives == null) {
			
			adjectives = new HashSet<Adjective>();
			
		}
		
		adjectives.add(adjective);
	}
	
}
