
package com.mongodb.corpsa.pov.model.airbnb.listingsandreviews;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document
@Data
@Generated("jsonschema2pojo")
public class Address {

    @JsonProperty("street")
    private String street;
    @JsonProperty("suburb")
    private String suburb;
    @Field("government_area")
    @JsonProperty("governmentArea")
    private String government_area;
    @JsonProperty("market")
    private String market;
    @JsonProperty("country")
    private String country;
    @Field("country_code")
    @JsonProperty("countryCode")
    private String country_code;
    @JsonProperty("location")
    private Location location;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
