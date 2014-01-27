package beign;

import beign.human.Gender;
import knowledge.Parser;
import knowledge.SimpleParser;
import thing.Thing;

public class Beign extends Thing{

	private Beign biologicalFather = null;
	
	private Beign biologicalMother = null;
		
	protected Feeling feeling = new Feeling();
	
	protected Gender gender = Gender.UNKNOWN;
	
	private Parser parser = new SimpleParser();
	
	public Beign(String name) {
		super(name);
	}
	
	public Beign(String name, Gender gender) {
		this(name);
		
		this.gender = gender;
	}
	
	public String listen(String sentence){
		return parser.parse(sentence, this);
	}

	public Feeling getFeeling() {
		return feeling;
	}

	public Beign getBiologicalFather() {
		return biologicalFather;
	}

	public void setBiologicalFather(Beign biologicalFather) {
		
		if(biologicalFather.gender==Gender.MALE){		
			this.biologicalFather = biologicalFather;
		}
		
	}

	public Beign getBiologicalMother() {
		return biologicalMother;
	}

	public void setBiologicalMother(Beign biologicalMother) {
		
		if(biologicalFather.gender==Gender.FEMALE){
			this.biologicalMother = biologicalMother;
		}
		
	}	
		
}
