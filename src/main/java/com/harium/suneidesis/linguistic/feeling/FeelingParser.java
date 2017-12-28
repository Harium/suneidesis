package com.harium.suneidesis.linguistic.feeling;

import com.harium.suneidesis.beign.HealthStatus;
import com.harium.suneidesis.linguistic.Parser;

public interface FeelingParser extends Parser {

	public String translateFeelingToString(HealthStatus feeling);
	
}
