package com.harium.suneidesis.serialization;

import com.harium.suneidesis.repository.KnowledgeBase;

import java.io.IOException;

public interface KnowledgeBaseSerializer {

    String serialize(KnowledgeBase knowledgeBase) throws IOException;
}
