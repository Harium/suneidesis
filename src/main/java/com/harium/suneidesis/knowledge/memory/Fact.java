package com.harium.suneidesis.knowledge.memory;

import com.harium.suneidesis.beign.Being;
import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.concept.ConceptType;
import com.harium.suneidesis.knowledge.concept.Place;
import com.harium.suneidesis.knowledge.time.TemporalConcept;
import com.harium.suneidesis.knowledge.weather.Weather;

import java.util.List;

/**
 * Fact is a model to represent actions from being's perspective
 * The same fact(action) can be perceived differently by observers and/or actors
 */

public class Fact extends Concept {

    private Being actor;
    private Concept target;

    private Place place;

    private Concept action;
    private Concept whereInTarget;

    private TemporalConcept when;

    protected List<Fact> conclusions;

    private FactSource source;
    private Weather weather;

    public Fact(String name) {
        super(name, ConceptType.THEORY);
    }

    public Fact() {
        super("", ConceptType.THEORY);
    }

    public Being getActor() {
        return actor;
    }

    public void setActor(Being actor) {
        this.actor = actor;
    }

    public Concept getTarget() {
        return target;
    }

    public void setTarget(Concept target) {
        this.target = target;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Concept getAction() {
        return action;
    }

    public void setAction(Concept action) {
        this.action = action;
    }

    public Concept getWhereInTarget() {
        return whereInTarget;
    }

    public void setWhereInTarget(Concept whereAction) {
        this.whereInTarget = whereAction;
    }

    public TemporalConcept getWhen() {
        return when;
    }

    public void setWhen(TemporalConcept when) {
        this.when = when;
    }

    public List<Fact> getConclusions() {
        return conclusions;
    }

    public void setConclusions(List<Fact> conclusions) {
        this.conclusions = conclusions;
    }

    public FactSource getSource() {
        return source;
    }

    public void setSource(FactSource source) {
        this.source = source;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public void copy(Fact fact) {
        this.actor = fact.actor;
        this.target = fact.target;
        this.place = fact.place;
        this.action = fact.action;
        this.whereInTarget = fact.whereInTarget;
        this.when = fact.when;
        this.conclusions = fact.conclusions;
        this.source = fact.source;
        this.weather = fact.weather;
    }
}
