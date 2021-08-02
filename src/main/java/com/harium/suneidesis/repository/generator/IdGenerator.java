package com.harium.suneidesis.repository.generator;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.repository.KnowledgeBase;

public interface IdGenerator {

    String generateId(Concept concept);

    void update(KnowledgeBase knowledgeBase);
}
