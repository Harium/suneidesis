package com.harium.suneidesis.knowledge.linguistic.english.box;

import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.concept.Fact;

public interface ActionParser extends Parser {
    String describeAction(Fact action);
}
