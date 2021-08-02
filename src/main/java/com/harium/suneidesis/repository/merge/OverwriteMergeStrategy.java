package com.harium.suneidesis.repository.merge;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.repository.KnowledgeBase;

public class OverwriteMergeStrategy implements MergeStrategy {

    private final KnowledgeBase knowledgeBase;

    public OverwriteMergeStrategy(KnowledgeBase knowledgeBase) {
        this.knowledgeBase = knowledgeBase;
    }

    @Override
    public void setId(Concept concept, String id) {
        concept.id(id);
    }
}
