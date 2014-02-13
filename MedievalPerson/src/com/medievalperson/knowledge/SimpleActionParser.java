package com.medievalperson.knowledge;

import java.util.List;

import com.medievalperson.action.Action;
import com.medievalperson.beign.Beign;
import com.medievalperson.knowledge.action.ActionParser;

public class SimpleActionParser implements ActionParser {

	@Override
	public String parse(String query, Beign beign) {
		
		String[] parts = query.replaceAll("\\?", "").split(" ");
		
		String queryAction = "";
		
		for(int i=0;i<parts.length;i++){
			
			if(parts[i].equalsIgnoreCase("about")){
				
				queryAction = parts[i+1];
				break;
				
			}
			
		}
		
		List<Action> actions = beign.getActions();

		for(Action action: actions){
			
			if(queryAction.equalsIgnoreCase(action.getAction())){
				return "Yes. "+describeAction(action);
			}
			
		}
		
		return "No.";
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
			builder.append(" ");
		}
		
		builder.append("at");
		builder.append(" ");
		builder.append(action.getPlace().getName());
		builder.append(" ");
		builder.append(action.getWhen());
		
		return builder.toString();
	}
	
}
