package com.medievalperson.knowledge.feeling;

import com.medievalperson.beign.Feeling;
import com.medievalperson.knowledge.Parser;

public interface FeelingParser extends Parser {

	public String translateFeelingToString(Feeling feeling);
	
}
