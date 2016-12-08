package com.suneidesis.linguistic.feeling;

import com.suneidesis.beign.HealthStatus;
import com.suneidesis.linguistic.Parser;

public interface FeelingParser extends Parser {

	public String translateFeelingToString(HealthStatus feeling);
	
}
