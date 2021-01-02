package com.harium.suneidesis.behavior;

import com.harium.suneidesis.concept.Being;

public class BaseBehavior implements Behavior {

    protected Being being = null;

    public BaseBehavior() {
        super();
    }

    public BaseBehavior(Being being) {
        super();
        setBeing(being);
    }

    @Override
    public void behave() {

    }

    @Override
    public void setBeing(Being being) {
        this.being = being;
    }
}
