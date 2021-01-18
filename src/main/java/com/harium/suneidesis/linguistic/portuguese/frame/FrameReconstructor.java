package com.harium.suneidesis.linguistic.portuguese.frame;

import com.harium.suneidesis.concept.Fact;
import com.harium.suneidesis.linguistic.fact.*;

public class FrameReconstructor implements Reconstructor {

    @Override
    public String reconstruct(Fact frame) {
        StringBuilder builder = new StringBuilder();

        /*if (frame.getSubject() != null) {
            builder.append(reconstructNoun(frame.getSubject()));
        }

        if (frame.getPredicate() != null) {
            builder.append(reconstructAction(frame.getPredicate()));
        }*/

        return builder.toString();
    }

    /*private String reconstructAction(Concept action) {
        StringBuilder builder = new StringBuilder();

        // Should not be null
        if (action.getAction() != null) {
            builder.append(action.getAction().getName());
        }

        if (action.getPreposition() != null) {
            builder.append(action.getPreposition().getName());
        }

        if (action.getTarget() != null) {
            builder.append(reconstructNoun(action.getTarget()));
        }

        return builder.toString();
    }

    private String reconstructNoun(Concept subject) {
        StringBuilder builder = new StringBuilder();

        if (subject.getNameConcept() != null) {
            builder.append(getDeterminer(subject.getNameConcept()));
            builder.append(subject.getName());
            builder.append(" ");
        }

        // Should not be null
        if (nounFrame.getNoun() != null) {
            builder.append(nounFrame.getNoun().getName());
        }

        if (nounFrame.getAdjectives() != null) {
            builder.append(" ");
            int count = 0;
            for (AdjectiveFrame adjective : nounFrame.getAdjectives()) {
                builder.append(reconstructAdjectiveFrame(adjective));

                if (count == nounFrame.getAdjectives().size()-2) {
                    builder.append(" e ");
                } else if (count < nounFrame.getAdjectives().size()-2) {
                    builder.append(", ");
                }
                count++;
            }
        }

        return builder.toString();
    }

    private String getDeterminer(Word concept) {
        if (concept.getGender()) {

        }
    }

    private String reconstructAdjectiveFrame(AdjectiveFrame adjective) {
        StringBuilder builder = new StringBuilder();

        if (adjective.getAdverb() != null) {
            builder.append(adjective.getAdverb().getName());
            builder.append(" ");
        }

        if (adjective.getAdjective() != null) {
            builder.append(adjective.getAdjective().getName());
        }

        return builder.toString();
    }*/

}
