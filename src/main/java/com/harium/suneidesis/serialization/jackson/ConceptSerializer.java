package com.harium.suneidesis.serialization.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.concept.DataType;
import com.harium.suneidesis.concept.attribute.Attributes;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.harium.suneidesis.concept.Concept.ATTRIBUTE_ID;
import static com.harium.suneidesis.concept.Concept.ATTRIBUTE_TYPE;
import static com.harium.suneidesis.concept.Time.ATTRIBUTE_END;
import static com.harium.suneidesis.concept.Time.ATTRIBUTE_START;
import static com.harium.suneidesis.concept.attribute.Attributes.ATTRIBUTE_DATA_TYPE;
import static com.harium.suneidesis.concept.attribute.Attributes.ATTRIBUTE_NAME;
import static com.harium.suneidesis.repository.decorator.TimeDecorator.ATTRIBUTE_CREATED_AT;

public class ConceptSerializer extends StdSerializer<Concept> {

    public ConceptSerializer() {
        this(null);
    }

    protected ConceptSerializer(Class<Concept> t) {
        super(t);
    }

    @Override
    public void serialize(Concept concept, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
        //serializeChildren(concept, jgen);
        serializeCurrentConcept(concept, jgen);
    }

    private Map<String, Concept> generateConcepts(Concept concept) {
        Map<String, Concept> concepts = new HashMap<>();
        for (Map.Entry<String, Concept> entry : concept.getAttributes().getAll().entrySet()) {
            concepts.put(entry.getKey(), entry.getValue());
        }
        return concepts;
    }

    private void serializeChildren(Concept concept, JsonGenerator jgen) throws IOException {
        Map<String, Concept> concepts = generateConcepts(concept);
        for (Map.Entry<String, Concept> entry : concepts.entrySet()) {
            if (ATTRIBUTE_ID.equals(entry.getKey())) {
                continue;
            }
            serializeCurrentConcept(entry.getValue(), jgen);
        }
    }

    private void serializeCurrentConcept(Concept concept, JsonGenerator jgen) throws IOException {
        if (ConceptType.TIME_UNIT == concept.getType()) {
            serializeTimeUnit(concept, jgen);
            return;
        }

        jgen.writeStartObject();

        if (DataType.PRIMITIVE.equals(concept.getDataType())) {
            jgen.writeStringField(Attributes.ATTRIBUTE_NAME, concept.getName());
        } else {
            jgen.writeObjectField(Attributes.ATTRIBUTE_NAME, concept.getName());
        }

        jgen.writeObjectField(ATTRIBUTE_DATA_TYPE, concept.getDataType());
        serializeField(concept.getType(), ATTRIBUTE_TYPE, jgen);

        for (Map.Entry<String, Concept> entry : concept.getAttributes().getAll().entrySet()) {
            if (ATTRIBUTE_TYPE.equals(entry.getKey())) {
                continue;
            }
            if (ATTRIBUTE_NAME.equals(entry.getKey())) {
                continue;
            }
            if (ATTRIBUTE_ID.equals(entry.getKey())) {
                continue;
            }

            if (ConceptType.TIME_UNIT == entry.getValue().getType()) {
                // Write full concept not only the id
                jgen.writeObjectField(entry.getKey(), entry.getValue());
                continue;
            }

            // Serialize id to avoid circular dependencies
            jgen.writeStringField(entry.getKey(), entry.getValue().getIdText());
        }
        jgen.writeEndObject();
    }

    private void serializeTimeUnit(Concept concept, JsonGenerator jgen) throws IOException {
        jgen.writeStartObject();
        if (!concept.getNameConcept().isUnknown()) {
            serializeField(concept.getNameConcept(), ATTRIBUTE_NAME, jgen);
        }

        jgen.writeObjectField(ATTRIBUTE_DATA_TYPE, concept.getDataType());
        serializeField(concept.getType(), ATTRIBUTE_TYPE, jgen);
        serializeField(concept.get(ATTRIBUTE_START), ATTRIBUTE_START, jgen);
        serializeField(concept.get(ATTRIBUTE_END), ATTRIBUTE_END, jgen);
        jgen.writeEndObject();
    }

    private void serializeField(Concept concept, String field, JsonGenerator jgen) throws IOException {
        if (!concept.isUnknown()) {
            jgen.writeObjectField(field, concept.getName());
        }
    }
}
