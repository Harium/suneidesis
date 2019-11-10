package com.harium.suneidesis.knowledge.linguistic.core;

import com.harium.suneidesis.input.InputContext;

public interface Parser {

    boolean matches(InputContext context);

    void parse(InputContext context);

}
