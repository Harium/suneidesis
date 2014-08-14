package com.medievalperson.beign;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.medievalperson.Concept;
import com.medievalperson.adjectives.Adjective;
import com.medievalperson.concept.ConceptType;
import com.medievalperson.memory.Fact;
import com.medievalperson.memory.Mind;

public class Being extends Concept {
	
	private Being biologicalFather = null;
	
	private Being biologicalMother = null;
		
	protected Gender gender = Gender.UNKNOWN;
		
	protected HealthStatus healthStatus = new HealthStatus();
	
	private Mind mind = new Mind();
	
	protected Set<Adjective> adjectives;
	
	public Being(String name) {
		super(name, ConceptType.CREATURE);
	}
	
	public Being(String name, Gender gender) {
		this(name);
		
		this.gender = gender;
	}
	
	public HealthStatus getHealthStatus() {
		return healthStatus;
	}

	public Gender getGender() {
		return gender;
	}

	public Being getBiologicalFather() {
		return biologicalFather;
	}

	public void setBiologicalFather(Being biologicalFather) {
		
		if(biologicalFather.gender == Gender.MALE) {
			this.biologicalFather = biologicalFather;
		}
		
	}

	public Being getBiologicalMother() {
		return biologicalMother;
	}

	public void setBiologicalMother(Being biologicalMother) {
		
		if(biologicalFather.gender == Gender.FEMALE) {
			this.biologicalMother = biologicalMother;
		}
		
	}

	public List<Fact> getMemories() {
		return mind.getMemories();
	}

	public void setMemories(List<Fact> memories) {
		this.mind.setMemories(memories);
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
