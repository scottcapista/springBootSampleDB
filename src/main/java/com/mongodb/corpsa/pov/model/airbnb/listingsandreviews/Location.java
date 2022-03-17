
package com.mongodb.corpsa.pov.model.airbnb.listingsandreviews;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document
@Data
@Generated("jsonschema2pojo")
public class Location {
    @JsonProperty("type")
    private String type;
    @JsonProperty("coordinates")
    private List<Double> coordinates;
    @Field("is_location_exact")
    @JsonProperty("isLocationExact")
    private Boolean is_location_exact;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
