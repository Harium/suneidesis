package com.harium.suneidesis.concept.attribute;

import com.harium.suneidesis.concept.*;
import com.harium.suneidesis.inspector.matchers.Equals;
import com.harium.suneidesis.inspector.matchers.GreaterThan;
import com.harium.suneidesis.inspector.matchers.LowerThan;
import com.harium.suneidesis.concept.numeral.Quantity;
import org.junit.Test;

import static com.harium.suneidesis.inspector.Inspector.does;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AttributesTest {

    @Test
    public void testSimple() {
        Concept bat = new Concept("bat");
        bat.can(new Action("fly"));
        bat.hasQuantity(new Concept("wing"), new Quantity( "2"));
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

}
