package com.harium.suneidesis.repository.generator;

import com.harium.suneidesis.concept.Concept;

public class BaseIdGenerator implements IdGenerator {

    private long value = 0;

    @Override
    public String generateId(Concept concept) {
        return Long.toString(value++);
    }
}
