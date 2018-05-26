package com.harium.suneidesis.beign;

import com.harium.suneidesis.behavior.BaseBehavior;
import com.harium.suneidesis.behavior.Behavior;
import com.harium.suneidesis.beign.ancestry.Ancestry;
import com.harium.suneidesis.knowledge.concept.Adjective;
import com.harium.suneidesis.knowledge.storage.Fact;
import com.harium.suneidesis.knowledge.storage.Storage;

import java.util.*;

public class Being extends Creature {

    public static final String ATTR_HEALTH = "health";

    private Ancestry ancestry = null;

    protected Gender gender = Gender.UNKNOWN;

    protected Status status = new Status();

    private Storage storage = new Storage();

    private Behavior behavior = new BaseBehavior();

    public Being(String name) {
        super(name);
    }

    public Being(String name, Gender gender) {
        this(name);
        this.gender = gender;
        status.add(ATTR_HEALTH, Status.MAX, Status.NEUTRAL);
    }

    public void behave() {
        behavior.behave();
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
        return storage.getFacts();
    }

    public void setMemories(List<Fact> memories) {
        this.storage.setFacts(memories);
    }

    public void addStatus(String attribute, float threshold) {
        status.addThreshold(attribute, threshold);
    }

    public void addStatus(String attribute, float value, float threshold) {
        status.add(attribute, value, threshold);
    }

    public void addAdjective(Adjective adjective) {
        status.add(adjective.getName());
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Behavior getBehavior() {
        return behavior;
    }

    public void setBehavior(Behavior behavior) {
        this.behavior = behavior;
        behavior.setBeing(this);
    }
}
