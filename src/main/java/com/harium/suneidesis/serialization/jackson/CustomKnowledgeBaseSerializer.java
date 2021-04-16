package com.harium.suneidesis.serialization.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.harium.suneidesis.repository.KnowledgeBase;

import java.io.IOException;

public class CustomKnowledgeBaseSerializer extends StdSerializer<KnowledgeBase> {

    public static final String ATTR_CONCEPTS = "concepts";
    public static final String ATTR_NAME = "name";

    public CustomKnowledgeBaseSerializer() {
        this(null);
    }

    protected CustomKnowledgeBaseSerializer(Class<KnowledgeBase> t) {
        super(t);
    }

    @Override
    public void serialize(KnowledgeBase knowledgeBase, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
        jgen.writeStartObject();
        jgen.writeStringField(ATTR_NAME, knowledgeBase.getName());
        // TODO Ideally, it should be a reverse linked hash map
        jgen.writeObjectField(ATTR_CONCEPTS, knowledgeBase.getAll());
        jgen.writeEndObject();
    }
}
