package com.harium.suneidesis.knowledge.beign;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.harium.suneidesis.knowledge.concept.Adjective;
import com.harium.suneidesis.knowledge.memory.Fact;
import com.harium.suneidesis.knowledge.memory.Mind;

public class Being extends Creature {
	
	private Being biologicalAncestor = null;
	private Being biologicalMother = null;
		
	protected Gender gender = Gender.UNKNOWN;

	protected HealthStatus healthStatus = new HealthStatus();
	
	private Mind mind = new Mind();
	
	protected Set<Adjective> adjectives;
	
	public Being(String name) {
		super(name);
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

	public Being getBiologicalAncestor() {
		return biologicalAncestor;
	}

	public void setBiologicalAncestor(Being biologicalAncestor) {
		
		if(biologicalAncestor.gender == Gender.MALE) {
			this.biologicalAncestor = biologicalAncestor;
		}
		
	}

	public Being getBiologicalMother() {
		return biologicalMother;
	}

	public void setBiologicalMother(Being biologicalMother) {
		
		if(biologicalAncestor.gender == Gender.FEMALE) {
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
