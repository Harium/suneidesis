package com.harium.suneidesis.serialization.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.harium.suneidesis.repository.KnowledgeBase;

import java.io.IOException;

public class CustomKnowledgeBaseSerializer extends StdSerializer<KnowledgeBase> {
    public CustomKnowledgeBaseSerializer() {
        this(null);
    }

    protected CustomKnowledgeBaseSerializer(Class<KnowledgeBase> t) {
        super(t);
    }

    @Override
    public void serialize(KnowledgeBase knowledgeBase, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
        jgen.writeStartObject();
        jgen.writeStringField("name", knowledgeBase.getName());
        jgen.writeObjectField("facts", knowledgeBase.getAll());
        jgen.writeEndObject();
    }
}
