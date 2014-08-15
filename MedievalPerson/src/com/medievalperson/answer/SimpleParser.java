package com.medievalperson.answer;

import com.medievalperson.answer.action.ActionParser;
import com.medievalperson.answer.action.SimpleActionParser;
import com.medievalperson.answer.adjective.AdjectiveParser;
import com.medievalperson.answer.feeling.FeelingParser;
import com.medievalperson.answer.feeling.SimpleFeelingParser;
import com.medievalperson.beign.Being;

public class SimpleParser implements Parser {

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

		if("How".equalsIgnoreCase(parts[0])) {

			response = feelingParser.parse(query, beign);

		}else if("Who".equalsIgnoreCase(parts[0])) {

			response = familyTreeParser.parse(query, beign);

		}else if("Did".equalsIgnoreCase(parts[0])) {

			response = actionParser.parse(query, beign);

		}else if("Are".equalsIgnoreCase(parts[0])) {

			response = adjectiveParser.parse(query, beign);
		}

		if(response==null) {
			response = "I do not know";
		}

		return response;
	}	

}
