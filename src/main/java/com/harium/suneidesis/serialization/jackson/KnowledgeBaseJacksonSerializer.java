package com.harium.suneidesis.serialization.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.DataType;
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
        module.addSerializer(Concept.class, new CustomConceptSerializer());
        module.addSerializer(Fact.class, new CustomFactSerializer());
        objectMapper.registerModule(module);
    }

    public String serialize(KnowledgeBase knowledgeBase) throws IOException {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(stream, knowledgeBase);
        String finalString = new String(stream.toByteArray());

        System.out.println(finalString);
        return finalString;
    }

    static class CustomKnowledgeBaseSerializer extends StdSerializer<KnowledgeBase> {
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

    static class CustomConceptSerializer extends StdSerializer<Concept> {
        public CustomConceptSerializer() {
            this(null);
        }

        protected CustomConceptSerializer(Class<Concept> t) {
            super(t);
        }

        @Override
        public void serialize(Concept concept, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
            jgen.writeStartObject();
            if (DataType.PRIMITIVE.equals(concept.getDataType())) {
                jgen.writeStringField("name", concept.getName());
            } else {
                jgen.writeObjectField("name", concept.getNameConcept());
            }

            jgen.writeObjectField("type", concept.getType().getName());
            jgen.writeObjectField("dataType", concept.getDataType());

            jgen.writeEndObject();
        }
    }

    static class CustomFactSerializer extends StdSerializer<Fact> {
        public CustomFactSerializer() {
            this(null);
        }

        protected CustomFactSerializer(Class<Fact> t) {
            super(t);
        }

        @Override
        public void serialize(Fact fact, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
            jgen.writeStartObject();
            jgen.writeObjectField("name", fact.getNameConcept());
            writeConcept(Fact.ATTRIBUTE_SUBJECT, fact.getSubject(), jgen);
            writeConcept(Fact.ATTRIBUTE_OBJECT, fact.getObject(), jgen);
            writeConcept(Fact.ATTRIBUTE_PREDICATE, fact.getPredicate(), jgen);

            jgen.writeEndObject();
        }

        private void writeConcept(String field, Concept concept, JsonGenerator jgen) throws IOException {
            if (!concept.isUnknown()) {
                jgen.writeObjectField(field, concept);
            }
        }
    }

}
