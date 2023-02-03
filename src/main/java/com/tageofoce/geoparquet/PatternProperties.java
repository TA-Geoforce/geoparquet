package com.tageofoce.geoparquet;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Set;

import org.opengis.referencing.crs.CoordinateReferenceSystem;


@JsonSerialize
public record PatternProperties(
        String encoding,
        Set<Geometry> geometryTypes,

        @JsonSerialize(using = CoordinateReferenceSystemSerializer.class)
        CoordinateReferenceSystem crs,
        Edges edges,
        String orientation,
        Bbox bbox,
        double epoch) {
}
