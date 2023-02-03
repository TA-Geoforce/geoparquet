package com.tageofoce.geoparquet;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize
public record GeoParquet(
        String version,
        @JsonProperty("primary_column") String primaryColumn,
        Columns columns) {
}
