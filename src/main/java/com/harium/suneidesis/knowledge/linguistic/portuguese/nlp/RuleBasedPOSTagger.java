package com.harium.suneidesis.knowledge.linguistic.portuguese.nlp;

import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.POSTagger;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.Tag;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.TagPair;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model.Verb;
import com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.database.MemoryDatabase;
import com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.database.WordDatabase;

import java.util.List;

/**
 * Simple POSTagger with few words
 * <p>
 * Good source: http://lxcenter.di.fc.ul.pt/tools/en/LXTaggerEN.html
 */
public class RuleBasedPOSTagger implements POSTagger {

    WordDatabase database = new MemoryDatabase();
    public static String VERB_TO_BE = "ser";

    @Override
    public TagPair[] posTag(String[] tokens) {
        TagPair[] output = new TagPair[tokens.length];

        Tag lastTag = Tag.NOUN;
        for (int i = 0; i < tokens.length; i++) {
            String word = tokens[i];
            output[i] = new TagPair(word, Tag.UNKNOWN);
            List<Tag> tags = database.getTags(word);

            if (tags != null && !tags.isEmpty()) {
                if (tags.size() > 1) {
                    // TODO Disambiguation
                }
                lastTag = tags.get(0);
                output[i].setTag(lastTag);
            } else {
                if (Character.isUpperCase(word.charAt(0))) {
                    // Name
                    output[i].setTag(Tag.NOUN);
                } else if (lastTag.equals(Tag.ADVERB)) {
                    output[i].setTag(Tag.ADJECTIVE);
                } else if (guessVerb(word)) {
                    output[i].setTag(Tag.VERB);
                } else {
                    output[i].setTag(Tag.NOUN);

                    if (lastTag.equals(Tag.VERB)) {
                        Verb verb = database.getVerb(tokens[i - 1]);
                        if (database.getId(VERB_TO_BE) == verb.getWordId()) {
                            output[i].setTag(Tag.ADJECTIVE);
                        }
                    }
                    if (output.length > 2) {
                        if (lastTag.equals(Tag.COORDINATING_CONJUCTION)) {
                            // Copy tag
                            output[i] = output[i - 2];
                        }
                        if (lastTag.equals(Tag.NOUN) && Tag.DETERMINER.equals(output[i - 2].getTag())) {
                            output[i - 1].setTag(Tag.ADJECTIVE);
                        }
                    }
                }
            }
            lastTag = output[i].getTag();
        }

        return output;
    }

    private boolean guessVerb(String word) {
        if (word.endsWith("ar") || word.endsWith("er") || word.endsWith("ir")) {
            return true;
        }

        // Regular verbs
        if (word.endsWith("ai")
                || word.endsWith("am")
                || word.endsWith("amos")
                || word.endsWith("eis")
                || word.endsWith("rão")
                // Nasce
                || word.endsWith("sce")
                // Produz
                || word.endsWith("duz")) {
            return true;
        }

        return false;
    }

}
