package com.suneidesis.memory;


public class RecurrentFact extends Fact {

	private int repeatCount = 1;

	public RecurrentFact() {
		super();
	}
	
	public RecurrentFact(Fact fact) {
		super();
		
		copy(fact);
	}
	
	public int getRepeatCount() {
		return repeatCount;
	}

	public void setRepeatCount(int repeatCount) {
		this.repeatCount = repeatCount;
	}
					
}
