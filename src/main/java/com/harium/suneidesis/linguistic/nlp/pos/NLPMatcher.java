package com.harium.suneidesis.linguistic.nlp.pos;

import com.harium.suneidesis.linguistic.nlp.Token;

public class NLPMatcher {

    public static final String SEPARATOR = ",";

    public static boolean match(Token[] tokens, String tagsRegex) {
        StringBuilder currentTags = new StringBuilder();

        for (Token token : tokens) {
            currentTags.append(token.tag);
            currentTags.append(SEPARATOR);
        }

        return currentTags.toString().matches(tagsRegex);
    }

    public static boolean match(Token[] tokens, String[] tagsRegex) {
        StringBuilder matcher = new StringBuilder();
        for (String s : tagsRegex) {
            matcher.append(s);
            matcher.append(SEPARATOR);
        }

        return match(tokens, matcher.toString());
    }

    public static boolean match(Token[] tagPairs, Tag[] tags) {
        if (tagPairs.length < tags.length) {
            return false;
        }

        int currentTagIndex = 0;
        for (int i = 0; i < tags.length; i++) {
            Tag tag = tags[i];
            Tag currentTag = tagPairs[currentTagIndex].tag;

            if (tag.equals(currentTag)) {
                currentTagIndex++;
            } else if (tag.equals(Tag.ANY) && i + 1 < tags.length) {
                Tag nextTag = tags[i + 1];
                for (int j = currentTagIndex; j <= tagPairs.length - i; j++) {
                    if (!nextTag.equals(currentTag)) {
                        currentTagIndex++;
                    }
                    currentTag = tagPairs[j].tag;
                }
            } else {
                return false;
            }
        }

        return true;
    }

}
