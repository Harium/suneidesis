package com.harium.suneidesis.serialization.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.concept.DataType;
import com.harium.suneidesis.concept.Primitive;
import com.harium.suneidesis.concept.attribute.Inheritance;
import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.repository.KnowledgeBase;
import com.harium.suneidesis.repository.decorator.TimeDecorator;
import com.harium.suneidesis.serialization.KnowledgeBaseDeserializer;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.harium.suneidesis.concept.Concept.ATTRIBUTE_ID;
import static com.harium.suneidesis.concept.Concept.ATTRIBUTE_TYPE;
import static com.harium.suneidesis.concept.attribute.Attributes.*;
import static com.harium.suneidesis.serialization.jackson.CustomKnowledgeBaseSerializer.ATTR_CONCEPTS;

public class CustomKnowledgeBaseDeserializer implements KnowledgeBaseDeserializer {

    private final ObjectMapper objectMapper;

    public CustomKnowledgeBaseDeserializer() {
        objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(KnowledgeBase.class, new CustomKnowledgeBaseSerializer());
        module.addSerializer(Concept.class, new ConceptSerializer());
        module.addSerializer(Inheritance.class, new InheritanceSerializer());
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
                if (!Relationship.INHERITANCE.equals(relationship.relation)) {
                    from.set(relationship.relation, target);
                } else {
                    from.is(target);
                }
            } else {
                if (!Relationship.INHERITANCE.equals(relationship.relation)) {
                    from.set(relationship.relation, new Concept(relationship.target));
                } else {
                    // It should never happen (otherwise the inheritance is missing)
                    from.is(new Concept(relationship.target));
                }
            }

        }
    }

    private Concept deserializeConcept(Map.Entry<String, JsonNode> conceptEntry, KnowledgeBase base, List<Relationship> relationshipList) {
        String id = conceptEntry.getKey();
        JsonNode node = conceptEntry.getValue();

        Concept concept;

        if (node.has(ATTRIBUTE_NAME)) {
            if (isWord(node) || isPrimitive(node)) {
                // Init concept as primitive
                concept = new Primitive(node.get(ATTRIBUTE_NAME).asText());
            } else {
                concept = new Concept(node.get(ATTRIBUTE_NAME).asText());
            }
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

            if (ATTRIBUTE_INHERITANCE.equals(entry.getKey())) {
                List<String> inheritances = deserializeInheritanceList(entry.getValue());
                for (String targetId: inheritances) {
                    assignConcept(base, concept, targetId, Relationship.INHERITANCE, relationshipList);
                }
                continue;
            }

            if (TimeDecorator.ATTRIBUTE_CREATED_AT.equals(entry.getKey())) {
                // Ignore for now
                continue;
            }

            // If value is an object that has id, it's a concept
            JsonNode value = entry.getValue();

            if (value.isTextual()) {
                concept.set(entry.getKey(), new Word(value.asText()));
                continue;
            }

            if (value.isObject() && value.has(ATTRIBUTE_ID)) {
                String key = entry.getKey();
                String targetId = value.get(ATTRIBUTE_ID).asText();
                assignConcept(base, concept, targetId, key, relationshipList);
            }
        }
        return concept;
    }

    private boolean isPrimitive(JsonNode node) {
        JsonNode dataType = node.get(ATTRIBUTE_DATA_TYPE);
        if (dataType == null) {
            return false;
        }
        return DataType.PRIMITIVE.name().equals(dataType.asText());
    }

    private boolean isWord(JsonNode node) {
        JsonNode type = node.get(ATTRIBUTE_TYPE);
        if (type == null) {
           return false;
        }
        return ConceptType.WORD.getName().equals(type.asText());
    }

    private void assignConcept(KnowledgeBase base, Concept concept, String targetId, String relation, List<Relationship> relationshipList) {
        // If concept is already loaded
        if (base.contains(targetId)) {
            // Assign concept
            Concept target = base.get(targetId);
            if (!Relationship.INHERITANCE.equals(relation)) {
                concept.set(relation, target);
            } else {
                concept.is(target);
            }
        } else {
            // Add the relationship between concepts to a queue
            Relationship relationship = new Relationship();
            relationship.from = concept.getIdText();
            relationship.target = targetId;
            relationship.relation = relation;
            relationshipList.add(relationship);
        }
    }

    private List<String> deserializeInheritanceList(JsonNode node) {
        List<String> inheritances = new ArrayList<>();
        for (JsonNode child : node) {
            String targetId = child.asText();
            inheritances.add(targetId);
        }
        return inheritances;
    }

    private void deserializeDataType(Concept concept, JsonNode value) {
        DataType dataType = DataType.valueOf(value.asText());
        concept.dataType(dataType);
    }

    class Relationship {
        private static final String INHERITANCE = "inheritance";
        String from;
        String target;
        String relation;
    }

}
