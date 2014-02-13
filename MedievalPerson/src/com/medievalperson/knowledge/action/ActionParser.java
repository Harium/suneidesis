package com.medievalperson.knowledge.action;

import com.medievalperson.action.Action;
import com.medievalperson.knowledge.Parser;

public interface ActionParser extends Parser {
	
	public String describeAction(Action action);

}
