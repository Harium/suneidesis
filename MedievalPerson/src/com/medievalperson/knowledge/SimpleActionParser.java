package com.medievalperson.knowledge;

import java.util.List;

import com.medievalperson.action.Action;
import com.medievalperson.beign.Beign;
import com.medievalperson.knowledge.action.ActionParser;

public class SimpleActionParser implements ActionParser {

	@Override
	public String parse(String query, Beign beign) {

		String[] parts = query.replaceAll("\\?", "").split(" ");

		String querySubject = "";

		for(int i=0;i<parts.length;i++){

			if(parts[i].equalsIgnoreCase("about")){

				querySubject = parts[i+1];
				break;

			}

		}

		if(!querySubject.isEmpty()){

			List<Action> actions = beign.getActions();

			Action action = null;
			
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

	private Action findActionByActorsName(String actorName, List<Action> actions){

		for(Action action: actions){

			if(actorName.equalsIgnoreCase(action.getActor().getName())||actorName.equalsIgnoreCase(action.getWho().getName())){
				return action;
			}

		}

		return null;

	}

	private Action findActionByName(String actionName, List<Action> actions){

		for(Action action: actions){

			if(actionName.equalsIgnoreCase(action.getAction())){
				return action;
			}

		}

		return null;
	}

	public String describeAction(Action action){

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
		builder.append(action.getPlace().getName());
		builder.append(" ");
		builder.append(action.getWhen());

		return builder.toString();
	}

}
