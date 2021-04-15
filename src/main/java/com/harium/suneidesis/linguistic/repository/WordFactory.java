package com.harium.suneidesis.linguistic.repository;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.word.*;

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
        if (Word.TAG_ADJECTIVE.equals(tag)) {
            word = new WordAdjective(name);
        } else if (Word.TAG_ADVERB.equals(tag)) {
            word = new WordAdverb(name);
        } else if (Word.TAG_CONJUNCTION.equals(tag)) {
            word = new WordConjunction(name);
        } else if (Word.TAG_DETERMINER.equals(tag)) {
            word = new WordDeterminer(name);
        } else if (Word.TAG_INTERJECTION.equals(tag)) {
            word = new WordInterjection(name);
        } else if (Word.TAG_NOUN.equals(tag)) {
            word = new WordNoun(name);
        } else if (Word.TAG_NUMERAL.equals(tag)) {
            word = new WordNumeral(name);
        } else if (Word.TAG_PREPOSITION.equals(tag)) {
            word = new WordPreposition(name);
        } else if (Word.TAG_PRONOUN.equals(tag)) {
            word = new WordPronoun(name);
        } else if (Word.TAG_PUNCTUATION.equals(tag)) {
            word = new WordPunctuation(name);
        } else if (Word.TAG_VERB.equals(tag)) {
            word = new WordVerb(name);
        } else if (Word.TAG_VERB_CONJUGATION.equals(tag)) {
            word = new WordVerbConjugation(name);
        }
        return word;
    }

}
