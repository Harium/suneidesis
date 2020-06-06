package com.harium.suneidesis.planning;

import com.harium.suneidesis.behavior.Environment;
import com.harium.suneidesis.consciousness.Consciousness;
import com.harium.suneidesis.knowledge.concept.Concept;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent high level instructions
 */
public class Task extends Concept {

    private List<Task> subTasks = new ArrayList<>();

    public boolean execute(Consciousness subject, Environment environment) {
        boolean success = true;
        for (Task task : subTasks) {
            success &= task.execute(subject, environment);
        }
        return success;
    }

    public void addTask(Task task) {
        subTasks.add(task);
    }
}
