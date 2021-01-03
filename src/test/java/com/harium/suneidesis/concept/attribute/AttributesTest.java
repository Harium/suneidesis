package com.harium.suneidesis.concept.attribute;

import com.harium.suneidesis.concept.Action;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Place;
import com.harium.suneidesis.concept.inspector.matchers.Equals;
import com.harium.suneidesis.concept.inspector.matchers.GreaterThan;
import com.harium.suneidesis.concept.inspector.matchers.LowerThan;
import com.harium.suneidesis.concept.numeral.Numeral;
import org.junit.Test;

import static com.harium.suneidesis.concept.inspector.Inspector.does;
import static org.junit.Assert.assertTrue;

public class AttributesTest {

    @Test
    public void testSimple() {
        Concept bat = new Concept("bat");
        bat.can(new Action("fly"));
        bat.has(new Concept("wing"), new Numeral("two", "2"));
        bat.isLocatedAt(new Place("cave"));

        assertTrue(does(bat).can("fly"));
        assertTrue(does(bat).has("wing", new GreaterThan(1)));
        assertTrue(does(bat).has("wing", new Equals(2)));
        assertTrue(does(bat).has("wing", new LowerThan(3)));
        assertTrue(does(bat).isAt("cave"));
    }

}
