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

        Being mother = new Being();
        mother.setGender(Gender.FEMALE);

        Concept redCloak = new Concept();
        Being littleGirl = new Being();
        littleGirl.setGender(Gender.FEMALE);
        littleGirl.set("mother", mother);
        littleGirl.set("wear", redCloak);
        littleGirl.set("lives", house);

        Event wasAtHome = new Event().subject(littleGirl).action(new Action("was")).object(house);
        Event momAskedFavor = new Event().subject(mother).action(new Action("asked a favor")).object(littleGirl);
        Event challengeAccepted = new Event().subject(littleGirl).action(new Action("hold")).object(new Concept("basket"));

        Story story = new Story("Red Riding Hood");
        story.author("Charles Perrault")
             .title("Little Red Riding Hood")
             .storyType(Story.TYPE_FICTIONAL)
             .begin(wasAtHome.then(momAskedFavor.then(challengeAccepted)));
    }

}
