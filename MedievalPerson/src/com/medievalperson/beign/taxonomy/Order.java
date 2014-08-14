package com.medievalperson.beign.taxonomy;

import com.medievalperson.Concept;

public class Order extends Concept {

	private TaxonomyClass taxonomyClass;

	private Order superOrder;
	
	public Order(String name) {
		super(name);
	}

	public TaxonomyClass getTaxonomyClass() {
		return taxonomyClass;
	}

	public void setTaxonomyClass(TaxonomyClass taxonomyClass) {
		this.taxonomyClass = taxonomyClass;
	}

	public Order getSuperOrder() {
		return superOrder;
	}

	public void setSuperOrder(Order superOrder) {
		this.superOrder = superOrder;
	}
		
}
