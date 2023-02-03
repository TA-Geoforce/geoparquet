package com.tageofoce.geoparquet;

public enum Geometry {

    POINT("Point"),
    MULTIPOINT("Multipoint");

    private String value;
    Geometry(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
