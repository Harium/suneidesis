package com.harium.suneidesis.linguistic.nlp.pos.converter;

import com.harium.suneidesis.linguistic.nlp.pos.Tag;

/**
 * Penn Treebank converter
 * Those tags are also used by NLTK
 * https://www.ling.upenn.edu/courses/Fall_2003/ling001/penn_treebank_pos.html
 */
public class PennTreebankTagConverter implements TagConverter {

    private static final String COORDINATING_CONJUCTION = "CC";
    private static final String CARDINAL_DIGIT = "CD";
    private static final String CURRENCY = "CUR";
    private static final String DETERMINER = "DT";
    private static final String EXISTENTIAL_THERE = "EX";
    private static final String FOREIGN_WORD = "FW";
    private static final String PREPOSITION = "IN";
    private static final String ADJECTIVE = "JJ";
    private static final String ADJECTIVE_COMPARATIVE = "JJR";
    private static final String ADJECTIVE_SUPERLATIVE = "JJS";
    private static final String LIST_MARKER = "LS";
    private static final String MODAL = "MD";
    private static final String NOUN = "NN";
    private static final String NOUN_PLURAL = "NNS";
    private static final String NOUN_PROPER = "NNP";
    private static final String NOUN_PROPER_PLURAL = "NNPS";
    private static final String PREDETERMINER = "PDT";
    private static final String POSSESSIVE = "POS";
    private static final String PERSONAL_PRONOUN = "PRP";
    private static final String POSSESSIVE_PRONOUN = "PRP$";
    private static final String ADVERB = "RB";
    private static final String ADVERB_COMPARATIVE = "RBR";
    private static final String ADVERB_SUPERLATIVE = "RBS";
    private static final String PARTICLE = "RP";
    private static final String SYMBOL = "SYM";
    private static final String TO = "TO";
    private static final String INTERJECTION = "UH";
    private static final String VERB = "VB";
    private static final String VERB_PAST_TENSE = "VBD";
    private static final String VERB_GERUND = "VBG";
    private static final String VERB_PAST_PARTICIPLE = "VBN";
    private static final String VERB_PRESENT = "VBP";
    private static final String VERB_PRESENT_THIRD_PERSON = "VBZ";
    private static final String WH_DETERMINER = "WDT";
    private static final String WH_PRONOUN = "WP";
    private static final String WH_POSSESSIVE_PRONOUN = "WP$";
    private static final String WH_ADVERB = "WRB";
    private static final String PUNCTUATION = "PUNC";
    private static final String UNKNOWN = "X";

    @Override
    public String convert(Tag tag) {
        switch (tag) {
            case COORDINATING_CONJUCTION:
                return COORDINATING_CONJUCTION;
            case NUMERAL:
                return CARDINAL_DIGIT;
            case DETERMINER:
                return DETERMINER;
            case EXISTENTIAL_THERE:
                return EXISTENTIAL_THERE;
            case FOREIGN_WORD:
                return FOREIGN_WORD;
            case SUBORDINATING_CONJUCTION:
            case PREPOSITION:
                return PREPOSITION;
            case ADJECTIVE:
                return ADJECTIVE;
            case ADJECTIVE_COMPARATIVE:
                return ADJECTIVE_COMPARATIVE;
            case ADJECTIVE_SUPERLATIVE:
                return ADJECTIVE_SUPERLATIVE;
            case LIST_MARKER:
                return LIST_MARKER;
            case MODAL:
                return MODAL;
            case NOUN:
                return NOUN;
            case NOUN_PLURAL:
                return NOUN_PLURAL;
            case NOUN_PROPER:
                return NOUN_PROPER;
            case NOUN_PROPER_PLURAL:
                return NOUN_PROPER_PLURAL;
            case PREDETERMINER:
                return PREDETERMINER;
            case POSSESSIVE:
                return POSSESSIVE;
            case PERSONAL_PRONOUN:
                return PERSONAL_PRONOUN;
            case POSSESSIVE_PRONOUN:
                return POSSESSIVE_PRONOUN;
            case ADVERB:
                return ADVERB;
            case ADVERB_COMPARATIVE:
                return ADVERB_COMPARATIVE;
            case ADVERB_SUPERLATIVE:
                return ADVERB_SUPERLATIVE;
            case PARTICLE:
                return PARTICLE;
            case SYMBOL:
                return SYMBOL;
            case CURRENCY:
                return CURRENCY;
            case TO:
                return TO;
            case INTERJECTION:
                return INTERJECTION;
            case VERB:
                return VERB;
            case VERB_PAST_TENSE:
                return VERB_PAST_TENSE;
            case VERB_GERUND:
                return VERB_GERUND;
            case VERB_PAST_PARTICIPLE:
                return VERB_PAST_PARTICIPLE;
            case VERB_PRESENT:
                return VERB_PRESENT;
            case VERB_PRESENT_THIRD_PERSON:
                return VERB_PRESENT_THIRD_PERSON;
            case WH_DETERMINER:
                return WH_DETERMINER;
            case WH_PRONOUN:
                return WH_PRONOUN;
            case WH_POSSESSIVE_PRONOUN:
                return WH_POSSESSIVE_PRONOUN;
            case WH_ADVERB:
                return WH_ADVERB;
            case PUNCTUATION:
                return PUNCTUATION;
            case UNKNOWN:
            default:
                return UNKNOWN;
        }
    }

}
