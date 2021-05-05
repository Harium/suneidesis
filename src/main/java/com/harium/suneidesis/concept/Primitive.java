package com.harium.suneidesis.concept;

/**
 * Class that represents primitive data
 */
public class Primitive extends Concept {

    private String value;

    public Primitive(String value) {
        super(ConceptType.DATA, DataType.PRIMITIVE);
        this.value = value;
    }

    public Primitive(String value, Concept type) {
        super(type, DataType.PRIMITIVE);
        this.value = value;
    }

    @Override
    public String getName() {
        return value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setValue(boolean value) {
        this.value = String.valueOf(value);
    }

    public void setValue(byte value) {
        this.value = String.valueOf(value);
    }

    public void setValue(char value) {
        this.value = String.valueOf(value);
    }

    public void setValue(double value) {
        this.value = String.valueOf(value);
    }

    public void setValue(float value) {
        this.value = String.valueOf(value);
    }

    public void setValue(int value) {
        this.value = String.valueOf(value);
    }

    public void setValue(long value) {
        this.value = String.valueOf(value);
    }

    public void setValue(short value) {
        this.value = String.valueOf(value);
    }
}
