
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


@Data
@Document
@Generated("jsonschema2pojo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Host {

    @Field("host_id")
    @JsonProperty("hostId")
    private String host_id;
    @Field("host_url")
    @JsonProperty("hostUrl")
    private String host_url;
    @Field("host_name")
    @JsonProperty("hostName")
    private String host_name;
    @Field("host_location")
    @JsonProperty("hostLocation")
    private String host_location;
    @Field("host_about")
    @JsonProperty("hostAbout")
    private String host_about;
    @Field("host_response_time")
    @JsonProperty("hostResponseTime")
    private String host_response_time;
    @Field("host_thumbnail_url")
    @JsonProperty("hostThumbnailUrl")
    private String host_thumbnail_url;
    @Field("host_picture_url")
    @JsonProperty("hostPictureUrl")
    private String host_picture_url;
    @Field("host_neighbourhood")
    @JsonProperty("hostNeighbourhood")
    private String host_neighbourhood;
    @Field("host_response_rate")
    @JsonProperty("hostResponseRate")
    private Integer host_response_rate;
    @Field("host_is_superhost")
    @JsonProperty("hostIsSuperhost")
    private Boolean host_is_superhost;
    @Field("host_has_profile_pic")
    @JsonProperty("hostHasProfilePic")
    private Boolean host_has_profile_pic;
    @Field("host_identity_verified")
    @JsonProperty("hostIdentityVerified")
    private Boolean host_identity_verified;
    @Field("host_listings_count")
    @JsonProperty("hostListingsCount")
    private Integer host_listings_count;
    @Field("host_total_listings_count")
    @JsonProperty("hostTotalListingsCount")
    private Integer host_total_listings_count;
    @Field("host_verifications")
    @JsonProperty("hostVerifications")
    private List<String> host_verifications;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
}
