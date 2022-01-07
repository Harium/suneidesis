package com.harium.suneidesis.concept;

/**
 * Class that represents primitive data.
 * It can represent quantity, text or simply plain data
 */
public class Primitive extends Concept {

    public Primitive(String value) {
        super(value, ConceptType.DATA);
        dataType(DataType.PRIMITIVE);
    }

    public Primitive(String value, ConceptType type) {
        super(value, type);
        dataType(DataType.PRIMITIVE);
    }

    public void setValue(String value) {
        this.setName(value);
    }

    public void setValue(boolean value) {
        setValue(String.valueOf(value));
    }

    public void setValue(byte value) {
        setValue(String.valueOf(value));
    }

    public void setValue(char value) {
        setValue(String.valueOf(value));
    }

    public void setValue(double value) {
        setValue(String.valueOf(value));
    }

    public void setValue(float value) {
        setValue(String.valueOf(value));
    }

    public void setValue(int value) {
        setValue(String.valueOf(value));
    }

    public void setValue(long value) {
        setValue(String.valueOf(value));
    }

    public void setValue(short value) {
        setValue(String.valueOf(value));
    }
}
