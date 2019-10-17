package com.harium.suneidesis.knowledge.storage;

import com.harium.suneidesis.knowledge.Thing;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MemoryStorage<T extends Thing> implements Storage<T> {

    private int id = 0;
    private Map<String, T> map;

    @Override
    public Collection<T> getAll() {
        return getMap().values();
    }

    @Override
    public void add(T t) {
        if (t.getId() == null) {
            String id = generateId();
            t.setId(id);
        }
        getMap().put(t.getId(), t);
    }

    @Override
    public void get(String id) {
        getMap().get(id);
    }

    public Map<String, T> getMap() {
        if (map == null) {
            map = new HashMap<>();
        }
        return map;
    }

    private String generateId() {
        id++;
        return Integer.toString(id);
    }
}
