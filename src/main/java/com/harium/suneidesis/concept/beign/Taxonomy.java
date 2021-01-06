package com.harium.suneidesis.concept.beign;

import com.harium.suneidesis.concept.Concept;

public class Taxonomy extends Concept {

	public static final String ATTRIBUTE_KINGDOM = "taxonomy_kingdom";
	public static final String ATTRIBUTE_PHYLUM = "taxonomy_phylum";
	public static final String ATTRIBUTE_CLASS = "taxonomy_class";
	public static final String ATTRIBUTE_CLADE = "taxonomy_clade";
	public static final String ATTRIBUTE_ORDER = "taxonomy_order";

	public Taxonomy(String name) {
		super(name);
	}

	public Taxonomy kingdom(Concept property) {
		this.set(ATTRIBUTE_KINGDOM, property);
		return this;
	}

	public Taxonomy phylum(Concept property) {
		this.set(ATTRIBUTE_PHYLUM, property);
		return this;
	}

	public Taxonomy klass(Concept property) {
		this.set(ATTRIBUTE_CLASS, property);
		return this;
	}

	public Taxonomy klade(Concept property) {
		this.set(ATTRIBUTE_CLADE, property);
		return this;
	}

	public Taxonomy order(Concept property) {
		this.set(ATTRIBUTE_ORDER, property);
		return this;
	}
}
