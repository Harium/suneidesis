package com.harium.suneidesis.repository;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.concept.attribute.Attributes;
import com.harium.suneidesis.repository.nitrite.DocumentMapper;
import org.dizitart.no2.Cursor;
import org.dizitart.no2.Document;
import org.dizitart.no2.Filter;
import org.dizitart.no2.IndexType;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.NitriteCollection;

import java.util.HashMap;
import java.util.Map;

import static org.dizitart.no2.IndexOptions.indexOptions;
import static org.dizitart.no2.filters.Filters.eq;

/**
 * Persistent Knowledge Base based on Nitrite DB
 * https://www.dizitart.org/nitrite-database/
 */
public class PersistentKnowledgeBase extends KnowledgeBase {

    private Nitrite database;
    private NitriteCollection collection;

    public PersistentKnowledgeBase() {
        // Init memory database
        database = Nitrite.builder()
                .compressed()
                .openOrCreate();
        init();
    }

    public PersistentKnowledgeBase(String path) {
        // Init file based database
        database = Nitrite.builder()
                .compressed()
                .filePath(path)
                .openOrCreate();
        init();
    }

    public PersistentKnowledgeBase(String path, String user, String password) {
        // Init secured / file based database
        database = Nitrite.builder()
                .compressed()
                .filePath(path)
                .openOrCreate(user, password);
        init();
    }

    private void init() {
        collection = database.getCollection("db");
        collection.createIndex(Concept.ATTRIBUTE_ID, indexOptions(IndexType.Unique));
        collection.createIndex(Attributes.ATTRIBUTE_NAME, indexOptions(IndexType.NonUnique));
    }

    @Override
    public Concept insert(String key, Concept concept) {
        save(concept);
        super.insert(key, concept);
        return concept;
    }

    @Override
    public void save(Concept concept) {
        Document saved = collection.find(eq(Concept.ATTRIBUTE_ID, concept.getId())).firstOrDefault();
        boolean exists = saved != null;

        if (!exists) {
            Document doc = DocumentMapper.mapToDocument(concept);
            collection.insert(doc);
        } else {
            Document doc = DocumentMapper.mapToDocument(saved, concept);
            collection.update(doc);
        }
    }

    @Override
    public void merge(KnowledgeBase concepts) {
        Map<String, Concept> map = concepts.getAll();
        for (Map.Entry<String, Concept> entry : map.entrySet()) {
            insert(entry.getKey(), entry.getValue());
        }
    }

    public void clear() {
        collection.drop();
    }

    @Override
    public void close() {
        collection.close();
    }

    @Override
    public boolean isClosed() {
        return collection.isClosed();
    }

    @Override
    public Map<String, Concept> getAll() {
        Cursor cursor = collection.find();

        Map<String, Concept> conceptMap = new HashMap<>();

        for (Document document : cursor) {
            Concept concept = DocumentMapper.mapFromDocument(document);
            String id = document.get(Concept.ATTRIBUTE_ID).toString();
            conceptMap.put(id, concept);
        }

        return conceptMap;
    }

    @Override
    public Concept get(String key) {
        Cursor cursor = collection.find(eq(Concept.ATTRIBUTE_ID, key));

        if (cursor == null) {
            return ConceptType.UNKNOWN_TYPE;
        }
        return DocumentMapper.mapFromDocument(cursor.firstOrDefault());
    }

    @Override
    public boolean contains(String key) {
        Cursor cursor = collection.find(eq(Concept.ATTRIBUTE_ID, key));
        return cursor.iterator().hasNext();
    }

    // TODO Unify find methods and move to repository
    public RepositoryConceptCursor find() {
        return new RepositoryConceptCursor(collection.find());
    }

    public RepositoryConceptCursor find(Filter filter) {
        return new RepositoryConceptCursor(collection.find(filter));
    }

}