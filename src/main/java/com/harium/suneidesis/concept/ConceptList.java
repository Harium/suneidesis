package com.harium.suneidesis.concept;

import java.util.ArrayList;
import java.util.List;

public class ConceptList extends Concept {

    private int size = 0;

    public ConceptList(String name) {
        super(name);
        dataType(DataType.ARRAY);
    }

    public ConceptList(ConceptType type) {
        super(type);
        dataType(DataType.ARRAY);
    }

    public Concept get(int index) {
        String key = Integer.toString(index);
        return get(key);
    }

    public void add(Concept concept) {
        String key = Integer.toString(size);
        getAttributes().insert(key, concept);
        size++;
    }

    public void remove(Concept concept) {
        if (getAttributes().remove(concept)) {
            pack();
        }
    }

    public void remove(int index) {
        removeAndPack(index, true);
    }

    private void removeAndPack(int index, boolean pack) {
        String key = Integer.toString(index);
        Concept removed = getAttributes().removeAttribute(key);
        if (pack && removed != null) {
            pack();
        }
    }

    public void removeByName(String key) {
        if (getAttributes().removeByName(key)) {
            pack();
        }
    }

    private void pack() {
        int realLength = size;
        // Rearrange concepts so they can be contiguous
        for (int i = 0; i < size; i++) {
            if (!getAttributes().contains(Integer.toString(i))) {
                realLength--;
                for (int k = i + 1; k < size; k++) {
                    Concept concept = getAttributes().get(Integer.toString(k));
                    getAttributes().insert(Integer.toString(k - 1), concept);
                }
            }
        }
        // Update Size
        size = realLength;
    }

    public List<Concept> getAll() {
        List<Concept> items = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            String key = Integer.toString(i);

            Concept item = getAttributes().get(key);
            if (!item.isUnknown()) {
                items.add(item);
            }
        }
        return items;
    }

    public void clear() {
        for (int i = size - 1; i >= 0; i--) {
            removeAndPack(i, false);
        }
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

}
