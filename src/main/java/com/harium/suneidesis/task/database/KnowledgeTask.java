package com.harium.suneidesis.task.database;

import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.task.BaseTask;

public abstract class KnowledgeTask extends BaseTask {

    protected final KnowledgeBase database;

    public KnowledgeTask(String name, KnowledgeBase database) {
        super(name);
        this.database = database;
    }

}
