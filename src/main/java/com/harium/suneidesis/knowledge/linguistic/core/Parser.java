package com.harium.suneidesis.knowledge.linguistic.core;

import com.harium.suneidesis.instance.Instance;

public interface Parser {

    boolean matches(String query);

    String parse(String query, Instance instance);

}
