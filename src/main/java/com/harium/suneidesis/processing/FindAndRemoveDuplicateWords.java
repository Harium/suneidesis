package com.harium.suneidesis.processing;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.repository.word.WordKnowledgeBase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FindAndRemoveDuplicateWords extends BaseTask {

    public FindAndRemoveDuplicateWords(String name) {
        super(name);
    }

    @Override
    public boolean start(KnowledgeBase database) {
        if (!canStart()) {
            return false;
        }
        done = false;
        inProgress = true;

        WordKnowledgeBase wordKnowledgeBase = new WordKnowledgeBase(database);
        Set<String> tags = new HashSet<>();
        List<Concept> duplicates = new ArrayList<>();

        Iterator<Concept> iterator = database.iterator();
        while (iterator.hasNext()) {
            Concept concept = iterator.next();
            List<Word> words = wordKnowledgeBase.findByName(concept.getName());

            for (Word word : words) {
                if (tags.contains(word.getTag())) {
                    duplicates.add(word);
                    break;
                }
                tags.add(word.getTag());
            }
            tags.clear();
        }

        for (Concept duplicate : duplicates) {
            database.delete(duplicate);
        }

        inProgress = false;
        done = true;

        return true;
    }
}
