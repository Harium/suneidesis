package com.harium.suneidesis.repository;

import com.harium.suneidesis.concept.Thing;

import java.util.Collection;

public interface Repository<T extends Thing> {

    Collection<T> getAll();

    void set(String key, T t);

    T get(String key);

}
