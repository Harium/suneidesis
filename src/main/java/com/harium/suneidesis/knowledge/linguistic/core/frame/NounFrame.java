package com.harium.suneidesis.knowledge.linguistic.core.frame;

import com.harium.suneidesis.concept.Concept;

import java.util.ArrayList;
import java.util.List;

public class NounFrame {

    Concept noun;
    Concept determiner;
    List<AdjectiveFrame> adjectives;

    public NounFrame(Concept noun) {
        this.noun = noun;
    }

    public NounFrame(String noun) {
        this.noun = new Concept(noun);
    }

    public NounFrame(Concept noun, AdjectiveFrame adjectives) {
        this.noun = noun;
        this.adjectives = new ArrayList<>();
        this.adjectives.add(adjectives);
    }

    public Concept getDeterminer() {
        return determiner;
    }

    public void setDeterminer(Concept determiner) {
        this.determiner = determiner;
    }

    public void setArticle(String article) {
        this.determiner = new Concept(article);
    }

    public void addAdjective(AdjectiveFrame adjective) {
        if (this.adjectives == null) {
            this.adjectives = new ArrayList<>();
        }
        this.adjectives.add(adjective);
    }

    public Concept getNoun() {
        return noun;
    }

    public void setNoun(Concept noun) {
        this.noun = noun;
    }

    public List<AdjectiveFrame> getAdjectives() {
        return adjectives;
    }

    public void setAdjectives(List<AdjectiveFrame> adjectives) {
        this.adjectives = adjectives;
    }

    public void setDeterminer(String determiner) {
        this.determiner = new Concept(determiner);
    }
}
