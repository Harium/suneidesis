package com.harium.suneidesis.knowledge.beign;

import com.harium.suneidesis.knowledge.linguistic.core.Parser;
import com.harium.suneidesis.knowledge.linguistic.english.SimpleParser;

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
