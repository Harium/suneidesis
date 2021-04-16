package com.harium.suneidesis.serialization;

import com.harium.suneidesis.repository.KnowledgeBase;

import java.io.IOException;
import java.io.InputStream;

public interface KnowledgeBaseDeserializer {

    void deserialize(String json, KnowledgeBase base) throws IOException;

    void deserialize(InputStream json, KnowledgeBase base) throws IOException;

}
