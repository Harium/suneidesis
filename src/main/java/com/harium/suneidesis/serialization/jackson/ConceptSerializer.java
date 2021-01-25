package com.harium.suneidesis.serialization.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.DataType;
import com.harium.suneidesis.concept.attribute.Attributes;

import java.io.IOException;
import java.util.Map;

import static com.harium.suneidesis.concept.attribute.Attributes.ATTRIBUTE_DATA_TYPE;
import static com.harium.suneidesis.concept.attribute.Attributes.ATTRIBUTE_NAME;

public class ConceptSerializer extends StdSerializer<Concept> {

    public ConceptSerializer() {
        this(null);
    }

    protected ConceptSerializer(Class<Concept> t) {
        super(t);
    }

    @Override
    public void serialize(Concept concept, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
        jgen.writeStartObject();
        if (DataType.PRIMITIVE.equals(concept.getDataType())) {
            jgen.writeStringField(Attributes.ATTRIBUTE_NAME, concept.getName());
        } else {
            //jgen.writeObjectField(Attributes.ATTRIBUTE_NAME, concept.getNameConcept());
        }

        jgen.writeObjectField(ATTRIBUTE_DATA_TYPE, concept.getDataType());
        jgen.writeObjectField(Concept.ATTRIBUTE_TYPE, concept.getType().getName());

        for (Map.Entry<String, Concept> entry : concept.getAttributes().getAll().entrySet()) {
            // TODO WRITE ID ONLY
            /*if (ATTRIBUTE_NAME.equals(entry.getKey())) {
                jgen.writeObjectField(Concept.ATTRIBUTE_TYPE, concept.getType().getName());
            }*/
            jgen.writeObjectField(entry.getKey(), entry.getValue().getId());
        }

        jgen.writeEndObject();
    }
}
