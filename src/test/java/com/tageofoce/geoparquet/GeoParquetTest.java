package com.tageofoce.geoparquet;

import org.geotools.referencing.CRS;
import org.junit.Test;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;

import shaded.parquet.com.fasterxml.jackson.core.JsonProcessingException;
import shaded.parquet.com.fasterxml.jackson.databind.ObjectMapper;
import shaded.parquet.com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Set;

import static com.tageofoce.geoparquet.Geometry.MULTIPOINT;
import static org.geotools.referencing.crs.DefaultGeographicCRS.WGS84;


public class GeoParquetTest {


    private final ObjectMapper mapper = new ObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

    @Test
    public void serialize() throws JsonProcessingException, NoSuchAuthorityCodeException, FactoryException {

        Bbox bbox = new Bbox(-45.528989877500294, -8.8949185170263636, -45.456823063422924, -8.8557232445523315);

        //"columns":{"geometry":{"encoding":"WKB","bbox":[-45.528989877500294,-8.8949185170263636,-45.456823063422924,-8.8557232445523315],"orientation":"counterclockwise","geometry_types":["MultiPoint"]}}
        PatternProperties patternProperties = new PatternProperties("WKB", Set.of(MULTIPOINT), WGS84,
                Edges.PLANAR, "counterclockwise",
                bbox,
                0.1);
        Columns columns = new Columns(patternProperties, true);
        GeoParquet geoParquet = new GeoParquet("1.0.0-beta.1", "geometry", columns);


        String serializedList = mapper.writeValueAsString(geoParquet);

        System.out.println(serializedList);
    }

/*    @Test
    public void deserialize() throws IOException, URISyntaxException {
        // Given
        PatternProperties patternProperties = new PatternProperties("WKB", Set.of(MultiPoint.class), Edges.PLANAR, "counterclockwise", new Envelope(-45.528989877500294,-8.8949185170263636,-45.456823063422924,-8.8557232445523315), 0.1);
        Columns columns = new Columns(patternProperties, true);
        GeoParquet geoParquet = new GeoParquet("1.0.0-beta.1", "geometry", columns);

        var json = IOUtils.toString(GeoParquet.class.getResource("/example_metadata.json").toURI() , "UTF-8");
        // When
        GeoParquet deserialized = mapper.readValue(json, GeoParquet.class);

        // Then
        System.out.println(deserialized);
    }*/

}