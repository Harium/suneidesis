package com.harium.suneidesis.linguistic.nlp.pos;

import com.harium.suneidesis.concept.word.Word;

/**
 * Tags borrowed from Penn Treebank/Nltk
 */
public enum Tag {
    CONJUCTION, // Generalization of Conjuctions
    COORDINATING_CONJUCTION,
    DETERMINER,
    EXISTENTIAL_THERE,
    FOREIGN_WORD,
    PREPOSITION,
    ADJECTIVE,
    ADJECTIVE_COMPARATIVE,
    ADJECTIVE_SUPERLATIVE,
    LIST_MARKER,
    MODAL,
    NOUN,
    NOUN_PLURAL,
    NOUN_PROPER,
    NOUN_PROPER_PLURAL,
    NUMERAL,// Cardinal Digit
    PREDETERMINER,
    POSSESSIVE,
    PRONOUN, // Generalization of Pronouns
    PERSONAL_PRONOUN,
    POSSESSIVE_PRONOUN,
    ADVERB,
    ADVERB_COMPARATIVE,
    ADVERB_SUPERLATIVE,
    PARTICLE,
    SYMBOL,
    CURRENCY,// Financial Symbol
    SUBORDINATING_CONJUCTION,
    TO,
    INTERJECTION,
    VERB,
    VERB_CONJUGATION,
    VERB_PAST_TENSE,
    VERB_GERUND,
    VERB_PAST_PARTICIPLE,
    VERB_PRESENT,
    VERB_PRESENT_THIRD_PERSON,
    WH_DETERMINER,
    WH_PRONOUN,
    WH_POSSESSIVE_PRONOUN,
    WH_ADVERB,
    PUNCTUATION,
    SHORT,
    UNKNOWN;
}
