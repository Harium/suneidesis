package com.harium.suneidesis.linguistic.nlp.pos.converter;

import com.harium.suneidesis.linguistic.nlp.pos.Tag;

/**
 * SpaCy Universal Tag converter
 * https://github.com/explosion/spaCy/blob/master/spacy/glossary.py
 */
public class SpaCyUniversalTagConverter implements StringToTagConverter {

    @Override
    public Tag convert(String tag) {
        if ("ADJ".equals(tag)) {
            return Tag.ADJECTIVE;
        } else if ("ADP".equals(tag)) {
            //return Tag.ADPOSITION;
            return Tag.PREPOSITION;
        } else if ("ADV".equals(tag)) {
            return Tag.ADVERB;
        } else if ("AUX".equals(tag)) {
            return Tag.AUXILIARY;
        } else if ("CONJ".equals(tag)) {
            return Tag.CONJUCTION;
        } else if ("CCONJ".equals(tag)) {
            return Tag.COORDINATING_CONJUCTION;
        } else if ("DET".equals(tag)) {
            return Tag.DETERMINER;
        } else if ("INTJ".equals(tag)) {
            return Tag.INTERJECTION;
        } else if ("NOUN".equals(tag)) {
            return Tag.NOUN;
        } else if ("NUN".equals(tag)) {
            return Tag.NUMERAL;
        } else if ("PART".equals(tag)) {
            return Tag.PARTICLE;
        } else if ("PRON".equals(tag)) {
            return Tag.PRONOUN;
        } else if ("PROPN".equals(tag)) {
            return Tag.NOUN_PROPER;
        } else if ("SCONJ".equals(tag)) {
            return Tag.SUBORDINATING_CONJUCTION;
        } else if ("SYM".equals(tag)) {
            return Tag.SYMBOL;
        } else if ("VERB".equals(tag)) {
            return Tag.VERB;
        } else if ("PUNCT".equals(tag)) {
            return Tag.PUNCTUATION;
        } else if ("X".equals(tag)) {
            return Tag.UNKNOWN;
        } else if ("EOL".equals(tag)) {
            return Tag.UNKNOWN;
        } else if ("SPACE".equals(tag)) {
            return Tag.SPACE;
        }
        return Tag.UNKNOWN;
    }
}
