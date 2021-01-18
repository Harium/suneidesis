package com.harium.suneidesis.inspector;

import com.harium.suneidesis.concept.Action;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.beign.Taxonomy;
import com.harium.suneidesis.concept.word.WordNoun;
import org.junit.Test;

import static com.harium.suneidesis.inspector.Inspector.does;
import static org.junit.Assert.*;

public class InspectorTest {

    @Test
    public void testIs() {
        Taxonomy animalia = new Taxonomy().kingdom(new Concept("animalia"));

        Concept animal = new Concept();
        animal.has(Taxonomy.ATTRIBUTE_TAXONOMY, animalia);

        Concept dog = new Concept();
        dog.is(animal);

        assertTrue(does(dog).is(animal));
        assertFalse(does(dog).can(new Action("fly")));
    }

    @Test
    public void testInstance() {
        Taxonomy animalia = new Taxonomy().kingdom(new Concept("animalia"));

        Concept animal = new Concept();
        animal.has(Taxonomy.ATTRIBUTE_TAXONOMY, animalia);

        Concept dog = new Concept();
        dog.is(animal);
        dog.can(new Action("walk"));

        Concept billy = new Concept();
        billy.is(dog);
        billy.has("nickname", new WordNoun("Bill"));

        assertTrue(does(billy).is(dog));
        assertEquals("Bill", billy.get("nickname").getName());
    }

}
