package com.harium.suneidesis.knowledge.linguistic.portuguese.frame;

import com.harium.suneidesis.knowledge.linguistic.core.frame.*;

public class FrameReconstructor implements Reconstructor {

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
    }

}
