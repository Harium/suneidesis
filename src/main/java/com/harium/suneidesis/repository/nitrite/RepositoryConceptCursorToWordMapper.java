package com.harium.suneidesis.repository.nitrite;

import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.word.Word;
import com.harium.suneidesis.repository.RepositoryCursor;

public class RepositoryConceptCursorToWordMapper implements RepositoryCursor<Word> {

    private final RepositoryCursor<Concept> cursor;

    public RepositoryConceptCursorToWordMapper(RepositoryCursor<Concept> cursor) {
        this.cursor = cursor;
    }

    public java.util.Iterator<Word> iterator() {
        return new Iterator(cursor);
    }

    public static class Iterator implements java.util.Iterator<Word> {
        final java.util.Iterator<Concept> iterator;

        public Iterator(RepositoryCursor<Concept> iterator) {
            this.iterator = iterator.iterator();
        }

        public boolean hasNext() {
            return iterator.hasNext();
        }

        public Word next() {
            Concept concept = iterator.next();
            return new Word(concept.getName()).wrap(concept);
        }

        @Override
        public void remove() {
            iterator.remove();
        }
    }

}
