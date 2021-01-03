package com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.pos;

import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.Tag;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.TagPair;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.database.WordDatabase;
import com.harium.suneidesis.concept.word.Word;

import java.util.List;

/**
 * Simple POSTagger with few words
 * <p>
 * Good source: http://lxcenter.di.fc.ul.pt/tools/en/LXTaggerEN.html
 */
public class RuleBasedPOSTagger extends DatabasePOSTagger {

    public static String VERB_TO_BE = "ser";

    public RuleBasedPOSTagger() {
        super();
    }

    public RuleBasedPOSTagger(WordDatabase database) {
        super(database);
    }

    @Override
    public TagPair[] posTag(String[] tokens) {
        TagPair[] output = new TagPair[tokens.length];

        Tag lastTag = Tag.NOUN;
        for (int i = 0; i < tokens.length; i++) {
            String word = tokens[i];
            output[i] = new TagPair(word, Tag.UNKNOWN);
            List<Word> words = database.findAllWords(word);

            if (words != null && !words.isEmpty()) {
                if (words.size() > 1) {
                    // TODO Disambiguation
                }
                lastTag = Tag.valueOf(words.get(0).getTagWord());
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
                        List<Word> ws = database.findAllWords(tokens[i - 1]);
                        for (Word wv : ws) {
                            if (isVerb(wv.getTagWord())) {
                                String toBeVerbId = verbWordId(VERB_TO_BE);
                                if (toBeVerbId != null && toBeVerbId.equals(wv.getLemma().getId())) {
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
        List<Word> words = database.findAllWords(verbWord);
        if (words == null || words.isEmpty()) {
            return null;
        }
        return words.get(0).getId();
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
