package com.harium.suneidesis.serialization;

import com.harium.suneidesis.repository.KnowledgeBase;

import java.io.IOException;
import java.io.OutputStream;

public interface KnowledgeBaseSerializer {

    String serialize(KnowledgeBase knowledgeBase) throws IOException;

    OutputStream serialize(KnowledgeBase knowledgeBase, OutputStream stream) throws IOException;
}
