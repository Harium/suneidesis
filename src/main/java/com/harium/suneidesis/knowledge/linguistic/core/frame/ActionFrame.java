package com.harium.suneidesis.knowledge.linguistic.core.frame;

import com.harium.suneidesis.knowledge.concept.Concept;

public class ActionFrame {

    Concept action;
    Concept preposition;
    NounFrame target;

    public ActionFrame(String action) {
        this.action = new Concept(action);
    }

    public ActionFrame(String action, NounFrame target) {
        this.action = new Concept(action);
        this.target = target;
    }

    public Concept getAction() {
        return action;
    }

    public void setAction(Concept action) {
        this.action = action;
    }

    public Concept getPreposition() {
        return preposition;
    }

    public void setPreposition(Concept preposition) {
        this.preposition = preposition;
    }

    public NounFrame getTarget() {
        return target;
    }

    public void setTarget(NounFrame target) {
        this.target = target;
    }
}
