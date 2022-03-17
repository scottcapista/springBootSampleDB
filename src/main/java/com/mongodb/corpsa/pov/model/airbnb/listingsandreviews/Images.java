
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
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
@Document
@Generated("jsonschema2pojo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Images {

    @Field("thumbnail_url")
    @JsonProperty("thumbnailUrl") private String thumbnail_url;
    @Field("medium_url")
    @JsonProperty("mediumUrl") private String medium_url;
    @Field("picture_url")
    @JsonProperty("pictureUrl") private String picture_url;
    @Field("xl_picture_url")
    @JsonProperty("xlPictureUrl") private String xl_picture_url;
    @JsonIgnore private Map<String, Object> additionalProperties = new HashMap<String, Object>();


}

