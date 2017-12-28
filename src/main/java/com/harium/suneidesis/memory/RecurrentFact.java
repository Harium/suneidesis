package com.harium.suneidesis.memory;


public class RecurrentFact extends Fact {

	private int repeatCount = 1;

	public RecurrentFact(String name) {
		super(name);
	}
	
	public RecurrentFact(Fact fact) {
		super(fact.getName());
		copy(fact);
	}
	
	public int getRepeatCount() {
		return repeatCount;
	}

	public void setRepeatCount(int repeatCount) {
		this.repeatCount = repeatCount;
	}
					
}
