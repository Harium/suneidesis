package com.harium.suneidesis.linguistic.core.action;

import com.harium.suneidesis.linguistic.core.Parser;
import com.harium.suneidesis.memory.Fact;

public interface ActionParser extends Parser {
	
	public String describeAction(Fact action);

}
