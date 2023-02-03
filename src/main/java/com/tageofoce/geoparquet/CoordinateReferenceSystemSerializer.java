package com.tageofoce.geoparquet;


import com.fasterxml.jackson.databind.JsonSerializer;

import java.io.IOException;

import org.opengis.referencing.crs.CoordinateReferenceSystem;


public class CoordinateReferenceSystemSerializer extends JsonSerializer<CoordinateReferenceSystem> {

    @Override
    public void serialize(CoordinateReferenceSystem value, com.fasterxml.jackson.core.JsonGenerator gen, com.fasterxml.jackson.databind.SerializerProvider serializers) throws IOException {
        gen.writeString(value.toWKT());
    }
}
