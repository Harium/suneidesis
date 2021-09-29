package com.harium.suneidesis.concept.beign;

import com.harium.suneidesis.concept.Concept;

public class Taxonomy extends Concept {

	public static final String ATTRIBUTE_TAXONOMY = "taxonomy";
	private static final String ATTRIBUTE_DOMAIN = "taxonomy_domain";
	private static final String ATTRIBUTE_KINGDOM = "taxonomy_kingdom";
	private static final String ATTRIBUTE_PHYLUM = "taxonomy_phylum";
	private static final String ATTRIBUTE_CLASS = "taxonomy_class";
	private static final String ATTRIBUTE_CLADE = "taxonomy_clade";
	private static final String ATTRIBUTE_ORDER = "taxonomy_order";
	private static final String ATTRIBUTE_SUBORDER = "taxonomy_suborder";
	private static final String ATTRIBUTE_FAMILY = "taxonomy_family";
	private static final String ATTRIBUTE_SUBFAMILY = "taxonomy_subfamily";
	private static final String ATTRIBUTE_GENUS = "taxonomy_genus";
	private static final String ATTRIBUTE_SPECIE = "taxonomy_specie";

	public Taxonomy(String name) {
		super(name);
	}

	public Taxonomy domain(Concept property) {
		this.has(ATTRIBUTE_DOMAIN, property);
		return this;
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

	public Taxonomy suborder(Concept property) {
		this.has(ATTRIBUTE_SUBORDER, property);
		return this;
	}

	public Taxonomy family(Concept property) {
		this.has(ATTRIBUTE_FAMILY, property);
		return this;
	}

	public Taxonomy subfamily(Concept property) {
		this.has(ATTRIBUTE_SUBFAMILY, property);
		return this;
	}

	public Taxonomy genus(Concept property) {
		this.has(ATTRIBUTE_GENUS, property);
		return this;
	}

	public Taxonomy specie(Concept property) {
		this.has(ATTRIBUTE_SPECIE, property);
		return this;
	}
}
