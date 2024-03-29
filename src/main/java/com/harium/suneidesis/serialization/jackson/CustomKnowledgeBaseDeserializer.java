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
import com.harium.suneidesis.repository.merge.MergeStrategy;
import com.harium.suneidesis.repository.merge.MergeStrategyType;
import com.harium.suneidesis.serialization.BaseDeserializer;
import com.harium.suneidesis.serialization.KnowledgeBaseDeserializer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static com.harium.suneidesis.concept.Concept.ATTRIBUTE_TYPE;
import static com.harium.suneidesis.concept.attribute.Attributes.*;
import static com.harium.suneidesis.repository.merge.MergeStrategyFactory.buildMergeStrategy;
import static com.harium.suneidesis.serialization.jackson.CustomKnowledgeBaseSerializer.ATTR_CONCEPTS;

public class CustomKnowledgeBaseDeserializer extends BaseDeserializer implements KnowledgeBaseDeserializer {

    private static final String SERIALIZED_ID = "id";

    private final ObjectMapper objectMapper;

    public CustomKnowledgeBaseDeserializer() {
        this(MergeStrategyType.CREATE_NEW);
    }

    public CustomKnowledgeBaseDeserializer(MergeStrategyType mergeStrategyType) {
        super(mergeStrategyType);
        objectMapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addSerializer(KnowledgeBase.class, new CustomKnowledgeBaseSerializer());
        module.addSerializer(Concept.class, new ConceptSerializer());
        module.addSerializer(Inheritance.class, new InheritanceSerializer());
        objectMapper.registerModule(module);
    }

    public void deserialize(File file, KnowledgeBase base) throws IOException {
        deserialize(new FileInputStream(file), base);
    }

    public void deserialize(InputStream stream, KnowledgeBase base) throws IOException {
        JsonNode node = objectMapper.readTree(stream);
        MergeStrategy mergeStrategy = buildMergeStrategy(mergeStrategyType, base);
        parseNode(node, mergeStrategy, base);
    }

    public void deserialize(String json, KnowledgeBase base) throws JsonProcessingException {
        JsonNode node = objectMapper.readTree(json);
        MergeStrategy mergeStrategy = buildMergeStrategy(mergeStrategyType, base);
        parseNode(node, mergeStrategy, base);
    }

    private void parseNode(JsonNode node, MergeStrategy mergeStrategy, KnowledgeBase base) {
        base.setName(node.get(CustomKnowledgeBaseSerializer.ATTR_NAME).asText());

        List<Relationship> relationshipList = new ArrayList<>();

        for (Iterator<Map.Entry<String, JsonNode>> it = node.get(ATTR_CONCEPTS).fields(); it.hasNext(); ) {
            Map.Entry<String, JsonNode> child = it.next();
            // Deserialize concepts
            Concept concept = deserializeConcept(mergeStrategy, base, child, relationshipList);
            base.save(concept.getId(), concept);
        }

        // Iterate relationships in reverse so we can build it bottom-top
        for (int i = relationshipList.size() - 1; i >= 0; i--) {
            Relationship relationship = relationshipList.get(i);
            Concept from = base.get(relationship.from);
            Concept target = base.get(relationship.target);
            if (target != null) {
                if (!Relationship.INHERITANCE.equals(relationship.relation)) {
                    from.set(relationship.relation, target);
                } else {
                    from.is(target);
                }
            } else {
                Concept placeHolder = new Concept(relationship.target);
                if (!Relationship.INHERITANCE.equals(relationship.relation)) {
                    from.set(relationship.relation, placeHolder);
                } else {
                    // It should never happen (otherwise the inheritance is missing)
                    from.is(placeHolder);
                }
            }
            base.save(from);
        }
    }

    private Concept deserializeConcept(MergeStrategy mergeStrategy, KnowledgeBase knowledgeBase, Map.Entry<String, JsonNode> conceptEntry, List<Relationship> relationshipList) {
        JsonNode node = conceptEntry.getValue();

        Concept concept;

        if (node.has(ATTRIBUTE_NAME)) {
            if (isPrimitive(node)) {
                // Init concept as primitive
                concept = new Primitive(node.get(ATTRIBUTE_NAME).asText());
            } else if (isWord(node)) {
                concept = new Word(node.get(ATTRIBUTE_NAME).asText());
            } else {
                concept = new Concept(node.get(ATTRIBUTE_NAME).asText());
            }
        } else {
            concept = new Concept(ConceptType.UNKNOWN_TYPE);
        }
        // Set Id
        mergeStrategy.setId(concept, conceptEntry.getKey());

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
                    assignConcept(knowledgeBase, concept, targetId, Relationship.INHERITANCE, relationshipList);
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

            if (value.isObject() && value.has(SERIALIZED_ID)) {
                String key = entry.getKey();
                String targetId = value.get(SERIALIZED_ID).asText();
                assignConcept(knowledgeBase, concept, targetId, key, relationshipList);
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

    private void assignConcept(KnowledgeBase knowledgeBase, Concept concept, String targetId, String relation, List<Relationship> relationshipList) {
        // If concept is already loaded
        if (knowledgeBase.contains(targetId)) {
            // Assign concept
            Concept target = knowledgeBase.get(targetId);
            if (!Relationship.INHERITANCE.equals(relation)) {
                concept.set(relation, target);
            } else {
                concept.is(target);
            }
        } else {
            // Add the relationship between concepts to a queue
            Relationship relationship = new Relationship();
            relationship.from = concept.getId();
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

    static class Relationship {
        private static final String INHERITANCE = "inheritance";
        String from;
        String target;
        String relation;
    }

}
