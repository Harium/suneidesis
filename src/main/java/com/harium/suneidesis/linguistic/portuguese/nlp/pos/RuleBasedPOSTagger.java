package com.harium.suneidesis.linguistic.portuguese.nlp.pos;

import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.linguistic.nlp.pos.TagPair;
import com.harium.suneidesis.repository.word.WordKnowledgeBase;
import com.harium.suneidesis.concept.word.Word;

import java.util.Iterator;

/**
 * Simple POSTagger with few words
 * <p>
 * Good source: http://lxcenter.di.fc.ul.pt/tools/en/LXTaggerEN.html
 */
public class RuleBasedPOSTagger extends DatabasePOSTagger {

    public static String VERB_TO_BE = "ser";

    public RuleBasedPOSTagger(WordKnowledgeBase database) {
        super(database);
    }

    @Override
    public TagPair[] posTag(String[] tokens) {
        TagPair[] output = new TagPair[tokens.length];

        Tag lastTag = Tag.NOUN;
        for (int i = 0; i < tokens.length; i++) {
            String word = tokens[i];
            output[i] = new TagPair(word, Tag.UNKNOWN);
            Iterator<Word> words = database.getWords(word);

            if (!words.hasNext()) {
                if (words.hasNext()) {
                    // TODO Disambiguation
                }
                lastTag = Tag.valueOf(words.next().getTag());
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
                        Iterator<Word> ws = database.getWords(word);
                        while (ws.hasNext()) {
                            Word wv = ws.next();
                            if (isVerb(wv.getTag())) {
                                String toBeVerbId = verbWordId(VERB_TO_BE);
                                if (toBeVerbId != null && toBeVerbId.equals(wv.getLemmaConcept().getId())) {
                                    output[i].setTag(Tag.ADJECTIVE);
                                }
                            }
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

    private String verbWordId(String verbWord) {
        Iterator<Word> words = database.getWords(verbWord);
        if (!words.hasNext()) {
            return null;
        }
        return words.next().getWordId();
    }

    private boolean isVerb(String tag) {
        if (tag == null) {
            return false;
        }
        return tag.startsWith("VERB");
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
