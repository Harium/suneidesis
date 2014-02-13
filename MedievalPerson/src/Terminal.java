import java.util.ArrayList;
import java.util.List;

import com.medievalperson.action.Action;
import com.medievalperson.beign.Beign;
import com.medievalperson.beign.Gender;
import com.medievalperson.beign.RationalBeign;
import com.medievalperson.place.Place;


public class Terminal {

	public static void main(String[] args){
		
		RationalBeign thrain = new RationalBeign("Thrain", Gender.MALE);
				
		RationalBeign thror = new RationalBeign("Thror", Gender.MALE);
		
		thrain.setBiologicalFather(thror);
		
		List<Action> actions = new ArrayList<Action>();
		
		Action killTroll = new Action();
		
		killTroll.setActor(thror); //Who did the action
		killTroll.setWho(new Beign("Troll")); //Who suffered the action 
		killTroll.setPlace(new Place("the top of the Silvertine")); //Where the action happens
		killTroll.setAction("Cut"); //Action's name
		killTroll.setWhereAction("throat"); //
		killTroll.setWhen("10 years ago"); //When action happens
		
		actions.add(killTroll);
		
		thrain.setActions(actions);
		
		ask("How are You?", thrain);
		
		ask("Who is your father?", thrain);
		
		ask("Who is your father?", thror);
		
		ask("Did you cut something else?", thrain);
		
		ask("Did you heard something about cut?", thrain);
		
		ask("Did you heard something about Sauron?", thrain);
				
	}
	
	private static void ask(String query, RationalBeign beign){
		
		System.out.println(query.replace("?", ", "+beign.getName()+"?"));
		
		System.out.println(beign.listen(query));
	}
	
}
