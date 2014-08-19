import java.util.ArrayList;
import java.util.List;

import com.suneidesis.beign.Being;
import com.suneidesis.beign.Gender;
import com.suneidesis.beign.RationalBeign;
import com.suneidesis.concept.Concept;
import com.suneidesis.memory.Fact;
import com.suneidesis.place.Place;


public class Terminal {

	public static void main(String[] args) {
		
		RationalBeign thrain = new RationalBeign("Thrain", Gender.MALE);
				
		RationalBeign thror = new RationalBeign("Thror", Gender.MALE);
		
		thrain.setBiologicalFather(thror);
				
		thrain.setMemories(createMemories(thror));
		
		ask("How are You?", thrain);
		
		ask("Who is your father?", thrain);
		
		ask("Who is your father?", thror);
		
		ask("Did you cut something else?", thrain);
		
		ask("Did you heard something about cut?", thrain);
		
		ask("Did you heard something about Sauron?", thrain);
				
	}
	
	private static List<Fact> createMemories(RationalBeign beign) {

		List<Fact> actions = new ArrayList<Fact>();
		
		Fact killTroll = new Fact();
		
		killTroll.setActor(beign); //Who did the action
		killTroll.setTarget(new Being("a Troll")); //Who suffered the action (target) 
		killTroll.setPlace(new Place("at the top of").at(new Place("Silvertine"))); //Where the action happens
		killTroll.setAction(new Concept("Cut")); //Action's name
		killTroll.setWhereInTarget(new Concept("throat")); // Where in the target the action happened
		killTroll.setWhen(new Concept("last week")); //When action happens
		
		List<Fact> conclusions = new ArrayList<Fact>();
		Fact beingKilledTroll = new Fact();
		beingKilledTroll.setActor(beign);
		beingKilledTroll.setAction(new Concept("Kill"));
		beingKilledTroll.setTarget(new Being("a Troll"));
		
		conclusions.add(beingKilledTroll);
		killTroll.setConclusions(conclusions);
		
		actions.add(killTroll);
		
		Fact createRing = new Fact();
		
		createRing.setActor(new Being("Sauron")); //Who did the action
		createRing.setTarget(new Being("a ring")); //Who suffered the action 
		createRing.setPlace(new Place("somewhere in").at(new Place("Middle-Earth"))); //Where the action happens
		createRing.setAction(new Concept("Create")); //Action's name
		createRing.setWhereInTarget(null); // 
		createRing.setWhen(new Concept("many years ago")); //When action happens
		
		actions.add(createRing);
		
		//Fact summerRain = new Fact();
		//summerRain.setPlace(place);
		
		return actions;
		
	}
	
	private static void ask(String query, RationalBeign beign) {
		
		System.out.println(query.replace("?", ", "+beign.getName()+"?"));
		
		System.out.println(beign.listen(query));
		
	}
	
}
