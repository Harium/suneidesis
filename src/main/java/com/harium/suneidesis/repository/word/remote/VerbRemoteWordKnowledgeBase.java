package com.harium.suneidesis.repository.word.remote;

import com.harium.suneidesis.concept.word.WordVerbConjugation;

import java.io.IOException;
import java.util.List;

public interface VerbRemoteWordKnowledgeBase {

    List<WordVerbConjugation> findConjugations(String verb) throws IOException;

}
