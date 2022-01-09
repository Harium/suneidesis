package com.harium.suneidesis.planning;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.processing.BaseTask;
import com.harium.suneidesis.processing.Task;
import com.harium.suneidesis.repository.KnowledgeBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent high level instructions (many subtasks)
 */
public class ComplexTask extends BaseTask {

    public static final String ATTRIBUTE_SUBJECT = "subject";

    private List<Task> subTasks = new ArrayList<>();

    public ComplexTask(String name) {
        super(name);
    }

    public boolean start(KnowledgeBase environment) {
        if (!canStart()) {
           return false;
        }
        done = false;
        inProgress = true;
        boolean success = true;
        for (Task task : subTasks) {
            success &= task.start(environment);
        }

        inProgress = false;
        done = true;
        return success;
    }

    public void addSubTask(Task task) {
        subTasks.add(task);
    }

    @Override
    public boolean canStart() {
        return true;
    }

    public Concept setSubject(Concept subject) {
        return getAttributes().save(ATTRIBUTE_SUBJECT, subject);
    }

    public Concept subject() {
        return getAttributes().get(ATTRIBUTE_SUBJECT);
    }

}
