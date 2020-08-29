package com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.database;

import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model.Verb;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model.VerbConjugation;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model.Word;
import com.harium.suneidesis.knowledge.linguistic.core.nlp.pos.model.WordModel;

import java.util.List;

public interface WordDatabase {

    String save(Word word);

    String save(Verb verb);

    String save(VerbConjugation verbConjugation);

    List<Word> findAllWords(String word);

    Word findWordById(String wordId);

    WordModel findModelByWordIdAndTag(String wordId, String tag);

    Verb findVerbByWordId(String wordId);

    VerbConjugation findVerbConjugationByWordId(String wordId);

}
