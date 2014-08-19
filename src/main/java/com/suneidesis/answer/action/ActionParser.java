package com.suneidesis.answer.action;

import com.suneidesis.answer.Parser;
import com.suneidesis.memory.Fact;

public interface ActionParser extends Parser {
	
	public String describeAction(Fact action);

}
