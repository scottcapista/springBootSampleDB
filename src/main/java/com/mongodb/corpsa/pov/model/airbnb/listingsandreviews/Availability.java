
package com.mongodb.corpsa.pov.model.airbnb.listingsandreviews;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document
@Data
@Generated("jsonschema2pojo")
public class Availability {

    @Field("availability_30")
    @JsonProperty("availability30")
    private Integer availability_30;
    @Field("availability_60")
    @JsonProperty("availability60")
    private Integer availability_60;
    @Field("availability_90")
    @JsonProperty("availability90")
    private Integer availability_90;
    @Field("availability_365")
    @JsonProperty("availability365")
    private Integer availability_365;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
