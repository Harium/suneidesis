package com.harium.suneidesis.repository;

import com.harium.suneidesis.concept.Thing;
import org.dizitart.no2.Filter;

public interface KnowledgeBaseRepository<T extends Thing> extends Repository<T> {

    RepositoryCursor<T> findAll();

    RepositoryCursor<T> find(Filter filter);

    T findById(String id);
}
