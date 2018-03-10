package com.harium.suneidesis.ontology;

import com.harium.suneidesis.beign.Being;
import com.harium.suneidesis.knowledge.concept.Action;
import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.concept.ConceptType;
import org.junit.Assert;
import org.junit.Test;

public class TripleTest {

    @Test
    public void testInitTriple() {
        Being john = new Being("John");
        Action has = new Action("has");
        Concept name = new Concept("name");

        Triple johnHasAName = new Triple(john, has, name);

        Assert.assertEquals(ConceptType.CREATURE, johnHasAName.subject.getType());
        Assert.assertEquals(ConceptType.ACTION, johnHasAName.predicate.getType());
        Assert.assertNotNull(johnHasAName.object);
    }

    @Test
    public void testComplexTriple() {
        Being john = new Being("John");
        Action has = new Action("has");
        Concept name = new Concept("name");

        Triple johnHasAName = new Triple(john, has, name);

        Action thinks = new Action("think");
        Triple johnThinksHeHasAName = new Triple(john, thinks, johnHasAName);

        Assert.assertEquals(ConceptType.CREATURE, johnThinksHeHasAName.subject.getType());
        Assert.assertEquals(ConceptType.ACTION, johnThinksHeHasAName.predicate.getType());
        Assert.assertNotNull(johnThinksHeHasAName.object);
    }

}
