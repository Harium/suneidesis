package com.harium.suneidesis.knowledge.beign;

import com.harium.suneidesis.knowledge.beign.ancestry.Ancestry;
import com.harium.suneidesis.knowledge.concept.Adjective;
import com.harium.suneidesis.knowledge.memory.Fact;
import com.harium.suneidesis.knowledge.memory.Mind;

import java.util.*;

public class Being extends Creature {

    private Ancestry ancestry = null;

    protected Gender gender = Gender.UNKNOWN;

    protected Status status = new Status();

    private Mind mind = new Mind();

    public static final String ATTR_HEALTH = "health";

    public Being(String name) {
        super(name);
    }

    public Being(String name, Gender gender) {
        this(name);
        this.gender = gender;
        status.add(ATTR_HEALTH, Status.MAX, Status.NEUTRAL);
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

    public void addAdjective(Adjective adjective) {
        status.add(adjective.getName());
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
