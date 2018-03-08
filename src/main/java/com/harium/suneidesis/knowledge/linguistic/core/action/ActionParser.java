package com.harium.suneidesis.knowledge.linguistic.core.action;

import com.harium.suneidesis.knowledge.linguistic.core.Parser;
import com.harium.suneidesis.knowledge.memory.Fact;

public interface ActionParser extends Parser {
	
	public String describeAction(Fact action);

}
