package com.harium.suneidesis.concept;

import java.util.ArrayList;
import java.util.List;

public class ConceptList extends Concept {

    private static final String ATTRIBUTE_SIZE = "size";

    public ConceptList(String name) {
        super(name);
        dataType(DataType.ARRAY);
        setSize(0L);
    }

    public ConceptList(ConceptType type) {
        super(type);
        dataType(DataType.ARRAY);
        setSize(0L);
    }

    public Concept get(int index) {
        String key = Integer.toString(index);
        return get(key);
    }

    public void add(Concept concept) {
        String key = get(ATTRIBUTE_SIZE).getValue();
        getAttributes().save(key, concept);
        incrementSize();
    }

    private void incrementSize() {
        long size = getSize();
        setSize(size + 1);
    }

    private void setSize(Long size) {
        has(ATTRIBUTE_SIZE, new Primitive(Long.toString(size)));
    }

    public void remove(Concept concept) {
        if (getAttributes().remove(concept)) {
            pack();
        }
    }

    public void remove(int index) {
        removeAndPack(index, true);
    }

    private void removeAndPack(long index, boolean pack) {
        String key = Long.toString(index);
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
        long size = getSize();
        long realLength = size;
        // Rearrange concepts so they can be contiguous
        for (int i = 0; i < size; i++) {
            if (!getAttributes().contains(Integer.toString(i))) {
                realLength--;
                for (int k = i + 1; k < size; k++) {
                    Concept concept = getAttributes().get(Integer.toString(k));
                    getAttributes().save(Integer.toString(k - 1), concept);
                }
            }
        }
        // Update Size
        setSize(realLength);
    }

    private void refresh() {
        // Rearrange concepts so they can be contiguous
        long i = 0;
        while (getAttributes().contains(Long.toString(i))) {
            i++;
        }
        // Update Size
        setSize(i);
    }

    public List<Concept> getAll() {
        List<Concept> items = new ArrayList<>();

        for (int i = 0; i < getSize(); i++) {
            String key = Integer.toString(i);

            Concept item = getAttributes().get(key);
            if (!item.isUnknown()) {
                items.add(item);
            }
        }
        return items;
    }

    public void clear() {
        for (long i = getSize() - 1; i >= 0; i--) {
            removeAndPack(i, false);
        }
        setSize(0L);
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public long getSize() {
        return Long.parseLong(get(ATTRIBUTE_SIZE).getValue());
    }

    @Override
    public ConceptList wrap(Concept concept) {
        super.wrap(concept);
        refresh();
        return this;
    }
}
