package com.harium.suneidesis.knowledge.fact.frame;

import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.concept.Place;
import com.harium.suneidesis.knowledge.fact.Fact;
import com.harium.suneidesis.knowledge.fact.FactSource;
import com.harium.suneidesis.knowledge.time.TemporalConcept;
import com.harium.suneidesis.knowledge.weather.Weather;

import java.util.List;

public class FullFrame extends Fact {

    private Concept actor;
    private Concept target;

    private Place place;

    private Concept action;
    private Concept whereInTarget;

    private TemporalConcept when;

    protected List<Fact> conclusions;

    private FactSource source;
    private Weather weather;

    public FullFrame() {
        super("");
        frameType = FrameType.FULL_FRAME;
    }

    public FullFrame(String name) {
        super(name);
        frameType = FrameType.FULL_FRAME;
    }

    public Concept getActor() {
        return actor;
    }

    public void setActor(Concept actor) {
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

    public void copy(FullFrame fact) {
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
