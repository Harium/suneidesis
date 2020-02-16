package com.harium.suneidesis.knowledge.linguistic.portuguese.nlp;

import com.harium.suneidesis.knowledge.linguistic.core.nlp.tagger.POSTagger;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.tagger.POSTaggerReconstructor;
import com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.database.MemoryDatabase;
import com.harium.suneidesis.knowledge.linguistic.portuguese.nlp.database.WordDatabase;

import java.util.List;

import static com.harium.suneidesis.knowledge.linguistic.core.nlp.tagger.POSTaggerReconstructor.*;

/**
 * Simple POSTagger with few words
 * <p>
 * Good source: http://lxcenter.di.fc.ul.pt/tools/en/LXTaggerEN.html
 */
public class RuleBasedPOSTagger implements POSTagger {

    WordDatabase database = new MemoryDatabase();

    @Override
    public String[] posTag(String[] tokens) {
        String[] output = new String[tokens.length];

        boolean afterToBe = false;
        String lastToken = "NOUN";
        for (int i = 0; i < tokens.length; i++) {
            String word = tokens[i];
            List<String> tags = database.getTags(word);

            if (tags != null && !tags.isEmpty()) {
                if (tags.size() > 1) {
                    // TODO Disambiguation
                }
                lastToken = tags.get(0);
                output[i] = lastToken;
                /*if (VERB.equals(lastToken)) {
                    if (toBe.contains(word)) {
                        afterToBe = true;
                    } else {
                        afterToBe = false;
                    }
                }*/
            } else {
                if (Character.isUpperCase(word.charAt(0))) {
                    // Name
                    output[i] = POSTaggerReconstructor.NOUN;
                } else if (lastToken.equals(VERB)) {
                    // Preposition?
                    output[i] = ADJECTIVE;
                } else if (lastToken.equals(ADVERB)) {
                    output[i] = ADJECTIVE;
                } else if (lastToken.equals(COORDINATING_CONJUCTION) && i>2 && "e".equals(tokens[i - 1])) {
                    // Copy tag
                    output[i] = output[i - 2];
                } else if (guessVerb(word)) {
                    output[i] = VERB;
                } else {
                    output[i] = POSTaggerReconstructor.NOUN;
                }
            }
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
