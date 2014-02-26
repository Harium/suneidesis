package com.medievalperson.knowledge.action;

import com.medievalperson.knowledge.Parser;
import com.medievalperson.memory.Memory;

public interface ActionParser extends Parser {
	
	public String describeAction(Memory action);

}
