package com.harium.suneidesis;

import com.harium.suneidesis.beign.Being;
import com.harium.suneidesis.beign.Gender;
import com.harium.suneidesis.knowledge.linguistic.core.Parser;
import com.harium.suneidesis.knowledge.linguistic.english.SimpleParser;
import com.harium.suneidesis.output.Output;
import com.harium.suneidesis.output.TextOutput;

public class Instance extends Being {

    private Output output;
	private Parser parser = new SimpleParser();
	
	public Instance(String name) {
		super(name);
		output = new TextOutput();
	}
	
	public Instance(String name, Gender gender) {
		super(name, gender);
	}

	public String input(String sentence) {
		return parser.parse(sentence, this);
	}

	public void output(String sentence) {
        output.print(sentence);
    }
	
}
