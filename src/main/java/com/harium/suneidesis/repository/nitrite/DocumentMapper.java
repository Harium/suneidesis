package com.harium.suneidesis.repository.nitrite;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.Primitive;
import com.harium.suneidesis.concept.attribute.Attributes;
import org.dizitart.no2.Document;
import org.dizitart.no2.KeyValuePair;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DocumentMapper {

    private static final String NITRITE_ID = "_id";
    private static final String NITRITE_REVISION = "_revision";
    private static final String NITRITE_MODIFIED = "_modified";

    public static Concept mapFromDocument(Document document) {
        String name = document.get(Attributes.ATTRIBUTE_NAME).toString();
        Concept concept = new Concept(name);

        for (KeyValuePair pair : document) {
            if (Attributes.ATTRIBUTE_NAME.equals(pair.getKey())) {
                continue;
            } else if (Concept.ATTRIBUTE_ID.equals(pair.getKey())) {
                concept.id(pair.getValue().toString());
                continue;
            } else if (isNitriteKey(pair.getKey())) {
                continue;
            }
            concept.has(pair.getKey(), getValue(pair));
        }

        return concept;
    }

    private static boolean isNitriteKey(String key) {
        return NITRITE_ID.equals(key) || NITRITE_REVISION.equals(key) || NITRITE_MODIFIED.equals(key);
    }

    private static Concept getValue(KeyValuePair pair) {
        if (pair.getValue().getClass().isPrimitive() || pair.getValue().getClass().equals(String.class)) {
            return new Primitive(pair.getValue().toString());
        }
        return mapFromDocument((Document)pair.getValue());
    }

    public static Document mapToDocument(Concept concept) {
        Document document = Document.createDocument(Attributes.ATTRIBUTE_NAME, concept.getName());

        for (Map.Entry<String, Concept> entry : concept.getAttributes().entrySet()) {
            if (Attributes.ATTRIBUTE_NAME.equals(entry.getKey())) {
                continue;
            }
            Concept v = entry.getValue();
            if (v.isPrimitive()) {
                document.put(entry.getKey(), v.getName());
            } else {
                document.put(entry.getKey(), mapToDocument(entry.getValue()));
            }
        }

        return document;
    }

}
