package com.harium.suneidesis.concept;

public class Language extends Concept {

    public static final String ATTRIBUTE_CODE = "lang_code";

    public Language(String name) {
        super(name, ConceptType.LANGUAGE);
    }

    public Language setCode(Concept code) {
        has(ATTRIBUTE_CODE, code);
        return this;
    }

    public Concept getCode() {
        return get(ATTRIBUTE_CODE);
    }

    @Override
    public Language wrap(Concept concept) {
        super.wrap(concept);
        return this;
    }
}
