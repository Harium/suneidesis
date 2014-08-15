package com.medievalperson.answer.action;

import com.medievalperson.answer.Parser;
import com.medievalperson.memory.Fact;

public interface ActionParser extends Parser {
	
	public String describeAction(Fact action);

}
