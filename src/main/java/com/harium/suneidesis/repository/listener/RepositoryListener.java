package com.harium.suneidesis.repository.listener;

import com.harium.suneidesis.concept.Concept;

public interface RepositoryListener {

    void onInsert(String key, Concept concept);
}
