package com.mongodb.corpsa.pov.model.airbnb.aggregations;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

import static org.springframework.data.mongodb.core.mapping.FieldType.DECIMAL128;

@Document
@Data
public class Distance{
    @JsonProperty("calculated")
    @Field(name = "calculated")
    private Double calculated;
    @JsonProperty("unit")
    private String unit = "meters";

}
