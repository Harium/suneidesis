package com.harium.suneidesis.planning;

import com.harium.suneidesis.behavior.Environment;
import com.harium.suneidesis.concept.Concept;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent high level instructions
 */
public class BaseTask extends Concept {

    private List<BaseTask> subTasks = new ArrayList<>();

    public boolean execute(Concept subject, Environment environment) {
        boolean success = true;
        for (BaseTask task : subTasks) {
            success &= task.execute(subject, environment);
        }
        return success;
    }

    public void addTask(BaseTask task) {
        subTasks.add(task);
    }

}
