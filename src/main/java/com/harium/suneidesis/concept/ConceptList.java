package com.harium.suneidesis.concept;

public class ConceptList extends Concept {

    private int size = 0;

    public ConceptList(Concept type) {
        super(type, DataType.ARRAY);
    }

    public Concept get(int index) {
        return get(Integer.toString(index));
    }

    public void add(Concept concept) {
        attributes.set(Integer.toString(size), concept);
        size++;
    }

    public void remove(Concept concept) {
        attributes.remove(concept);
        pack();
    }

    private void pack() {
        int realLength = size;
        // Rearrange concepts so they can be contiguous
        for (int i = 0; i < size; i++) {
            if (!attributes.contains(Integer.toString(i))) {
                realLength--;
                for (int k = i + 1; k < size; k++) {
                    Concept concept = attributes.get(Integer.toString(k));
                    attributes.set(Integer.toString(k - 1), concept);
                }
            }
        }
        size = realLength;
    }

    public int getSize() {
        return size;
    }
}
