package com.harium.suneidesis.storage;

import com.harium.suneidesis.concept.Thing;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemoryRepository<T extends Thing> implements Repository<T> {

    private long id = 0;
    private Map<String, T> data;

    @Override
    public Collection<T> getAll() {
        return getData().values();
    }

    @Override
    public String add(T t) {
        String id = t.getId();
        if (id == null) {
            id = generateId();
            t.setId(id);
        }
        getData().put(id, t);
        return id;
    }

    @Override
    public void get(String id) {
        getData().get(id);
    }

    public Map<String, T> getData() {
        if (data == null) {
            data = new HashMap<>();
        }
        return data;
    }

    private String generateId() {
        id++;
        return Long.toString(id);
    }
}
