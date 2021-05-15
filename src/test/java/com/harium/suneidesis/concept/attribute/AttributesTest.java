package com.harium.suneidesis.concept.attribute;

import com.harium.suneidesis.concept.*;
import com.harium.suneidesis.concept.inspector.Inspector;
import com.harium.suneidesis.concept.inspector.matchers.Equals;
import com.harium.suneidesis.concept.inspector.matchers.GreaterThan;
import com.harium.suneidesis.concept.inspector.matchers.LowerThan;
import com.harium.suneidesis.concept.Measurement;
import org.junit.Test;

import static com.harium.suneidesis.concept.inspector.Inspector.does;
import static org.junit.Assert.*;

public class AttributesTest {

    @Test
    public void testSimple() {
        Concept bat = new Concept("bat");
        bat.can(new Action("fly"));
        bat.hasQuantity(new Concept("wing"), new Measurement("2"));
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
    public void testInheritance() {
        Concept horse = new Concept("horse");
        Concept mammal = new Concept("mammal");
        Concept animal = new Concept("animal");
        Concept fish = new Concept("fish");

        Concept life = new Concept("life");
        animal.has("life", life);
        mammal.has("life", life);

        horse.is(mammal);
        mammal.is(animal);
        fish.is(animal);

        assertTrue(Inspector.does(horse).is(animal));
        assertTrue(Inspector.does(horse).has("life"));
        assertTrue(Inspector.does(fish).is(animal));
        assertTrue(Inspector.does(fish).has("life"));

        // Verify if optimization removed life from map
        assertFalse(mammal.getAttributes().getAll().containsKey("life"));
    }

    @Test
    public void testInheritanceMapOverwrite() {
        Concept horse = new Concept("horse");
        Concept mammal = new Concept("mammal");
        Concept animal = new Concept("animal");

        Concept unicorn = new Concept("unicorn");

        unicorn.is(horse);
        horse.is(mammal);
        mammal.is(animal);

        horse.hasNoQuantity("horn");
        unicorn.hasQuantity("horn", new Measurement("1"));

        assertTrue(Inspector.does(horse).is(animal));
        assertTrue(Inspector.does(horse).hasPart("horn", new Equals("0")));
        assertTrue(Inspector.does(unicorn).hasPart("horn", new GreaterThan("0")));
    }

    @Test
    public void testInheritanceHasKey() {
        Concept waterTank = new Concept("water tank");
        Concept tank = new Concept("tank");
        tank.set("content", new Concept("content"));

        waterTank.is(tank);

        assertTrue(Inspector.does(waterTank).has("content"));
    }

}
