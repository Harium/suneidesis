package com.medievalperson.knowledge.feeling;

import com.medievalperson.beign.HealthStatus;
import com.medievalperson.knowledge.Parser;

public interface FeelingParser extends Parser {

	public String translateFeelingToString(HealthStatus feeling);
	
}
