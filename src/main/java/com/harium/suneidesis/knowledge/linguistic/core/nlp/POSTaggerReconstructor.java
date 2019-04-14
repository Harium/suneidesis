package com.harium.suneidesis.knowledge.linguistic.core.nlp;

import com.harium.suneidesis.knowledge.linguistic.core.frame.*;

public class POSTaggerReconstructor implements Reconstructor {

    public static final String COORDINATING_CONJUCTION = "CC";
    public static final String CARDINAL_DIGIT = "CD";
    public static final String DETERMINER = "DT";
    public static final String EXISTENTIAL_THERE = "EX";
    public static final String FOREIGN_WORD = "FW";
    public static final String PREPOSITION = "IN";
    public static final String ADJECTIVE = "JJ";
    public static final String ADJECTIVE_COMPARATIVE = "JJR";
    public static final String ADJECTIVE_SUPERLATIVE = "JJS";
    public static final String LIST_MARKER = "LS";
    public static final String MODAL = "MD";
    public static final String NOUN = "NN";
    public static final String NOUN_PLURAL = "NNS";
    public static final String NOUN_PROPER = "NNP";
    public static final String NOUN_PROPER_PLURAL = "NNPS";
    public static final String PREDETERMINER = "PDT";
    public static final String POSSESSIVE = "POS";
    public static final String PERSONAL_PRONOUN = "PRP";
    public static final String POSSESSIVE_PRONOUN = "PRP$";
    public static final String ADVERB = "RB";
    public static final String ADVERB_COMPARATIVE = "RBR";
    public static final String ADVERB_SUPERLATIVE = "RBS";
    public static final String PARTICLE = "RP";
    public static final String TO = "TO";
    public static final String INTERJECTION = "UH";
    public static final String VERB = "VB";
    public static final String VERB_PAST_TENSE = "VBD";
    public static final String VERB_GERUND = "VBG";
    public static final String VERB_PAST_PARTICIPLE = "VBN";
    public static final String VERB_PRESENT = "VBP";
    public static final String VERB_PRESENT_THIRD_PERSON = "VBZ";
    public static final String WH_DETERMINER = "WDT";
    public static final String WH_PRONOUN = "WP";
    public static final String WH_POSSESSIVE_PRONOUN = "WP$";
    public static final String WH_ADVERB = "WRB";

    @Override
    public String reconstruct(BaseFrame frame) {
        StringBuilder builder = new StringBuilder();

        if (frame.getNoun() != null) {
            builder.append(reconstructNounFrame(frame.getNoun()));
        }

        if (frame.getAction() != null) {
            builder.append(reconstructActionFrame(frame.getAction()));
        }

        return builder.toString();
    }

    private String reconstructActionFrame(ActionFrame action) {
        StringBuilder builder = new StringBuilder();

        // Should not be null
        if (action.getAction() != null) {
            builder.append(action.getAction().getName());
        }

        if (action.getPreposition() != null) {
            builder.append(action.getPreposition().getName());
        }

        if (action.getTarget() != null) {
            builder.append(reconstructNounFrame(action.getTarget()));
        }

        return builder.toString();
    }

    private String reconstructNounFrame(NounFrame nounFrame) {
        StringBuilder builder = new StringBuilder();

        if (nounFrame.getDeterminer() != null) {
            builder.append(nounFrame.getDeterminer().getName());
            builder.append("/");
            builder.append(DETERMINER);
            builder.append(" ");
        }

        if (nounFrame.getAdjectives() != null) {
            for (AdjectiveFrame adjective : nounFrame.getAdjectives()) {
                builder.append(reconstructAdjectiveFrame(adjective));
                builder.append(" ");
            }
        }

        // Should not be null
        if (nounFrame.getNoun() != null) {
            builder.append(nounFrame.getNoun().getName());
            builder.append("/");
            builder.append(NOUN);
        }

        return builder.toString();
    }

    private String reconstructAdjectiveFrame(AdjectiveFrame adjective) {
        StringBuilder builder = new StringBuilder();

        if (adjective.getAdverb() != null) {
            builder.append(adjective.getAdverb().getName());
            builder.append("/");
            builder.append(ADVERB);
            builder.append(" ");
        }

        if (adjective.getAdjective() != null) {
            builder.append(adjective.getAdjective().getName());
            builder.append("/");
            builder.append(ADJECTIVE);
        }

        return builder.toString();
    }

}
