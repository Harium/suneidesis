package com.harium.suneidesis.serialization.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Fact;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.serialization.KnowledgeBaseSerializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class KnowledgeBaseJacksonSerializer implements KnowledgeBaseSerializer {

    private final ObjectMapper objectMapper;

    public KnowledgeBaseJacksonSerializer() {
        objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(KnowledgeBase.class, new CustomKnowledgeBaseSerializer());
        module.addSerializer(Concept.class, new ConceptSerializer());
        module.addSerializer(Fact.class, new FactSerializer());
        objectMapper.registerModule(module);
    }

    public String serialize(KnowledgeBase knowledgeBase) throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(stream, knowledgeBase);
        String finalString = new String(stream.toByteArray());

        System.out.println(finalString);
        return finalString;
    }

}
