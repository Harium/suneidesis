package com.harium.suneidesis.repository;

import com.harium.suneidesis.concept.Thing;

import java.util.Iterator;
import java.util.Map;

public interface Repository<T extends Thing> {

    Map<String, T> getAll();

    Iterator<T> iterator();

    String save(T concept);

    T save(String key, T t);

    T get(String key);

    boolean contains(String key);

    long count();

    void clear();

    void close();

    boolean isClosed();
}
