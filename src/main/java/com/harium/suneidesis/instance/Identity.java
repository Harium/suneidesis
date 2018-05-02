package com.harium.suneidesis.instance;

import java.util.HashMap;
import java.util.Map;

public class Identity {

    public static final String NAME = "name";

    protected Map<String, String> information = new HashMap<String, String>();

    public void put(String key, String value) {
        information.put(key, value);
    }

    public boolean has(String key) {
        return information.containsKey(key);
    }

    public String get(String key) {
        String value = information.get(key);
        if (value == null) {
            return "";
        }
        return value;
    }

    public String getName() {
        return get(NAME);
    }
}
