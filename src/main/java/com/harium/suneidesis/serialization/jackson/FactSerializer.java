package com.harium.suneidesis.serialization.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Fact;
import com.harium.suneidesis.concept.attribute.Attributes;

import java.io.IOException;

public class FactSerializer extends StdSerializer<Fact> {
    public FactSerializer() {
        this(null);
    }

    protected FactSerializer(Class<Fact> t) {
        super(t);
    }

    @Override
    public void serialize(Fact fact, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
        jgen.writeStartObject();
        jgen.writeObjectField(Attributes.ATTRIBUTE_NAME, fact.getNameConcept());
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
