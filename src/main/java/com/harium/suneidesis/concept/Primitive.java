package com.harium.suneidesis.concept;

/**
 * Class that represents primitive data
 */
public class Primitive extends Concept {

    public Primitive() {
        super(ConceptType.DATA, DataType.PRIMITIVE);
    }

    public Primitive(Concept type) {
        super(type, DataType.PRIMITIVE);
    }

}
