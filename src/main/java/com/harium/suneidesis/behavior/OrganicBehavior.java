package com.harium.suneidesis.behavior;

import com.harium.suneidesis.beign.Being;
import com.harium.suneidesis.beign.Status;

public class OrganicBehavior extends BaseBehavior {

    public static final String ATTR_THIRSTY = "thirstiness";
    public static final String ATTR_HUNGRY = "hungriness";

    private static final float FACTOR_THIRSTY = 0.001f;
    private static final float FACTOR_HUNGRY = 0.001f;

    private static final float METABOLISM = 1.0f;

    public OrganicBehavior() {
        super();
    }

    public OrganicBehavior(Being being) {
        super(being);
    }

    @Override
    public void behave() {
        being.getStatus().increment(ATTR_THIRSTY, -FACTOR_THIRSTY * METABOLISM);
        being.getStatus().increment(ATTR_HUNGRY, -FACTOR_HUNGRY * METABOLISM);
    }

    @Override
    public void setBeing(Being being) {
        this.being = being;
        this.being.addStatus(ATTR_THIRSTY, Status.NEUTRAL, Status.NEUTRAL);
        this.being.addStatus(ATTR_HUNGRY, Status.NEUTRAL, Status.NEUTRAL);
    }

    public float getHungriness() {
        return being.getStatus().get(OrganicBehavior.ATTR_HUNGRY);
    }

    public float getThirstiness() {
        return being.getStatus().get(OrganicBehavior.ATTR_THIRSTY);
    }
}
