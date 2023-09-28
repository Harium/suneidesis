package com.harium.suneidesis.linguistic.nlp;

import com.harium.suneidesis.linguistic.nlp.pos.NLPMatcher;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class NLPMatcherTest {

    @Test
    public void testMatcher_SingleValue() {
        Token[] tags = buildTokens(new Tag[]{Tag.DETERMINER});
        assertTrue(NLPMatcher.match(tags, Tag.DETERMINER.name()+NLPMatcher.SEPARATOR));
    }

    @Test
    public void testMatcher_BasicTriple() {
        Token[] tags = buildTokens(new Tag[]{Tag.NOUN, Tag.VERB_CONJUGATION, Tag.ADJECTIVE});
        assertTrue(NLPMatcher.match(tags,new Tag[]{Tag.NOUN, Tag.VERB_CONJUGATION, Tag.ADJECTIVE}));
    }

    @Test
    public void testMatcher_TripleWithAnyTag() {
        Token[] tags = buildTokens(new Tag[]{Tag.NOUN, Tag.VERB_CONJUGATION, Tag.ADVERB, Tag.ADVERB, Tag.ADJECTIVE});
        assertTrue(NLPMatcher.match(tags,new Tag[]{Tag.NOUN, Tag.VERB_CONJUGATION, Tag.ANY, Tag.ADJECTIVE}));
    }

    private Token[] buildTokens(Tag[] tags) {
        List<Token> list = new ArrayList<>();

        for (Tag tag : tags) {
            list.add(new Token("", "", tag));
        }

        Token[] array = new Token[list.size()];
        list.toArray(array); // fill the array

        return array;
    }

}
