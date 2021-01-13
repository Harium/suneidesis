package com.harium.suneidesis.knowledge.linguistic.core.storage;

import com.harium.suneidesis.concept.Fact;
import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.concept.word.WordVerb;
import com.harium.suneidesis.concept.word.WordVerbConjugation;
import com.harium.suneidesis.knowledge.Repository;

import java.util.List;

public interface WordRepository extends Repository<Fact> {

    String save(Word word);

    String save(WordVerb verb);

    String save(WordVerbConjugation verbConjugation);

    List<Word> findAllWords(String word);

    Word findWordById(String wordId);

    Word findModelByWordIdAndTag(String wordId, String tag);

    WordVerb findVerbByWordId(String wordId);

    WordVerbConjugation findVerbConjugationByWordId(String wordId);

}
