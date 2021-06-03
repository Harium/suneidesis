package com.harium.suneidesis.serialization.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.repository.KnowledgeBase;

import java.io.IOException;
import java.util.Iterator;

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

        serializeConcepts(jgen, knowledgeBase);

        jgen.writeEndObject();
    }

    private void serializeConcepts(JsonGenerator jgen, KnowledgeBase knowledgeBase) throws IOException {
        jgen.writeObjectFieldStart(ATTR_CONCEPTS);
        Iterator<Concept> iterator = knowledgeBase.iterator();
        while (iterator.hasNext()) {
            Concept concept = iterator.next();
            if (concept.getId() == null) {
               continue;
            }
            jgen.writeObjectField(concept.getId(), concept);
        }
        jgen.writeEndObject();
    }
}
