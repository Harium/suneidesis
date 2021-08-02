package com.harium.suneidesis.repository.merge;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.repository.RepositoryCursor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CreateNewMergeStrategy implements MergeStrategy {

    private final KnowledgeBase knowledgeBase;

    private Set<String> originalIds = new HashSet<>();
    private Map<String, String> mergedIds = new HashMap<>();

    public CreateNewMergeStrategy(KnowledgeBase knowledgeBase) {
        this.knowledgeBase = knowledgeBase;
        init(knowledgeBase);
    }

    private void init(KnowledgeBase knowledgeBase) {
        originalIds.clear();
        mergedIds.clear();

        RepositoryCursor<Concept> all = knowledgeBase.findAll();
        Iterator<Concept> iterator = all.iterator();
        while (iterator.hasNext()) {
            Concept concept = iterator.next();
            originalIds.add(concept.getId());
        }

        knowledgeBase.getIdGenerator().update(knowledgeBase);
    }

    @Override
    public void setId(Concept concept, String key) {
        if (!originalIds.contains(key)) {
            concept.id(key);
        } else {
            String generatedId;
            if (mergedIds.containsKey(key)) {
                generatedId = mergedIds.get(key);
            } else {
                generatedId = knowledgeBase.getIdGenerator().generateId(concept);
                mergedIds.put(key, generatedId);
            }
            concept.id(generatedId);
        }
    }
}
