package com.harium.suneidesis.knowledge.beign;

import com.harium.suneidesis.knowledge.beign.ancestry.Ancestry;
import com.harium.suneidesis.knowledge.concept.Adjective;
import com.harium.suneidesis.knowledge.memory.Fact;
import com.harium.suneidesis.knowledge.memory.Mind;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Being extends Creature {

    private Ancestry ancestry = null;

    protected Gender gender = Gender.UNKNOWN;

    protected Status status = new Status();

    private Mind mind = new Mind();

    protected Set<Adjective> adjectives;

    private static final String ATTR_HEALTH = "health";

    public Being(String name) {
        super(name);
    }

    public Being(String name, Gender gender) {
        this(name);
        this.gender = gender;
        status.add(ATTR_HEALTH, Status.MAX);
    }

    public Status getStatus() {
        return status;
    }

    public Gender getGender() {
        return gender;
    }

    public Ancestry getAncestry() {
        return ancestry;
    }

    public void setAncestry(Ancestry ancestry) {
        this.ancestry = ancestry;
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
        if (adjectives == null) {
            adjectives = new HashSet<Adjective>();
        }

        adjectives.add(adjective);
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
