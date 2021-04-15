package com.harium.suneidesis.serialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.concept.DataType;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.serialization.KnowledgeBaseDeserializer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.harium.suneidesis.concept.Concept.ATTRIBUTE_TYPE;
import static com.harium.suneidesis.concept.attribute.Attributes.ATTRIBUTE_DATA_TYPE;
import static com.harium.suneidesis.concept.attribute.Attributes.ATTRIBUTE_NAME;
import static com.harium.suneidesis.serialization.jackson.CustomKnowledgeBaseSerializer.ATTR_CONCEPTS;

public class CustomKnowledgeBaseDeserializer implements KnowledgeBaseDeserializer {

    private final ObjectMapper objectMapper;

    public CustomKnowledgeBaseDeserializer() {
        objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(KnowledgeBase.class, new CustomKnowledgeBaseSerializer());
        module.addSerializer(Concept.class, new ConceptSerializer());
        objectMapper.registerModule(module);
    }

    public void deserialize(InputStream stream, KnowledgeBase base) throws IOException {
        JsonNode node = objectMapper.readTree(stream);
        parseNode(node, base);
    }

    public void deserialize(String json, KnowledgeBase base) throws JsonProcessingException {
        JsonNode node = objectMapper.readTree(json);
        parseNode(node, base);
    }

    private void parseNode(JsonNode node, KnowledgeBase base) {
        base.setName(node.get(CustomKnowledgeBaseSerializer.ATTR_NAME).asText());

        List<Relationship> relationshipList = new ArrayList<>();

        for (Iterator<Map.Entry<String, JsonNode>> it = node.get(ATTR_CONCEPTS).fields(); it.hasNext(); ) {
            Map.Entry<String, JsonNode> child = it.next();
            // Deserialize concepts
            Concept concept = deserializeConcept(child, base, relationshipList);
            base.insert(child.getKey(), concept);
        }

        for (Relationship relationship : relationshipList) {
            Concept from = base.get(relationship.from);
            Concept target = base.get(relationship.target);
            if (target != null) {
                from.set(relationship.relation, target);
            } else {
                from.set(relationship.relation, new Concept(relationship.target));
            }

        }
    }

    private Concept deserializeConcept(Map.Entry<String, JsonNode> conceptEntry, KnowledgeBase base, List<Relationship> relationshipList) {
        String id = conceptEntry.getKey();
        JsonNode node = conceptEntry.getValue();

        Concept concept;

        if (node.has(ATTRIBUTE_NAME)) {
            concept = new Concept(node.get(ATTRIBUTE_NAME).asText());
        } else {
            concept = new Concept();
        }

        concept.id(id);

        for (Iterator<Map.Entry<String, JsonNode>> it = node.fields(); it.hasNext(); ) {
            Map.Entry<String, JsonNode> entry = it.next();

            // Skip name
            if (ATTRIBUTE_NAME.equals(entry.getKey())) {
               continue;
            }

            if (ATTRIBUTE_DATA_TYPE.equals(entry.getKey())) {
                deserializeDataType(concept, entry.getValue());
                continue;
            }
            if (ATTRIBUTE_TYPE.equals(entry.getKey())) {
                concept.type(ConceptType.getFromName(entry.getValue().asText()));
                continue;
            }
            // TODO CHANGE TO CONSTANTS
            if ("created_at".equals(entry.getKey())) {
                // Ignore for now
                continue;
            }

            // If value is a text, it's an id
            if (entry.getValue().isTextual()) {
               String targetId = entry.getValue().asText();
               if (base.contains(targetId)) {
                   Concept target = base.get(targetId);
                   concept.set(entry.getKey(), target);
                   continue;
               } else {
                   // Add the relationship between concepts to a queue
                   Relationship relationship = new Relationship();
                   relationship.from = concept.getIdText();
                   relationship.target = targetId;
                   relationship.relation = entry.getKey();
                   relationshipList.add(relationship);
               }
            }
        }
        return concept;
    }

    private void deserializeDataType(Concept concept, JsonNode value) {
        DataType dataType = DataType.valueOf(value.asText());
        concept.dataType(dataType);
    }

    class Relationship {
        String from;
        String target;
        String relation;
    }

}
