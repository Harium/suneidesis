package com.medievalperson.answer.feeling;

import com.medievalperson.answer.Parser;
import com.medievalperson.beign.HealthStatus;

public interface FeelingParser extends Parser {

	public String translateFeelingToString(HealthStatus feeling);
	
}
