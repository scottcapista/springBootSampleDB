
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document
@Data
@Generated("jsonschema2pojo")
public class ReviewScores {

    @Field("review_scores_accuracy")
    @JsonProperty("reviewScoresAccuracy")
    private Integer review_scores_accuracy;
    @Field("review_scores_cleanliness")
    @JsonProperty("reviewScoresCleanliness")
    private Integer review_scores_cleanliness;
    @Field("review_scores_checkin")
    @JsonProperty("reviewScoresCheckin")
    private Integer review_scores_checkin;
    @Field("review_scores_communication")
    @JsonProperty("reviewScoresCommunication")
    private Integer review_scores_communication;
    @Field("review_scores_location")
    @JsonProperty("reviewScoresLocation")
    private Integer review_scores_location;
    @Field("review_scores_value")
    @JsonProperty("reviewScresValue")
    private Integer review_scores_value;
    @Field("review_scores_rating")
    @JsonProperty("reviewScoresRating")
    private Integer review_scores_rating;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
