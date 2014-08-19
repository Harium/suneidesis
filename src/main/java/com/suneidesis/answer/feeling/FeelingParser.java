package com.suneidesis.answer.feeling;

import com.suneidesis.answer.Parser;
import com.suneidesis.beign.HealthStatus;

public interface FeelingParser extends Parser {

	public String translateFeelingToString(HealthStatus feeling);
	
}
