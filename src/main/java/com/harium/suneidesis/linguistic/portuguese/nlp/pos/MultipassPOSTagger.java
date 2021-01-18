package com.harium.suneidesis.linguistic.portuguese.nlp.pos;

import com.harium.suneidesis.concept.word.WordVerb;
import com.harium.suneidesis.linguistic.nlp.pos.TagPair;
import com.harium.suneidesis.linguistic.storage.WordRepository;
import com.harium.suneidesis.concept.word.Word;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.harium.suneidesis.linguistic.nlp.pos.Tag.*;

/**
 * Multipass POSTagger with few words
 */
public class MultipassPOSTagger extends DatabasePOSTagger {

    public static final String PASSIVE_VOICE_PARTICLE = "foi";

    public MultipassPOSTagger(WordRepository database) {
        super(database);
    }

    @Override
    public TagPair[] posTag(String[] tokens) {
        TagPair[] output = initTagArray(tokens);

        handleFixedTags(output);
        handlePrepositions(output);
        handleDeterminers(output);
        turnUnknownIntoNouns(output);

        return output;
    }

    private void turnUnknownIntoNouns(TagPair[] output) {
        for (int i = 0; i < output.length; i++) {
            TagPair tagPair = output[i];
            if (tagPair.getTag() == UNKNOWN) {
                tagPair.setTag(NOUN);
            }
        }
    }

    private void handleDeterminers(TagPair[] output) {
        for (int i = 0; i < output.length; i++) {
            TagPair tagPair = output[i];
            if (tagPair.getTag() != UNKNOWN) {
                continue;
            }
            List<Word> words = database.findAllWords(tagPair.getWord());
            if (words == null) {
                continue;
            }

            if (words.stream().anyMatch(word -> DETERMINER.name().equals(word.getTag().getName()))) {
                tagPair.setTag(DETERMINER);
                // Verify next words (they could be adjective, numerals and so on)
                if (output.length > i + 1) {
                    TagPair next = output[i + 1];
                    next.setTag(NOUN);
                }
            }
        }
    }

    private void handlePrepositions(TagPair[] output) {
        for (int i = 0; i < output.length; i++) {
            TagPair tagPair = output[i];
            if (VERB == tagPair.getTag()) {
                List<Word> words = database.findAllWords(tagPair.getWord());

                WordVerb verb;
                for (Word w: words) {
                    if (isVerb(w.getTagWord())) {
                        verb = database.findVerbByWordId(w.getLemma().getId());

                        String[] prepositionsList = verb.getPrepositionsWord().split("\\|");
                        Set<String> prepositions = new HashSet<>(Arrays.asList(prepositionsList));

                        if (output.length > i + 1 && prepositions.contains(output[i + 1].getWord())) {
                            output[i + 1].setTag(PREPOSITION);
                        }
                        if (i > 0 && PASSIVE_VOICE_PARTICLE.equals(output[i - 1].getWord())) {
                            //Passive voice
                        }
                        return;
                    }
                }
            }
        }
    }

    private boolean isVerb(String tag) {
        if (tag == null) {
            return false;
        }
        return tag.startsWith("VERB");
    }

    private void handleFixedTags(TagPair[] output) {
        for (int i = 0; i < output.length; i++) {
            String word = output[i].getWord();
            List<Word> words = database.findAllWords(word);
            if (words == null) {
                continue;
            }
            if (words.stream().anyMatch(w -> PUNCTUATION.name().equals(w.getTagWord()))) {
                output[i].setTag(PUNCTUATION);
            } else if (words.stream().anyMatch(w -> VERB.name().equals(w.getTagWord()) || VERB_PAST_TENSE.name().equals(w.getTagWord()))) {
                output[i].setTag(VERB);
            }
        }

    }

}
