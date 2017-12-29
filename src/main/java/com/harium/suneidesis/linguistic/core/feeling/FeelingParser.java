package com.harium.suneidesis.linguistic.core.feeling;

import com.harium.suneidesis.beign.HealthStatus;
import com.harium.suneidesis.linguistic.core.Parser;

public interface FeelingParser extends Parser {

	public String translateFeelingToString(HealthStatus feeling);
	
}
