package com.harium.suneidesis.knowledge.linguistic.core.frame;

public class BaseFrame {

    NounFrame noun;
    ActionFrame action;

    public NounFrame getNoun() {
        return noun;
    }

    public void setNoun(NounFrame noun) {
        this.noun = noun;
    }

    public ActionFrame getAction() {
        return action;
    }

    public void setAction(ActionFrame action) {
        this.action = action;
    }

}
