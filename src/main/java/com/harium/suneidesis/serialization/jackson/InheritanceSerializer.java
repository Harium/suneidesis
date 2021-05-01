package com.harium.suneidesis.serialization.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.harium.suneidesis.concept.Concept;
import com.harium.suneidesis.concept.attribute.Inheritance;

import java.io.IOException;
import java.util.Map;

public class InheritanceSerializer extends StdSerializer<Inheritance> {

    public InheritanceSerializer() {
        this(null);
    }

    protected InheritanceSerializer(Class<Inheritance> t) {
        super(t);
    }

    @Override
    public void serialize(Inheritance inheritance, JsonGenerator jgen, SerializerProvider serializerProvider) throws IOException {
        jgen.writeStartArray();
        for (Map.Entry<String, Concept> entry : inheritance.getMap().entrySet()) {
            jgen.writeString(entry.getValue().getIdText());
        }
        jgen.writeEndArray();
    }

}
