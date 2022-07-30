package com.harium.suneidesis.concept;

import com.harium.suneidesis.concept.beign.Gender;
import com.harium.suneidesis.concept.measurement.Measurement;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ConceptTest {

    @Test
    public void testSimple() {
        Place forest = new Place("forest");
        Place village = new Place("village");
        village.has("near", forest);

        Place house = new Place("house");
        house.isLocatedAt(village);

        Being mother = new Being("mother");
        mother.setGender(Gender.FEMALE);

        Concept redCloak = new Concept("red cloak");
        Being littleGirl = new Being("little girl");
        littleGirl.setGender(Gender.FEMALE);
        littleGirl.set("mother", mother);
        littleGirl.set("wear", redCloak);
        littleGirl.set("lives", house);

        Event wasAtHome = new Event("at home").subject(littleGirl).action(new Action("was")).object(house);
        Event momAskedFavor = new Event("mom asked").subject(mother).action(new Action("asked a favor")).object(littleGirl);
        Event challengeAccepted = new Event("accepted").subject(littleGirl).action(new Action("hold")).object(new Concept("basket"));

        Story story = new Story("Red Riding Hood");
        story.author("Charles Perrault")
                .title("Little Red Riding Hood")
                .storyType(Story.TYPE_FICTIONAL)
                .begin(wasAtHome.then(momAskedFavor.then(challengeAccepted)));
    }

    @Test
    public void testIsUnknown() {
        Concept concept = new Concept(ConceptType.UNKNOWN_TYPE);
        assertTrue(concept.isUnknown());
    }

    @Test
    public void testSecret() {
        Concept animalThing = new Concept("meow");

        Concept hasToHavePaw = new Concept("requirements");
        hasToHavePaw.hasQuantity("paw", new Measurement().value("four"));
        animalThing.secretRequirements(hasToHavePaw);

        Concept cat = new Concept("cat");
        cat.hasQuantity("paw", new Measurement().value("four"));

        Concept requester = new Concept("Requester");
        requester.hasQuantity("leg", new Measurement().value("two"));
        requester.hasQuantity("arm", new Measurement().value("two"));

        assertTrue(animalThing.isSecret(requester));
        assertFalse(animalThing.isSecret(cat));
    }

}
