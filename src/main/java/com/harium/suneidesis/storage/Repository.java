package com.harium.suneidesis.storage;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> getAll();

    void set(String key, T t);

    T get(String id);

}
