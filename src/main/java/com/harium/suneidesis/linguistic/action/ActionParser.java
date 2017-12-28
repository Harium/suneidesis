package com.harium.suneidesis.linguistic.action;

import com.harium.suneidesis.linguistic.Parser;
import com.harium.suneidesis.memory.Fact;

public interface ActionParser extends Parser {
	
	public String describeAction(Fact action);

}
