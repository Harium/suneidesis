package com.harium.suneidesis.repository;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Thing;

import java.util.Collection;
import java.util.Map;

public interface Repository<T extends Thing> {

    Map<String, T> getAll();

    Collection<T> getValues();

    Concept insert(String key, T t);

    T get(String key);

    boolean contains(String key);

}
