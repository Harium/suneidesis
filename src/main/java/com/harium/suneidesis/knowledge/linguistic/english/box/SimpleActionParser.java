package com.harium.suneidesis.knowledge.linguistic.english.box;

import com.harium.suneidesis.instance.Instance;
import com.harium.suneidesis.knowledge.concept.Place;
import com.harium.suneidesis.knowledge.linguistic.core.action.ActionParser;
import com.harium.suneidesis.knowledge.fact.Fact;
import com.harium.suneidesis.knowledge.fact.frame.FrameType;
import com.harium.suneidesis.knowledge.fact.frame.FullFrame;
import com.harium.suneidesis.output.Output;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SimpleActionParser implements ActionParser {

    public static final String DID = "did";

    @Override
    public boolean matches(String query) {
        String[] parts = query.split(" ");
        return BaseEnglishBox.checkAction(parts[0], DID);
    }

    @Override
    public void parse(String query, Instance beign, Output output) {

        String[] parts = query.split(" ");

        String querySubject = "";

        for (int i = 0; i < parts.length; i++) {

            if (parts[i].equalsIgnoreCase("about")) {

                querySubject = parts[i + 1];
                break;
            }
        }

        if (!querySubject.isEmpty()) {

            Collection<Fact> actions = beign.getMemories().getAll();

            Fact action = null;

            if (!Character.isUpperCase(querySubject.charAt(0))) {
                action = findActionByName(querySubject, actions);
            } else {
                action = findActionByActorsName(querySubject, actions);
            }

            if (action != null) {
                output.print(describeAction(action));
            } else if (querySubject.endsWith("s")) {
                action = findActionByActorsName(querySubject.substring(0, querySubject.length() - 1), actions);
                if (action != null) {
                    output.print(describeAction(action));
                }
            }
        }

        output.print("No.");
    }

    private Fact findActionByActorsName(String actorName, Collection<Fact> actions) {

        String name = actorName.toLowerCase();

        for (Fact action : actions) {
            if (action.getFrameType() != FrameType.FULL_FRAME) {
                continue;
            }

            FullFrame frame = (FullFrame) action;

            boolean hasActor = frame.getActor().getName().toLowerCase().contains(name);

            boolean hasTarget = frame.getTarget() != null && frame.getTarget().getName().toLowerCase().contains(name);

            if (hasActor || hasTarget)

                return action;


        }

        return null;
    }

    private Fact findActionByName(String actionName, Collection<Fact> actions) {

        for (Fact action : actions) {
            if (action.getFrameType() != FrameType.FULL_FRAME) {
                continue;
            }

            FullFrame frame = (FullFrame) action;
            if (frame.getAction() == null) {
                continue;
            }
            if (actionName.equalsIgnoreCase(frame.getAction().getName())) {
                return action;
            }
        }

        return null;
    }

    public String describeAction(Fact action) {
        StringBuilder builder = new StringBuilder();

        switch (action.getFrameType()) {
            case FULL_FRAME:
                FullFrame frame = (FullFrame) action;

                // Change Based on source
                builder.append("I heard that");

                builder.append(" ");
                builder.append(frame.getActor().getName());
                builder.append(" ");

                String actionAsText = frame.getAction().getName().toLowerCase();
                builder.append(actionAsText);
                if (!actionAsText.endsWith("s")) {
                    builder.append("s");
                }

                if (frame.getTarget() != null) {
                    builder.append(" ");
                    builder.append(frame.getTarget().getName());

                    if (frame.getWhereInTarget() != null) {

                        if (!frame.getWhereInTarget().getName().isEmpty()) {
                            builder.append("'s ");
                            builder.append(frame.getWhereInTarget().getName());
                        }
                    }
                }

                if (frame.getPlace() != null) {
                    builder.append(" ");
                    builder.append(getPlace(frame.getPlace()));
                }

                if (frame.getWhen() != null) {
                    builder.append(", ");
                    builder.append(frame.getWhen().getName());
                }
                break;
            default:
                break;

        }

        return builder.toString();
    }

    private String getPlace(Place place) {

        String placeSentence = place.getName();

        if (place.getPlace() != null) {

            placeSentence += " ";

            placeSentence += getPlace(place.getPlace());
        }

        return placeSentence;
    }

}
