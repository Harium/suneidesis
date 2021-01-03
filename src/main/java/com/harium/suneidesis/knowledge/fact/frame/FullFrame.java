package com.harium.suneidesis.knowledge.fact.frame;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Place;
import com.harium.suneidesis.knowledge.fact.Fact;
import com.harium.suneidesis.knowledge.fact.FactSource;
import com.harium.suneidesis.knowledge.time.TemporalConcept;
import com.harium.suneidesis.knowledge.weather.Weather;

import java.util.List;

public class FullFrame extends Fact {

    private Concept subject;
    private Concept predicate;
    private Concept object;
    private Concept whereInObject;

    // Instance attributes
    private Place place;
    private TemporalConcept when;
    private Weather weather;

    protected List<Fact> conclusions;

    public FullFrame() {
        super("");
        frameType = FrameType.FULL_FRAME;
    }

    public FullFrame(String name) {
        super(name);
        frameType = FrameType.FULL_FRAME;
    }

    public Concept getSubject() {
        return subject;
    }

    public void setSubject(Concept subject) {
        this.subject = subject;
    }

    public Concept getObject() {
        return object;
    }

    public void setObject(Concept object) {
        this.object = object;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Concept getPredicate() {
        return predicate;
    }

    public void setPredicate(Concept predicate) {
        this.predicate = predicate;
    }

    public Concept getWhereInObject() {
        return whereInObject;
    }

    public void setWhereInObject(Concept whereAction) {
        this.whereInObject = whereAction;
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
        this.subject = fact.subject;
        this.object = fact.object;
        this.place = fact.place;
        this.predicate = fact.predicate;
        this.whereInObject = fact.whereInObject;
        this.when = fact.when;
        this.conclusions = fact.conclusions;
        this.source = fact.source;
        this.weather = fact.weather;
    }

}
