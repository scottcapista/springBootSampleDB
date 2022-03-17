package com.mongodb.corpsa.pov.model.airbnb.aggregations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.corpsa.pov.model.airbnb.listingsandreviews.Images;
import com.mongodb.corpsa.pov.model.airbnb.listingsandreviews.Address;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.data.mongodb.core.mapping.FieldType.DECIMAL128;

@Document
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListingsByLocation {
    @Id
    public String id;
    @Field("listing_url")
    @JsonProperty("listingUrl")
    public String listing_url;
    @JsonProperty("name")
    public String name;
    @JsonProperty("accommodates")
    public Integer accommodates;
    @JsonProperty("bedrooms")
    public Integer bedrooms;
    @JsonProperty("images")
    public Images images;
    @JsonProperty("address")
    public Address address;
    @JsonProperty("distance")
    public Distance distance;
    @JsonProperty("isSuperhost")
    public Boolean isSuperhost;
    @JsonIgnore
    private Map<String, Object> additionalProperties;


}
