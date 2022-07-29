package com.harium.suneidesis.task;

import java.util.ArrayList;
import java.util.List;

/**
 * Agent that performs a list of tasks
 * If we need to perform tasks in parallel we need a task that handles multiples subtasks
 */
public class Agent {

    protected int index = 0;
    protected Task currentTask = null;
    private final List<Task> tasks = new ArrayList<>();

    public boolean update() {
        // If there is no task, we ignore it
        if (tasks.isEmpty()) {
            return true;
        }

        // If there is no current task, we assign the first one
        if (currentTask == null) {
            nextTask();
        }

        // If the current task is done, we move to the next one
        if (currentTask.isDone()) {
            // Move to the next task
            index++;
            nextTask();
            return true;
        } else {
            return false;
        }
    }

    public boolean isDone() {
        return index >= tasks.size();
    }

    private void nextTask() {
        if (tasks.size() <= index) {
            currentTask = null;
            return;
        }
        currentTask = tasks.get(index);
        if (currentTask.canStart()) {
            currentTask.start();
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

}
