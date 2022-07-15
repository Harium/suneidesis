package com.harium.suneidesis.repository.word.remote;

import com.harium.suneidesis.linguistic.nlp.pos.Tag;

import java.io.IOException;
import java.util.List;

public interface TagRemoteWordKnowledgeBase {

    List<Tag> findTag(String word) throws IOException;

}
