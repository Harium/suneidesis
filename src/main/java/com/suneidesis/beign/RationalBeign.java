package com.suneidesis.beign;

import com.suneidesis.linguistic.Parser;
import com.suneidesis.linguistic.SimpleParser;

public class RationalBeign extends Being {

	private Parser parser = new SimpleParser();
	
	public RationalBeign(String name) {
		super(name);
	}
	
	public RationalBeign(String name, Gender gender) {
		super(name, gender);
	}
			
	public String listen(String sentence){
		return parser.parse(sentence, this);
	}
	
}
