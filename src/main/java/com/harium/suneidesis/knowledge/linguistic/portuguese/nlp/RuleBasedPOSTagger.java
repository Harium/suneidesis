package com.harium.suneidesis.knowledge.linguistic.portuguese.nlp;

import com.harium.suneidesis.knowledge.linguistic.core.nlp.tagger.POSTagger;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.tagger.POSTaggerReconstructor;
import com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.database.MemoryDatabase;
import com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.database.Verb;
import com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.database.WordDatabase;

import java.util.List;

import static com.harium.suneidesis.knowledge.linguistic.core.nlp.tagger.POSTaggerReconstructor.*;

/**
 * Simple POSTagger with few words
 * <p>
 * Good source: http://lxcenter.di.fc.ul.pt/tools/en/LXTaggerEN.html
 */
public class RuleBasedPOSTagger implements POSTagger {

    public static final String VERB_TO_BE = "ser";
    WordDatabase database = new MemoryDatabase();

    @Override
    public String[] posTag(String[] tokens) {
        String[] output = new String[tokens.length];

        String lastToken = NOUN;
        for (int i = 0; i < tokens.length; i++) {
            String word = tokens[i];
            List<String> tags = database.getTags(word);

            if (tags != null && !tags.isEmpty()) {
                if (tags.size() > 1) {
                    // TODO Disambiguation
                }
                lastToken = tags.get(0);
                output[i] = lastToken;
            } else {
                if (Character.isUpperCase(word.charAt(0))) {
                    // Name
                    output[i] = POSTaggerReconstructor.NOUN;
                } else if (lastToken.equals(ADVERB)) {
                    output[i] = ADJECTIVE;
                } else if (guessVerb(word)) {
                    output[i] = VERB;
                } else {
                    output[i] = POSTaggerReconstructor.NOUN;

                    if (lastToken.equals(VERB)) {
                        Verb verb = database.getVerb(tokens[i - 1]);
                        if (VERB_TO_BE.equals(verb.getLemma())) {
                            output[i] = ADJECTIVE;
                        }
                    }
                    if (output.length > 2) {
                        if (lastToken.equals(COORDINATING_CONJUCTION)) {
                            // Copy tag
                            output[i] = output[i - 2];
                        }
                        if (lastToken.equals(NOUN) && DETERMINER.equals(output[i - 2])) {
                            output[i - 1] = ADJECTIVE;
                        }
                    }
                }
            }
            lastToken = output[i];
        }

        return output;
    }

    private boolean guessVerb(String word) {
        if (word.endsWith("ar") || word.endsWith("er") || word.endsWith("ir")) {
            return true;
        }

        if (!word.endsWith("rão")) {

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
