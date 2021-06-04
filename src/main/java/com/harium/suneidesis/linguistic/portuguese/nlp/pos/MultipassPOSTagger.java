package com.harium.suneidesis.linguistic.portuguese.nlp.pos;

import com.harium.suneidesis.concept.word.WordVerb;
import com.harium.suneidesis.linguistic.nlp.pos.TagPair;
import com.harium.suneidesis.repository.word.WordKnowledgeBase;
import com.harium.suneidesis.concept.word.Word;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static com.harium.suneidesis.linguistic.nlp.pos.Tag.*;

/**
 * Multipass POSTagger with few words
 */
public class MultipassPOSTagger extends DatabasePOSTagger {

    public static final String PASSIVE_VOICE_PARTICLE = "foi";

    public MultipassPOSTagger(WordKnowledgeBase database) {
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
            Iterator<Word> words = database.getWords(tagPair.getWord());
            while (words.hasNext()) {
                Word word = words.next();
                if (DETERMINER.name().equals(word.getTagConcept().getName())) {
                    tagPair.setTag(DETERMINER);
                    // Verify next words (they could be adjective, numerals and so on)
                    if (output.length > i + 1) {
                        TagPair next = output[i + 1];
                        next.setTag(NOUN);
                    }
                }
            }
        }
    }

    private void handlePrepositions(TagPair[] output) {
        for (int i = 0; i < output.length; i++) {
            TagPair tagPair = output[i];
            if (VERB == tagPair.getTag()) {
                Iterator<Word> words = database.getWords(tagPair.getWord());

                WordVerb verb;
                while(words.hasNext()) {
                    Word w = words.next();
                    if (isVerb(w.getTag())) {
                        verb = database.findVerb(w.getLemmaConcept().getName());

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
        return tag.startsWith(VERB.name());
    }

    private void handleFixedTags(TagPair[] output) {
        for (int i = 0; i < output.length; i++) {
            String word = output[i].getWord();
            Iterator<Word> words = database.getWords(word);

            while (words.hasNext()) {
                Word w = words.next();
                if (PUNCTUATION.name().equals(w.getTag())) {
                    output[i].setTag(PUNCTUATION);
                    break;
                } else if(VERB.name().equals(w.getTag()) || VERB_PAST_TENSE.name().equals(w.getTag())) {
                    output[i].setTag(VERB);
                    break;
                }
            }
        }

    }

}
