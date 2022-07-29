package com.harium.suneidesis.task.planning;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.task.Task;
import com.harium.suneidesis.task.database.KnowledgeTask;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to represent high level instructions (many subtasks)
 */
public class ComplexKnowledgeTask extends KnowledgeTask {

    public static final String ATTRIBUTE_SUBJECT = "subject";

    private List<Task> subTasks = new ArrayList<>();

    public ComplexKnowledgeTask(String name, KnowledgeBase database) {
        super(name, database);
    }

    public boolean start() {
        if (!canStart()) {
           return false;
        }
        done = false;
        inProgress = true;
        boolean success = true;
        for (Task task : subTasks) {
            success &= task.start();
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
