import beign.Beign;
import beign.human.Gender;


public class Terminal {

	public static void main(String[] args){
		
		Beign thrain = new Beign("Thrain", Gender.MALE);
		
		Beign thror = new Beign("Thror", Gender.MALE);
		
		thrain.setBiologicalFather(thror);
		
		ask("How are You?", thrain);
		
		ask("Who is your father?", thrain);
		
		ask("Who is your father?", thror);		
				
	}
	
	private static void ask(String query, Beign beign){
		System.out.println(query);
		
		System.out.println(beign.listen(query));
	}
	
}
