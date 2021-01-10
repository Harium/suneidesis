package com.harium.suneidesis.concept;

import com.harium.suneidesis.concept.beign.Gender;
import org.junit.Test;

public class ConceptTest {

    @Test
    public void testSimple() {
        Place forest = new Place("forest");
        Place village = new Place("village");
        village.has("near", forest);

        Place house = new Place("house");
        house.isLocatedAt(village);

        Concept redCloak = new Concept();
        Being littleGirl = new Being();
        littleGirl.setGender(Gender.FEMALE);
        littleGirl.set("wear", redCloak);
        littleGirl.set("lives", house);
    }

}
