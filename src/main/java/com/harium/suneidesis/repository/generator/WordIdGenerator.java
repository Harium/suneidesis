package com.harium.suneidesis.repository.generator;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.repository.KnowledgeBase;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class WordIdGenerator implements IdGenerator {

    private static final Pattern DE_ACCENT = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");

    private final KnowledgeBase knowledgeBase;

    public WordIdGenerator(KnowledgeBase knowledgeBase) {
        this.knowledgeBase = knowledgeBase;
    }

    @Override
    public String generateId(Concept concept) {
        String baseId = generateId(concept.getName());

        int index = 1;
        String id;
        do {
            id = baseId;
            id += "-" + index;

            index++;
        } while (idExists(id));
        return id;
    }

    @Override
    public void update(KnowledgeBase knowledgeBase) {

    }

    private boolean idExists(String id) {
        return !knowledgeBase.findById(id).isUnknown();
    }

    protected String generateId(String word) {
        String sentence = clearPunctuation(word);
        sentence = handleMultipleSpaces(sentence);

        String nfdNormalizedString = Normalizer.normalize(sentence, Normalizer.Form.NFD);
        String normalizedString = DE_ACCENT.matcher(nfdNormalizedString).replaceAll("");

        return normalizedString.toLowerCase().replaceAll(" ", "-");
    }

    private String clearPunctuation(String word) {
        return word.toLowerCase()
                .replaceAll("\\.", " dot ")
                .replaceAll(",", " comma ");
    }

    private String handleMultipleSpaces(String sentence) {
        return sentence.replaceAll(" +", " ");
    }
}
