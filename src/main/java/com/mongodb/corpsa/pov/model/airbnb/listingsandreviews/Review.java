
package com.mongodb.corpsa.pov.model.airbnb.listingsandreviews;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
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
@Data
@Document
@Generated("jsonschema2pojo")
public class Review {

    @JsonProperty("_id")
    private String id;
    @JsonProperty("date")
    private Instant date;
    @Field("listing_id")
    @JsonProperty("listingId")
    private String listing_id;
    @Field("reviewer_id")
    @JsonProperty("reviewerId")
    private String reviewer_id;
    @Field("reviewer_name")
    @JsonProperty("reviewerName")
    private String reviewer_name;
    @JsonProperty("comments")
    private String comments;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Review(String id, Instant date, String listing_id, String reviewer_id, String reviewer_name, String comments) {
        this.id = id;
        this.date = date;
        this.listing_id = listing_id;
        this.reviewer_id = reviewer_id;
        this.reviewer_name = reviewer_name;
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id.equals(review.id) && date.equals(review.date) && listing_id.equals(review.listing_id) && reviewer_id.equals(review.reviewer_id) && reviewer_name.equals(review.reviewer_name) && comments.equals(review.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, listing_id, reviewer_id, reviewer_name, comments);
    }
}
