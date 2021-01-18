package com.harium.suneidesis.linguistic.nlp.pos;

import com.harium.suneidesis.concept.Fact;
import com.harium.suneidesis.linguistic.fact.Reconstructor;
import com.harium.suneidesis.linguistic.nlp.pos.converter.PennTreebankTagConverter;
import com.harium.suneidesis.linguistic.nlp.pos.converter.TagConverter;

public class POSTaggerReconstructor implements Reconstructor {

    private TagConverter tagger;

    public POSTaggerReconstructor() {
        this(new PennTreebankTagConverter());
    }

    public POSTaggerReconstructor(TagConverter tagger) {
        this.tagger = tagger;
    }

    @Override
    public String reconstruct(Fact frame) {
        StringBuilder builder = new StringBuilder();

        /*if (frame.getSubject() != null) {
            builder.append(reconstructNounFrame(frame.getSubject()));
        }

        if (frame.getPredicate() != null) {
            builder.append(reconstructActionFrame(frame.getPredicate()));
        }*/

        return builder.toString();
    }

    /*private String reconstructActionFrame(Concept action) {
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

    private String reconstructNounFrame(Concept nounFrame) {
        StringBuilder builder = new StringBuilder();

        if (nounFrame.getDeterminer() != null) {
            builder.append(nounFrame.getDeterminer().getName());
            builder.append("/");
            builder.append(tagger.convert(DETERMINER));
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
            builder.append(tagger.convert(NOUN));
        }

        return builder.toString();
    }

    private String reconstructAdjectiveFrame(AdjectiveFrame adjective) {
        StringBuilder builder = new StringBuilder();

        if (adjective.getAdverb() != null) {
            builder.append(adjective.getAdverb().getName());
            builder.append("/");
            builder.append(tagger.convert(ADVERB));
            builder.append(" ");
        }

        if (adjective.getAdjective() != null) {
            builder.append(adjective.getAdjective().getName());
            builder.append("/");
            builder.append(tagger.convert(ADJECTIVE));
        }

        return builder.toString();
    }*/

}
