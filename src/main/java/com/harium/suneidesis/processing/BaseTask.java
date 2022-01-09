package com.harium.suneidesis.processing;

import com.harium.suneidesis.concept.Concept;

public abstract class BaseTask extends Concept implements Task {

    protected boolean done = false;

    protected boolean inProgress = false;

    public BaseTask(String name) {
        super(name);
    }

    @Override
    public boolean canStart() {
        return true;
    }

    @Override
    public boolean isInProgress() {
        return inProgress;
    }

    @Override
    public boolean isDone() {
        return done;
    }

}
