package com.harium.suneidesis.storage;

import java.util.Collection;

public interface Repository<T> {

    Collection<T> getAll();

    String add(T t);

    void get(String id);

}
