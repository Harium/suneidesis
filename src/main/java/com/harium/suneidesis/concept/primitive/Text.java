package com.harium.suneidesis.concept.primitive;

import com.harium.suneidesis.concept.ConceptType;
import com.harium.suneidesis.concept.Primitive;

public class Text extends Primitive {

    public Text(String value) {
        super(value, ConceptType.DATA);
    }

    public boolean isUnknown() {
        return getType().isUnknown();
    }
}
