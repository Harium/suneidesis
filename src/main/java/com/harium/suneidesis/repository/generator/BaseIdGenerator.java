package com.harium.suneidesis.repository.generator;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.repository.KnowledgeBase;

public class BaseIdGenerator implements IdGenerator {

    private long value = 0;

    @Override
    public String generateId(Concept concept) {
        return Long.toString(value++);
    }

    @Override
    public void update(KnowledgeBase knowledgeBase) {
        value = knowledgeBase.count();
    }
}
