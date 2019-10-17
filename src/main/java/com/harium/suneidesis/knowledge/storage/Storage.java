package com.harium.suneidesis.knowledge.storage;

import java.util.Collection;

public interface Storage<T> {

    Collection<T> getAll();

    void add(T t);

    void get(String id);

}
