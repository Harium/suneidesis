package com.harium.suneidesis.linguistic.nlp;

import com.harium.suneidesis.linguistic.nlp.pos.NLPMatcher;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.linguistic.nlp.pos.TagPair;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class NLPMatcherTest {

    @Test
    public void testMatcher_SingleValue() {
        TagPair[] tags = buildTagPair(new String[]{Tag.DETERMINER.name()});
        assertTrue(NLPMatcher.match(tags, Tag.DETERMINER.name()+NLPMatcher.SEPARATOR));
    }

    @Test
    public void testMatcher_BasicTriple() {
        TagPair[] tags = buildTagPair(new String[]{Tag.NOUN.name(), Tag.VERB_CONJUGATION.name(), Tag.ADJECTIVE.name()});
        assertTrue(NLPMatcher.match(tags,new Tag[]{Tag.NOUN, Tag.VERB_CONJUGATION, Tag.ADJECTIVE}));
    }

    @Test
    public void testMatcher_TripleWithAnyTag() {
        TagPair[] tags = buildTagPair(new String[]{Tag.NOUN.name(), Tag.VERB_CONJUGATION.name(), Tag.ADVERB.name(), Tag.ADVERB.name(), Tag.ADJECTIVE.name()});
        assertTrue(NLPMatcher.match(tags,new Tag[]{Tag.NOUN, Tag.VERB_CONJUGATION, Tag.ANY, Tag.ADJECTIVE}));
    }

    private TagPair[] buildTagPair(String[] tags) {
        List<TagPair> list = new ArrayList<>();

        for (String tag : tags) {
            list.add(buildTagPair(tag, ""));
        }

        TagPair[] array = new TagPair[list.size()];
        list.toArray(array); // fill the array

        return array;
    }

    private TagPair buildTagPair(String tag) {
        return buildTagPair(tag, "");
    }

    private TagPair buildTagPair(String tag, String word) {
        return new TagPair(word, Tag.valueOf(tag));
    }

}
