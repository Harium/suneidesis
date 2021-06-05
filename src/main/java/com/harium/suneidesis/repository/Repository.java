package com.harium.suneidesis.repository;

import com.harium.suneidesis.concept.Thing;
import org.dizitart.no2.Filter;

import java.util.Iterator;
import java.util.Map;

public interface Repository<T extends Thing> {

    Map<String, T> getAll();

    Iterator<T> iterator();

    String add(T concept);

    T add(String key, T t);

    T get(String key);

    boolean contains(String key);

    void clear();

    void close();

    boolean isClosed();

    RepositoryCursor<T> find();

    RepositoryCursor<T> find(Filter filter);
}
