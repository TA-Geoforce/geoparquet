package com.tageofoce.geoparquet;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.PUBLIC_ONLY)
@JsonSerialize
public record Columns(PatternProperties patternProperties, Boolean additionalProperties) {
}
