package com.harium.suneidesis.instance;

import com.harium.suneidesis.beign.Being;
import com.harium.suneidesis.beign.Gender;
import com.harium.suneidesis.knowledge.linguistic.core.Parser;
import com.harium.suneidesis.knowledge.linguistic.english.SimpleParser;
import com.harium.suneidesis.output.Output;
import com.harium.suneidesis.output.TextOutput;

public class Instance extends Being {

    private Identity identity;
    //private Context context;

    private Output output;
	private Parser parser = new SimpleParser();
	
	public Instance(Identity identity) {
		super(identity.getName());
		this.identity = identity;
		output = new TextOutput();
	}
	
	public Instance(Identity identity, Gender gender) {
		super(identity.getName(), gender);
        this.identity = identity;
	}

	public String input(String sentence) {
		return parser.parse(sentence, this);
	}

	public void output(String sentence) {
        output.print(sentence);
    }
	
}
