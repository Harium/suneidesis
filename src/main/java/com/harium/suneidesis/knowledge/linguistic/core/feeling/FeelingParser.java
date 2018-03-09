package com.harium.suneidesis.knowledge.linguistic.core.feeling;

import com.harium.suneidesis.knowledge.beign.Status;
import com.harium.suneidesis.knowledge.linguistic.core.Parser;

public interface FeelingParser extends Parser {

	public String translateFeelingToString(Status feeling);
	
}
