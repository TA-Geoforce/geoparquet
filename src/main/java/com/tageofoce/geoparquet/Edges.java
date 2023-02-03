package com.tageofoce.geoparquet;

public enum Edges {
    PLANAR("planar"),
    SPHERICAL("spherical");

    private final String value;
    Edges(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
