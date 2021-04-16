package com.harium.suneidesis.linguistic.repository;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.word.*;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;

import static com.harium.suneidesis.concept.attribute.Attributes.ATTRIBUTE_NAME;

public class WordFactory {

    public static Word buildWord(Concept concept) {
        String tag = concept.get(Word.ATTRIBUTE_TAG).getName();
        String name = concept.get(ATTRIBUTE_NAME).getName();
        Word word = getWordByTag(tag, name);

        if (word == null) {
            return null;
        } else {
            word.getAttributes().merge(concept.getAttributes());
            return word;
        }
    }

    private static Word getWordByTag(String tag, String name) {
        Word word = null;
        if (Tag.ADJECTIVE.name().equals(tag)) {
            word = new WordAdjective(name);
        } else if (Tag.ADVERB.name().equals(tag)) {
            word = new WordAdverb(name);
        } else if (Tag.CONJUCTION.name().equals(tag) ||
                   Tag.COORDINATING_CONJUCTION.name().equals(tag) ||
                   Tag.SUBORDINATING_CONJUCTION.name().equals(tag)) {
            word = new WordConjunction(name);
        } else if (Tag.DETERMINER.name().equals(tag)) {
            word = new WordDeterminer(name);
        } else if (Tag.INTERJECTION.name().equals(tag)) {
            word = new WordInterjection(name);
        } else if (Tag.NOUN.name().equals(tag)) {
            word = new WordNoun(name);
        } else if (Tag.NUMERAL.name().equals(tag)) {
            word = new WordNumeral(name);
        } else if (Tag.PREPOSITION.name().equals(tag)) {
            word = new WordPreposition(name);
        } else if (Tag.PERSONAL_PRONOUN.name().equals(tag)) {
            word = new WordPronoun(name);
        } else if (Tag.PUNCTUATION.name().equals(tag)) {
            word = new WordPunctuation(name);
        } else if (Tag.VERB.name().equals(tag)) {
            word = new WordVerb(name);
        } else if (Tag.VERB_CONJUGATION.name().equals(tag)) {
            word = new WordVerbConjugation(name);
        }
        return word;
    }

}
