package com.harium.suneidesis.knowledge.linguistic.core.feeling;

import com.harium.suneidesis.beign.Status;
import com.harium.suneidesis.knowledge.linguistic.core.Parser;

public interface FeelingParser extends Parser {

	String translateFeelingToString(Status feeling);
	
}
