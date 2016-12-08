package com.suneidesis.linguistic.action;

import com.suneidesis.linguistic.Parser;
import com.suneidesis.memory.Fact;

public interface ActionParser extends Parser {
	
	public String describeAction(Fact action);

}
