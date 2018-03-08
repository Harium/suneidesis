package com.harium.suneidesis.knowledge.linguistic.english;

import com.harium.suneidesis.knowledge.beign.Being;
import com.harium.suneidesis.knowledge.linguistic.core.Parser;
import com.harium.suneidesis.knowledge.linguistic.english.action.SimpleActionParser;
import com.harium.suneidesis.knowledge.linguistic.core.adjective.AdjectiveParser;
import com.harium.suneidesis.knowledge.linguistic.core.feeling.FeelingParser;
import com.harium.suneidesis.knowledge.linguistic.core.action.ActionParser;
import com.harium.suneidesis.knowledge.linguistic.english.feeling.SimpleFeelingParser;

public class SimpleParser implements Parser {

	private static final String ARE = "Are";

	private static final String DID = "Did";

	private static final String WHO = "Who";

	private static final String HOW = "How";

	private FeelingParser feelingParser = new SimpleFeelingParser();

	private FamilyTreeParser familyTreeParser = new FamilyTreeParser();

	private ActionParser actionParser = new SimpleActionParser();
	
	private AdjectiveParser adjectiveParser = new SimpleAdjectiveParser();

	public SimpleParser() {
		super();
	}

	@Override
	public String parse(String query, Being beign) {

		String[] parts = query.replaceAll("\\?", "").split(" ");

		String response = null;

		if(HOW.equalsIgnoreCase(parts[0])) {

			response = feelingParser.parse(query, beign);

		}else if(WHO.equalsIgnoreCase(parts[0])) {

			response = familyTreeParser.parse(query, beign);

		}else if(DID.equalsIgnoreCase(parts[0])) {

			response = actionParser.parse(query, beign);

		}else if(ARE.equalsIgnoreCase(parts[0])) {

			response = adjectiveParser.parse(query, beign);
		}

		if(response==null) {
			response = "I do not know.";
		}

		return response;
	}	

}
