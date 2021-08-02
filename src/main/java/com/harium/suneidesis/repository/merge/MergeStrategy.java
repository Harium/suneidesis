package com.harium.suneidesis.repository.merge;

import com.harium.suneidesis.concept.Concept;

public interface MergeStrategy {

    void setId(Concept concept, String key);
}
