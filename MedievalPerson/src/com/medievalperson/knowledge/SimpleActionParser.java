package com.medievalperson.knowledge;

import java.util.List;

import com.medievalperson.beign.Being;
import com.medievalperson.knowledge.action.ActionParser;
import com.medievalperson.memory.Fact;
import com.medievalperson.place.Place;

public class SimpleActionParser implements ActionParser {

	@Override
	public String parse(String query, Being beign) {

		String[] parts = query.replaceAll("\\?", "").split(" ");

		String querySubject = "";

		for(int i=0;i<parts.length;i++){

			if(parts[i].equalsIgnoreCase("about")){

				querySubject = parts[i+1];
				break;

			}

		}

		if(!querySubject.isEmpty()){

			List<Fact> actions = beign.getMemories();

			Fact action = null;
			
			if(!Character.isUpperCase(querySubject.charAt(0))){
				action = findActionByName(querySubject, actions);
			}else{
				action = findActionByActorsName(querySubject, actions);
			}		

			if(action!=null){
				return describeAction(action);
			}
			
		}

		return "No.";
	}

	private Fact findActionByActorsName(String actorName, List<Fact> actions){

		for(Fact action: actions){

			if(actorName.equalsIgnoreCase(action.getActor().getName())||actorName.equalsIgnoreCase(action.getWho().getName())){
				return action;
			}

		}

		return null;

	}

	private Fact findActionByName(String actionName, List<Fact> actions){

		for(Fact action: actions){

			if(actionName.equalsIgnoreCase(action.getAction())){
				return action;
			}

		}

		return null;
	}

	public String describeAction(Fact action){

		StringBuilder builder = new StringBuilder();

		builder.append("I heard that");
		builder.append(" ");
		builder.append(action.getActor().getName());
		builder.append(" ");
		builder.append(action.getAction().toLowerCase());
		builder.append("s ");
		builder.append(action.getWho().getName());

		if(!action.getWhereAction().isEmpty()){
			builder.append("'s ");
			builder.append(action.getWhereAction());			
		}

		builder.append(" ");
		builder.append(getPlace(action.getPlace()));
		builder.append(" ");
		builder.append(action.getWhen());

		return builder.toString();
	}
	
	private String getPlace(Place place) {
		
		String placeSentence = place.getName();
		
		if(place.getPlace() != null) {
			
			placeSentence += " ";
			
			placeSentence += getPlace(place.getPlace()); 
		}
		
		return placeSentence;
		
	}

}
