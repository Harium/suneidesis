package com.harium.suneidesis.concept.attribute;

import com.harium.suneidesis.concept.*;
import com.harium.suneidesis.inspector.Inspector;
import com.harium.suneidesis.inspector.matchers.Equals;
import com.harium.suneidesis.inspector.matchers.GreaterThan;
import com.harium.suneidesis.inspector.matchers.LowerThan;
import com.harium.suneidesis.concept.numeral.Measure;
import org.junit.Test;

import static com.harium.suneidesis.inspector.Inspector.does;
import static org.junit.Assert.*;

public class AttributesTest {

    @Test
    public void testSimple() {
        Concept bat = new Concept("bat");
        bat.can(new Action("fly"));
        bat.hasQuantity(new Concept("wing"), new Measure( "2"));
        bat.isLocatedAt(new Place("cave"));

        assertTrue(does(bat).hasPart("wing", new GreaterThan("1")));
        assertTrue(does(bat).hasPart("wing", new Equals("2")));
        assertTrue(does(bat).hasPart("wing", new LowerThan("3")));
        assertTrue(does(bat).isAt("cave"));
    }

    @Test
    public void testComposition() {
        Concept flying = new Concept("flying");
        flying.can(new Action("fly"));
        assertTrue(does(flying).can("fly"));

        Concept bat = new Concept("bat");
        bat.is(new Being(""));
        bat.is(flying);

        assertEquals(ConceptType.BEING, bat.getType());
        assertEquals("bat", bat.getName());
        assertTrue(does(bat).can("fly"));

        assertTrue(does(bat).is(flying));
    }

    @Test
    public void testIsMap() {
        Concept horse = new Concept("horse");
        Concept mammal = new Concept("mammal");
        Concept animal = new Concept("animal");
        Concept fish = new Concept("fish");

        horse.is(mammal);
        mammal.is(animal);
        fish.is(animal);
        animal.has("life", new Concept("life"));

        assertTrue(Inspector.does(horse).is(animal));
        assertTrue(Inspector.does(horse).has("life"));
        assertTrue(Inspector.does(fish).is(animal));
        assertTrue(Inspector.does(fish).has("life"));
    }

}
