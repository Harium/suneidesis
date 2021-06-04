package com.harium.suneidesis.serialization.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.concept.DataType;
import com.harium.suneidesis.concept.attribute.Attributes;
import com.harium.suneidesis.concept.attribute.Inheritance;
import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.serialization.ConceptId;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.harium.suneidesis.concept.Concept.ATTRIBUTE_ID;
import static com.harium.suneidesis.concept.Concept.ATTRIBUTE_TYPE;
import static com.harium.suneidesis.concept.measurement.Time.ATTRIBUTE_END;
import static com.harium.suneidesis.concept.measurement.Time.ATTRIBUTE_START;
import static com.harium.suneidesis.concept.attribute.Attributes.*;

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
        jgen.writeStartObject();
        jgen.writeObjectField(Attributes.ATTRIBUTE_NAME, concept.getName());

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
            if (ATTRIBUTE_INHERITANCE.equals(entry.getKey())) {
                Inheritance inheritance = new Inheritance("").wrap(entry.getValue());
                // Skip inheritance if empty
                if (!inheritance.getMap().isEmpty()) {
                    jgen.writeObjectField(entry.getKey(), inheritance);
                }
                continue;
            }

            Concept value = entry.getValue();
            if (DataType.PRIMITIVE == value.getDataType()) {
                jgen.writeObjectField(entry.getKey(), value.getValue());
                continue;
            }

            serializeConceptId(jgen, entry.getKey(), entry.getValue());
        }
        jgen.writeEndObject();
    }

    private void serializeField(Concept concept, String field, JsonGenerator jgen) throws IOException {
        if (!concept.isUnknown()) {
            jgen.writeObjectField(field, concept.getName());
        }
    }

    // Serialize concept as id to avoid circular dependencies
    public static void serializeConceptId(JsonGenerator jgen, String key, Concept concept) throws IOException {
        //jgen.writeStringField(entry.getKey(), entry.getValue().getIdText());
        jgen.writeObjectField(key, new ConceptId(concept.getId()));
    }

}
