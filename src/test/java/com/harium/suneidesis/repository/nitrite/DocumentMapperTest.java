package com.harium.suneidesis.repository.nitrite;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.concept.attribute.Attributes;
import org.dizitart.no2.Document;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DocumentMapperTest {

    @Test
    public void testToDocument() {
        Concept concept = new Concept("Namibia")
                .id("idd")
                .type(ConceptType.PLACE)
                .has("fruit", new Concept("apple"));

        Document document = DocumentMapper.mapToDocument(concept);

        assertEquals("idd", document.get(Concept.ATTRIBUTE_ID));
        assertEquals("Namibia", document.get(Attributes.ATTRIBUTE_NAME));
        assertEquals(ConceptType.PLACE.getName(), ((Document)document.get("type")).get("name"));
        assertEquals("apple", ((Document)document.get("fruit")).get("name"));
    }

}
