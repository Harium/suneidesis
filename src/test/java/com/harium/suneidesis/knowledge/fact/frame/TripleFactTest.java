package com.harium.suneidesis.knowledge.fact.frame;

import com.harium.suneidesis.beign.Being;
import com.harium.suneidesis.knowledge.concept.Action;
import com.harium.suneidesis.knowledge.concept.Concept;
import com.harium.suneidesis.knowledge.concept.ConceptType;
import org.junit.Assert;
import org.junit.Test;

public class TripleFactTest {

    @Test
    public void testInitTriple() {
        Being john = new Being("John");
        Action has = new Action("has");
        Concept name = new Concept("name");

        TripleFact johnHasAName = new TripleFact(john, has, name);

        Assert.assertEquals(ConceptType.CREATURE, johnHasAName.getSubject().getType());
        Assert.assertEquals(ConceptType.ACTION, johnHasAName.getPredicate().getType());
        Assert.assertNotNull(johnHasAName.getObject());
    }

    @Test
    public void testComplexTriple() {
        Being john = new Being("John");
        Action has = new Action("has");
        Concept name = new Concept("name");

        TripleFact johnHasAName = new TripleFact(john, has, name);

        Action thinks = new Action("think");
        TripleFact johnThinksHeHasAName = new TripleFact(john, thinks, johnHasAName);

        Assert.assertEquals(ConceptType.CREATURE, johnThinksHeHasAName.getSubject().getType());
        Assert.assertEquals(ConceptType.ACTION, johnThinksHeHasAName.getPredicate().getType());
        Assert.assertNotNull(johnThinksHeHasAName.getObject());
    }

}
