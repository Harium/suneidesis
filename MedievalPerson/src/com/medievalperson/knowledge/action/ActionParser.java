package com.medievalperson.knowledge.action;

import com.medievalperson.knowledge.Parser;
import com.medievalperson.memory.Fact;

public interface ActionParser extends Parser {
	
	public String describeAction(Fact action);

}
