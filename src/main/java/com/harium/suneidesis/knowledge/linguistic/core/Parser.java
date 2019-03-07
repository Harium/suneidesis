package com.harium.suneidesis.knowledge.linguistic.core;

import com.harium.suneidesis.instance.Instance;
import com.harium.suneidesis.output.Output;

public interface Parser {

    boolean matches(String query);

    void parse(String query, Instance instance, Output output);

}
