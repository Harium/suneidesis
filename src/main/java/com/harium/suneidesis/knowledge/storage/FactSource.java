package com.harium.suneidesis.knowledge.storage;

import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.context.ConversationContext;

public class FactSource extends Concept {
	
	private Concept source;
	private AcquisitionMethod method = AcquisitionMethod.EXPERIENCED;
	private AcquisitionMethod sourceMethod = AcquisitionMethod.EXPERIENCED;
	private ConversationContext context;
	
	public FactSource(String name) {
		super(name);
	}
	
	public FactSource(String name, Concept source) {
		super(name);
		this.source = source;
	}
	
	public FactSource(String name, Concept source, AcquisitionMethod method) {
		super(name);
		this.source = source;
		this.method = method;
	}

	public Concept getSource() {
		return source;
	}

	public void setSource(Concept source) {
		this.source = source;
	}

	public AcquisitionMethod getMethod() {
		return method;
	}

	public void setMethod(AcquisitionMethod method) {
		this.method = method;
	}
	
	public AcquisitionMethod getSourceMethod() {
		return sourceMethod;
	}

	public void setSourceMethod(AcquisitionMethod sourceMethod) {
		this.sourceMethod = sourceMethod;
	}

	public ConversationContext getContext() {
		return context;
	}

	public void setContext(ConversationContext context) {
		this.context = context;
	}

	public enum AcquisitionMethod {
		EXPERIENCED, HEARD, READ, SAW, CONCLUDED;
	}
		
}
