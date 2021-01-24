package com.harium.suneidesis.repository;

import com.harium.suneidesis.concept.Thing;

import java.util.Collection;
import java.util.Map;

public interface Repository<T extends Thing> {

    Map<String, T> getAll();

    Collection<T> getValues();

    void set(String key, T t);

    T get(String key);

}
