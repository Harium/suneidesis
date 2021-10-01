package com.harium.suneidesis.linguistic.nlp.tokenization;

import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.linguistic.nlp.Tokenizer;
import com.harium.suneidesis.linguistic.nlp.pos.Tag;
import com.harium.suneidesis.repository.word.WordKnowledgeBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class DatabaseTokenizer implements Tokenizer {

    protected WordKnowledgeBase database;

    public DatabaseTokenizer(WordKnowledgeBase database) {
        this.database = database;
    }

    @Override
    public String[] tokenize(String query) {
        String text = handlePunctuation(query);
        // remove empty tokens
        String[] tokens = text.split("\\s+");

        return handleShortWords(tokens).toArray(new String[0]);
    }

    protected String handlePunctuation(String text) {
        if (database == null) {
            return text;
        }
        List<Word> punctuations = database.findByTag(Tag.PUNCTUATION);

        for (Word word : punctuations) {
            text = text.replace(word.getName(), " " + word.getName() + " ");
        }

        return text;
    }

    protected List<String> handleShortWords(String[] tokens) {
        if (database == null) {
            return Arrays.asList(tokens);
        }

        List<String> output = new ArrayList<>();

        for (String token : tokens) {
            Iterator<Word> result = database.getWords(token);
            if (result.hasNext()) {
                Word w = result.next();
                if (Tag.SHORT.name().equals(w.getTag())) {
                    String original = w.getLemma();
                    if (!original.contains(" ")) {
                        output.add(original);
                    } else {
                        output.addAll(Arrays.asList(original.split(" ")));
                    }
                } else {
                    output.add(token);
                }
            } else {
                output.add(token);
            }
        }

        return output;
    }

}
