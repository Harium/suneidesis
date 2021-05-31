package com.harium.suneidesis.concept.beign;

import com.harium.suneidesis.concept.Concept;

public class Taxonomy extends Concept {

	public static final String ATTRIBUTE_TAXONOMY = "taxonomy";
	private static final String ATTRIBUTE_KINGDOM = "taxonomy_kingdom";
	private static final String ATTRIBUTE_PHYLUM = "taxonomy_phylum";
	private static final String ATTRIBUTE_CLASS = "taxonomy_class";
	private static final String ATTRIBUTE_CLADE = "taxonomy_clade";
	private static final String ATTRIBUTE_ORDER = "taxonomy_order";

	public Taxonomy(String name) {
		super(name);
	}

    public Taxonomy kingdom(Concept property) {
		this.has(ATTRIBUTE_KINGDOM, property);
		return this;
	}

	public Taxonomy phylum(Concept property) {
		this.has(ATTRIBUTE_PHYLUM, property);
		return this;
	}

	public Taxonomy klass(Concept property) {
		this.has(ATTRIBUTE_CLASS, property);
		return this;
	}

	public Taxonomy klade(Concept property) {
		this.has(ATTRIBUTE_CLADE, property);
		return this;
	}

	public Taxonomy order(Concept property) {
		this.has(ATTRIBUTE_ORDER, property);
		return this;
	}
}
