package com.harium.suneidesis.linguistic.english.box;

import com.harium.suneidesis.chat.Parser;
import com.harium.suneidesis.concept.Action;
import com.harium.suneidesis.concept.Concept;

public interface ActionParser extends Parser {
    String describeAction(Action action);
}
