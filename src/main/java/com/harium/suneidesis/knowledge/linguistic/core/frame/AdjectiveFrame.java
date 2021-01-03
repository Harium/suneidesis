package com.harium.suneidesis.knowledge.linguistic.core.frame;

import com.harium.suneidesis.concept.Concept;

public class AdjectiveFrame {

    Concept adjective;
    Concept adverb;

    public AdjectiveFrame(String adjective) {
        this.adjective = new Concept(adjective);
    }

    public AdjectiveFrame(String adverb, String adjective) {
        this.adjective = new Concept(adjective);
        this.adverb = new Concept(adverb);
    }

    public Concept getAdjective() {
        return adjective;
    }

    public void setAdjective(Concept adjective) {
        this.adjective = adjective;
    }

    public Concept getAdverb() {
        return adverb;
    }

    public void setAdverb(Concept adverb) {
        this.adverb = adverb;
    }
}
