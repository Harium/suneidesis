package com.harium.suneidesis.knowledge.linguistic.core.action;

import com.harium.suneidesis.knowledge.linguistic.core.Parser;
import com.harium.suneidesis.knowledge.storage.Fact;

public interface ActionParser extends Parser {
	
	public String describeAction(Fact action);

}
